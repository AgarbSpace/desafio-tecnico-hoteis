package com.desafiohoteis.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiohoteis.api.Repository.RestrictCpfRepository;
import com.desafiohoteis.api.DTO.RestrictCpfDTO;
import com.desafiohoteis.api.Model.RestrictCpf;
import java.util.List;

@Service
public class RestrictCpfService {
  
	@Autowired
	RestrictCpfRepository repository;

	public void create(RestrictCpfDTO dto) {
		boolean cpfExists = repository.existsByCpf(dto.cpf());
		if (cpfExists) {
			
		}

		repository.save(new RestrictCpf(dto));
	}

	public List<RestrictCpf> read() {
		return repository.findAll();
	}

	@Transactional
	public void update(String cpf, RestrictCpfDTO dto) {
		repository.updateCpf(dto.cpf(), cpf);
	}
	
	@Transactional
	public void delete(String cpf) {
		repository.deleteByCpf(cpf);
	}
}
