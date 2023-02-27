package com.desafiohoteis.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafiohoteis.api.Repository.RestrictCpfRepository;
import com.desafiohoteis.api.DTO.RestrictCpfDTO;
import com.desafiohoteis.api.Model.RestrictCpf;

@Service
public class RestrictCpfService {
  
	@Autowired
	RestrictCpfRepository repository;

	public void save(RestrictCpfDTO dto) {
		repository.save(new RestrictCpf(dto));
	}
}
