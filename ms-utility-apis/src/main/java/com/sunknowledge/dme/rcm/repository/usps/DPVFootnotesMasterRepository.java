package com.sunknowledge.dme.rcm.repository.usps;

import com.sunknowledge.dme.rcm.domain.usps.DPVFootnotesMaster;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the DPVFootnotesMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DPVFootnotesMasterRepository
    extends ReactiveCrudRepository<DPVFootnotesMaster, Long>, DPVFootnotesMasterRepositoryInternal {
    @Override
    <S extends DPVFootnotesMaster> Mono<S> save(S entity);

    @Override
    Flux<DPVFootnotesMaster> findAll();

    @Override
    Mono<DPVFootnotesMaster> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);

    //@Query("FROM DPVFootnotesMaster WHERE enumerations = :enumerations")
    Mono<DPVFootnotesMaster> getDPVFootnoteDetailsByDefinition(String definition);
}

interface DPVFootnotesMasterRepositoryInternal {
    <S extends DPVFootnotesMaster> Mono<S> save(S entity);

    Flux<DPVFootnotesMaster> findAllBy(Pageable pageable);

    Flux<DPVFootnotesMaster> findAll();

    Mono<DPVFootnotesMaster> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<DPVFootnotesMaster> findAllBy(Pageable pageable, Criteria criteria);

}
