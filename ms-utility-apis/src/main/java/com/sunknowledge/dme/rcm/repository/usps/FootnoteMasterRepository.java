package com.sunknowledge.dme.rcm.repository.usps;

import com.sunknowledge.dme.rcm.domain.usps.FootnoteMaster;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the FootnoteMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FootnoteMasterRepository extends ReactiveCrudRepository<FootnoteMaster, Long>, FootnoteMasterRepositoryInternal {
    @Override
    <S extends FootnoteMaster> Mono<S> save(S entity);

    @Override
    Flux<FootnoteMaster> findAll();

    @Override
    Mono<FootnoteMaster> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);

    Mono<FootnoteMaster> getFootnoteDetailsByEnumerations(String enumerations);
}

interface FootnoteMasterRepositoryInternal {
    <S extends FootnoteMaster> Mono<S> save(S entity);

    Flux<FootnoteMaster> findAllBy(Pageable pageable);

    Flux<FootnoteMaster> findAll();

    Mono<FootnoteMaster> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<FootnoteMaster> findAllBy(Pageable pageable, Criteria criteria);

}
