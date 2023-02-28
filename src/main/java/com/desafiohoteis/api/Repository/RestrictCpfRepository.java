package com.desafiohoteis.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafiohoteis.api.Model.RestrictCpf;

public interface RestrictCpfRepository extends JpaRepository<RestrictCpf, Long> {
    RestrictCpf findByCpf(String cpf);

    @Modifying
    @Query("DELETE FROM RestrictCpf c WHERE c.cpf = ?1")
    void deleteByCpf(String cpf);

    @Modifying
	@Query("UPDATE RestrictCpf c SET c.cpf = :newCpf WHERE c.cpf = :oldCpf")
    void updateCpf(@Param("newCpf") String newCpf, @Param("oldCpf") String oldCpf);

    boolean existsByCpf(String cpf);
}
