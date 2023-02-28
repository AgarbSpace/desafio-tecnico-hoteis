package com.desafiohoteis.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiohoteis.api.Repository.RestrictCpfRepository;
import com.desafiohoteis.api.Utils.StringUtil;
import com.desafiohoteis.api.DTO.RestrictCpfDTO;
import com.desafiohoteis.api.Exceptions.ExistsCpfException;
import com.desafiohoteis.api.Exceptions.InvalidCpfException;
import com.desafiohoteis.api.Exceptions.NotFoundCpfException;
import com.desafiohoteis.api.Model.RestrictCpf;
import java.util.List;

@Service
public class RestrictCpfService {

	String notFoundCpf = "Cpf não encontrado";
	String numbersAreEqual = "Cpf não pode ter dígitos repetidos";
	String conflict = "Conflito: Cpf já está na lista ";
  
	@Autowired
	RestrictCpfRepository repository;

	public void create(RestrictCpfDTO dto) {
		String cpf = dto.cpf();
		boolean cpfExists = repository.existsByCpf(cpf);
		
		if (cpfExists) {
			throw new ExistsCpfException(conflict);
		}

		boolean allNumbersAreEqual = StringUtil.allNumbersAreEqual(cpf);

		if (allNumbersAreEqual) {
			throw new InvalidCpfException(numbersAreEqual);
		}

		repository.save(new RestrictCpf(dto));
	}

	public List<RestrictCpf> read() {
		return repository.findAll();
	}

	public RestrictCpf findByCpf(String cpf) {

		boolean cpfExists = repository.existsByCpf(cpf);

		if (!cpfExists) {
			throw new NotFoundCpfException(notFoundCpf);
		}

		boolean allNumbersAreEqual = StringUtil.allNumbersAreEqual(cpf);

		if (allNumbersAreEqual) {
			throw new InvalidCpfException(numbersAreEqual);
		}

		return repository.findByCpf(cpf);
	}

	@Transactional
	public void update(String cpf, RestrictCpfDTO dto) {
		boolean cpfExists = repository.existsByCpf(cpf);

		if (!cpfExists) {
			throw new NotFoundCpfException(notFoundCpf);
		}

		boolean allNumbersAreEqual = StringUtil.allNumbersAreEqual(cpf);

		if (allNumbersAreEqual) {
			throw new InvalidCpfException(numbersAreEqual);
		}

		repository.updateCpf(dto.cpf(), cpf);
	}
	
	@Transactional
	public void delete(String cpf) {
		boolean cpfExists = repository.existsByCpf(cpf);

		if (!cpfExists) {
			throw new NotFoundCpfException(notFoundCpf);
		}

		boolean allNumbersAreEqual = StringUtil.allNumbersAreEqual(cpf);

		if (allNumbersAreEqual) {
			throw new InvalidCpfException(numbersAreEqual);
		}

		repository.deleteByCpf(cpf);
	}
}
