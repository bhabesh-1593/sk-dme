package com.sunknowledge.dme.rcm.repository;

import static org.springframework.data.relational.core.query.Criteria.where;

import com.sunknowledge.dme.rcm.domain.SalesOrderItemDetails;
import com.sunknowledge.dme.rcm.repository.rowmapper.SalesOrderItemDetailsRowMapper;
import com.sunknowledge.dme.rcm.repository.rowmapper.SalesOrderMasterRowMapper;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiFunction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.convert.R2dbcConverter;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.support.SimpleR2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Condition;
import org.springframework.data.relational.core.sql.Conditions;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.relational.core.sql.SelectBuilder.SelectFromAndJoinCondition;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.data.relational.repository.support.MappingRelationalEntityInformation;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC custom repository implementation for the SalesOrderItemDetails entity.
 */
@SuppressWarnings("unused")
class SalesOrderItemDetailsRepositoryInternalImpl
    extends SimpleR2dbcRepository<SalesOrderItemDetails, Long>
    implements SalesOrderItemDetailsRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final SalesOrderMasterRowMapper salesordermasterMapper;
    private final SalesOrderItemDetailsRowMapper salesorderitemdetailsMapper;

    private static final Table entityTable = Table.aliased("t_sales_order_item_details", EntityManager.ENTITY_ALIAS);
    private static final Table itemDetailsTable = Table.aliased("t_sales_order_master", "itemDetails");

    public SalesOrderItemDetailsRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        SalesOrderMasterRowMapper salesordermasterMapper,
        SalesOrderItemDetailsRowMapper salesorderitemdetailsMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(SalesOrderItemDetails.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.salesordermasterMapper = salesordermasterMapper;
        this.salesorderitemdetailsMapper = salesorderitemdetailsMapper;
    }

    @Override
    public Flux<SalesOrderItemDetails> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<SalesOrderItemDetails> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = SalesOrderItemDetailsSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        columns.addAll(SalesOrderMasterSqlHelper.getColumns(itemDetailsTable, "itemDetails"));
        SelectFromAndJoinCondition selectFrom = Select
            .builder()
            .select(columns)
            .from(entityTable)
            .leftOuterJoin(itemDetailsTable)
            .on(Column.create("item_details_sales_order_id", entityTable))
            .equals(Column.create("sales_order_id", itemDetailsTable));
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, SalesOrderItemDetails.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<SalesOrderItemDetails> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<SalesOrderItemDetails> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("sales_order_item_details_id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private SalesOrderItemDetails process(Row row, RowMetadata metadata) {
        SalesOrderItemDetails entity = salesorderitemdetailsMapper.apply(row, "e");
        entity.setItemDetails(salesordermasterMapper.apply(row, "itemDetails"));
        return entity;
    }

    @Override
    public <S extends SalesOrderItemDetails> Mono<S> save(S entity) {
        return super.save(entity);
    }
}
