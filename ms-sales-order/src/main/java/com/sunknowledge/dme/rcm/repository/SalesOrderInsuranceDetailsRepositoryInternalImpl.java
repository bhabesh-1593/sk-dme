package com.sunknowledge.dme.rcm.repository;

import static org.springframework.data.relational.core.query.Criteria.where;

import com.sunknowledge.dme.rcm.domain.SalesOrderInsuranceDetails;
import com.sunknowledge.dme.rcm.repository.rowmapper.SalesOrderInsuranceDetailsRowMapper;
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
 * Spring Data R2DBC custom repository implementation for the SalesOrderInsuranceDetails entity.
 */
@SuppressWarnings("unused")
class SalesOrderInsuranceDetailsRepositoryInternalImpl
    extends SimpleR2dbcRepository<SalesOrderInsuranceDetails, Long>
    implements SalesOrderInsuranceDetailsRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final SalesOrderMasterRowMapper salesordermasterMapper;
    private final SalesOrderInsuranceDetailsRowMapper salesorderinsurancedetailsMapper;

    private static final Table entityTable = Table.aliased("t_sales_order_insurance_details", EntityManager.ENTITY_ALIAS);
    private static final Table salesOrderMasterTable = Table.aliased("t_sales_order_master", "salesOrderMaster");

    public SalesOrderInsuranceDetailsRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        SalesOrderMasterRowMapper salesordermasterMapper,
        SalesOrderInsuranceDetailsRowMapper salesorderinsurancedetailsMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter
    ) {
        super(
            new MappingRelationalEntityInformation(
                converter.getMappingContext().getRequiredPersistentEntity(SalesOrderInsuranceDetails.class)
            ),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.salesordermasterMapper = salesordermasterMapper;
        this.salesorderinsurancedetailsMapper = salesorderinsurancedetailsMapper;
    }

    @Override
    public Flux<SalesOrderInsuranceDetails> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<SalesOrderInsuranceDetails> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = SalesOrderInsuranceDetailsSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        columns.addAll(SalesOrderMasterSqlHelper.getColumns(salesOrderMasterTable, "salesOrderMaster"));
        SelectFromAndJoinCondition selectFrom = Select
            .builder()
            .select(columns)
            .from(entityTable)
            .leftOuterJoin(salesOrderMasterTable)
            .on(Column.create("sales_order_master_sales_order_id", entityTable))
            .equals(Column.create("sales_order_id", salesOrderMasterTable));
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, SalesOrderInsuranceDetails.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<SalesOrderInsuranceDetails> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<SalesOrderInsuranceDetails> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("sales_order_insurance_details_id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private SalesOrderInsuranceDetails process(Row row, RowMetadata metadata) {
        SalesOrderInsuranceDetails entity = salesorderinsurancedetailsMapper.apply(row, "e");
        entity.setSalesOrderMaster(salesordermasterMapper.apply(row, "salesOrderMaster"));
        return entity;
    }

    @Override
    public <S extends SalesOrderInsuranceDetails> Mono<S> save(S entity) {
        return super.save(entity);
    }
}
