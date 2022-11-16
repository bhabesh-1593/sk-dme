package com.sunknowledge.dme.rcm.repository;

import com.sunknowledge.dme.rcm.domain.SalesOrderFinancialDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the SalesOrderFinancialDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SalesOrderFinancialDetailsRepository
    extends ReactiveCrudRepository<SalesOrderFinancialDetails, Long>, SalesOrderFinancialDetailsRepositoryInternal {
    Flux<SalesOrderFinancialDetails> findAllBy(Pageable pageable);

    @Query("SELECT * FROM t_sales_order_financial_details entity WHERE entity.sales_order_master_sales_order_id = :id")
    Flux<SalesOrderFinancialDetails> findBySalesOrderMaster(Long id);

    @Query("SELECT * FROM t_sales_order_financial_details entity WHERE entity.sales_order_master_sales_order_id IS NULL")
    Flux<SalesOrderFinancialDetails> findAllWhereSalesOrderMasterIsNull();

    @Override
    <S extends SalesOrderFinancialDetails> Mono<S> save(S entity);

    @Override
    Flux<SalesOrderFinancialDetails> findAll();

    @Override
    Mono<SalesOrderFinancialDetails> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface SalesOrderFinancialDetailsRepositoryInternal {
    <S extends SalesOrderFinancialDetails> Mono<S> save(S entity);

    Flux<SalesOrderFinancialDetails> findAllBy(Pageable pageable);

    Flux<SalesOrderFinancialDetails> findAll();

    Mono<SalesOrderFinancialDetails> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<SalesOrderFinancialDetails> findAllBy(Pageable pageable, Criteria criteria);

}
