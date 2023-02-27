package com.desafiohoteis.api.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.desafiohoteis.api.Model.RestrictCpf;

@Repository
public interface RestrictCpfRepository extends JpaRepository<RestrictCpf, Long> {
    
}
