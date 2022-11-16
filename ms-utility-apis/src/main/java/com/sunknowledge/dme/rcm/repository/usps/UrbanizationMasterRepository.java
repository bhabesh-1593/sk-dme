package com.sunknowledge.dme.rcm.repository.usps;

import com.sunknowledge.dme.rcm.domain.usps.UrbanizationMaster;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the UrbanizationMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UrbanizationMasterRepository
    extends ReactiveCrudRepository<UrbanizationMaster, Long>, UrbanizationMasterRepositoryInternal {
    @Override
    <S extends UrbanizationMaster> Mono<S> save(S entity);

    @Override
    Flux<UrbanizationMaster> findAll();

    @Override
    Mono<UrbanizationMaster> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface UrbanizationMasterRepositoryInternal {
    <S extends UrbanizationMaster> Mono<S> save(S entity);

    Flux<UrbanizationMaster> findAllBy(Pageable pageable);

    Flux<UrbanizationMaster> findAll();

    Mono<UrbanizationMaster> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<UrbanizationMaster> findAllBy(Pageable pageable, Criteria criteria);

}
