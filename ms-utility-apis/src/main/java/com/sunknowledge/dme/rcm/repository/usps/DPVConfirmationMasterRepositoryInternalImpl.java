package com.sunknowledge.dme.rcm.repository.usps;

import com.sunknowledge.dme.rcm.domain.usps.DPVConfirmationMaster;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.rowmapper.DPVConfirmationMasterRowMapper;
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
 * Spring Data R2DBC custom repository implementation for the DPVConfirmationMaster entity.
 */
@SuppressWarnings("unused")
class DPVConfirmationMasterRepositoryInternalImpl
    extends SimpleR2dbcRepository<DPVConfirmationMaster, Long>
    implements DPVConfirmationMasterRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final DPVConfirmationMasterRowMapper dpvconfirmationmasterMapper;

    private static final Table entityTable = Table.aliased("dpv_confirmation_master", EntityManager.ENTITY_ALIAS);

    public DPVConfirmationMasterRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        DPVConfirmationMasterRowMapper dpvconfirmationmasterMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(DPVConfirmationMaster.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.dpvconfirmationmasterMapper = dpvconfirmationmasterMapper;
    }

    @Override
    public Flux<DPVConfirmationMaster> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<DPVConfirmationMaster> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = DPVConfirmationMasterSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        SelectFromAndJoin selectFrom = Select.builder().select(columns).from(entityTable);
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, DPVConfirmationMaster.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<DPVConfirmationMaster> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<DPVConfirmationMaster> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("dpv_confirmation_id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private DPVConfirmationMaster process(Row row, RowMetadata metadata) {
        DPVConfirmationMaster entity = dpvconfirmationmasterMapper.apply(row, "e");
        return entity;
    }

    @Override
    public <S extends DPVConfirmationMaster> Mono<S> save(S entity) {
        return super.save(entity);
    }
}
