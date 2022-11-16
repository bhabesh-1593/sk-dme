package com.sunknowledge.dme.rcm.repository.usps;

import com.sunknowledge.dme.rcm.domain.usps.DPVConfirmationMaster;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the DPVConfirmationMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DPVConfirmationMasterRepository
    extends ReactiveCrudRepository<DPVConfirmationMaster, Long>, DPVConfirmationMasterRepositoryInternal {
    @Override
    <S extends DPVConfirmationMaster> Mono<S> save(S entity);

    @Override
    Flux<DPVConfirmationMaster> findAll();

    @Override
    Mono<DPVConfirmationMaster> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);

    Mono<DPVConfirmationMaster> getDPVConfirmationDetailsByEnumerations(String enumerations);
}

interface DPVConfirmationMasterRepositoryInternal {
    <S extends DPVConfirmationMaster> Mono<S> save(S entity);

    Flux<DPVConfirmationMaster> findAllBy(Pageable pageable);

    Flux<DPVConfirmationMaster> findAll();

    Mono<DPVConfirmationMaster> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<DPVConfirmationMaster> findAllBy(Pageable pageable, Criteria criteria);

}
