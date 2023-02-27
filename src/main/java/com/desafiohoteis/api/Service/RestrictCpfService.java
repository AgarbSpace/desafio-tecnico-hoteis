package com.desafiohoteis.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafiohoteis.api.Repository.RestrictCpfRepository;
import com.desafiohoteis.api.DTO.RestrictCpfDTO;
import com.desafiohoteis.api.Model.RestrictCpf;
import java.util.List;

@Service
public class RestrictCpfService {
  
	@Autowired
	RestrictCpfRepository repository;

	public void create(RestrictCpfDTO dto) {
		repository.save(new RestrictCpf(dto));
	}

	public List<RestrictCpf> read() {
		return repository.findAll();
	}

	public void update(Long id, RestrictCpfDTO dto) {
		repository.findById(id).map(
				cpf -> {
					cpf.setCpf(dto.cpf());
					return repository.save(cpf);
				});
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
