package com.sunknowledge.dme.rcm.repository.usps;

import com.sunknowledge.dme.rcm.domain.usps.DPVFootnotesMaster;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.rowmapper.DPVFootnotesMasterRowMapper;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.convert.R2dbcConverter;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.support.SimpleR2dbcRepository;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Condition;
import org.springframework.data.relational.core.sql.Conditions;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.relational.core.sql.SelectBuilder.SelectFromAndJoin;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.data.relational.repository.support.MappingRelationalEntityInformation;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC custom repository implementation for the DPVFootnotesMaster entity.
 */
@SuppressWarnings("unused")
class DPVFootnotesMasterRepositoryInternalImpl
    extends SimpleR2dbcRepository<DPVFootnotesMaster, Long>
    implements DPVFootnotesMasterRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final DPVFootnotesMasterRowMapper dpvfootnotesmasterMapper;

    private static final Table entityTable = Table.aliased("dpv_footnotes_master", EntityManager.ENTITY_ALIAS);

    public DPVFootnotesMasterRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        DPVFootnotesMasterRowMapper dpvfootnotesmasterMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(DPVFootnotesMaster.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.dpvfootnotesmasterMapper = dpvfootnotesmasterMapper;
    }

    @Override
    public Flux<DPVFootnotesMaster> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<DPVFootnotesMaster> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = DPVFootnotesMasterSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        SelectFromAndJoin selectFrom = Select.builder().select(columns).from(entityTable);
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, DPVFootnotesMaster.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<DPVFootnotesMaster> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<DPVFootnotesMaster> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("dpv_footnotes_id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private DPVFootnotesMaster process(Row row, RowMetadata metadata) {
        DPVFootnotesMaster entity = dpvfootnotesmasterMapper.apply(row, "e");
        return entity;
    }

    @Override
    public <S extends DPVFootnotesMaster> Mono<S> save(S entity) {
        return super.save(entity);
    }
}
