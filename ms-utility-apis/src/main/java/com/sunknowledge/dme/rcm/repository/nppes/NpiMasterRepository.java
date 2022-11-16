package com.sunknowledge.dme.rcm.repository.nppes;

import com.sunknowledge.dme.rcm.domain.nppes.NpiMaster;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the NpiMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NpiMasterRepository extends ReactiveCrudRepository<NpiMaster, Long>, NpiMasterRepositoryInternal {
    @Override
    <S extends NpiMaster> Mono<S> save(S entity);

    @Override
    Flux<NpiMaster> findAll();

    @Override
    Mono<NpiMaster> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);

    //@Query("INSERT INTO jhi_user_authority VALUES(:npiNumber, :npiName, :address, :enumerationType, :phone)")
    //Mono<Void> saveNPIMasterData(String npiNumber, String npiName, String address, String enumerationType, String phone);

    //Mono<NpiMaster> getNpiNumberByNpiNumber(String npiNumber);
    //@Query("SELECT * FROM NpiMaster WHERE npiNumber = :npiNumber")
    @Query(value = "SELECT * FROM t_nppes_npi_master WHERE npi_number = :npiNumber")
    Mono<NpiMaster> getNpiNumberByNpiNumber(@Param("npiNumber") String npiNumber);
}

interface NpiMasterRepositoryInternal {
    <S extends NpiMaster> Mono<S> save(S entity);

    Flux<NpiMaster> findAllBy(Pageable pageable);

    Flux<NpiMaster> findAll();

    Mono<NpiMaster> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<NpiMaster> findAllBy(Pageable pageable, Criteria criteria);

}
