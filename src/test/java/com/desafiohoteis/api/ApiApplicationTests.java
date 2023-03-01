package com.desafiohoteis.api;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafiohoteis.api.Exceptions.ExistsCpfException;
import com.desafiohoteis.api.Exceptions.InvalidCpfException;
import com.desafiohoteis.api.Exceptions.NotFoundCpfException;
import com.desafiohoteis.api.Model.RestrictCpf;
import com.desafiohoteis.api.Repository.RestrictCpfRepository;
import com.desafiohoteis.api.Service.RestrictCpfService;
import com.desafiohoteis.api.DTO.RestrictCpfDTO;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ApiApplicationTests {

	@InjectMocks
	private RestrictCpfService service;

	@Mock(lenient = true)
	private RestrictCpfRepository repository;

	private RestrictCpfDTO validCpfDto = new RestrictCpfDTO("12345678910");;
	private RestrictCpfDTO invalidCpfDto = new RestrictCpfDTO("11111111111");
	private RestrictCpfDTO updateValidCpfDto = new RestrictCpfDTO("9876543219");
	private RestrictCpfDTO updateInvalidCpfDto = new RestrictCpfDTO("222222222222");
	private RestrictCpf validCpf = new RestrictCpf(validCpfDto);
	private RestrictCpf invalidCpf = new RestrictCpf(invalidCpfDto);

	@Test
	@DisplayName("Should add an valid cpf on list")
	void addValidCpf() {
		when(repository.existsByCpf(validCpf.getCpf())).thenReturn(false);

		service.create(validCpfDto);

		verify(repository).save(any(RestrictCpf.class));
	}

	@Test
	@DisplayName("Should throw ExistsCpfException when CPF already exists")
	void testExistsCpfException() {
		when(repository.existsByCpf(validCpf.getCpf())).thenReturn(true);

		assertThrows(ExistsCpfException.class, () -> service.create(validCpfDto));

		verify(repository, never()).save(any(RestrictCpf.class));
	}

	@Test
	@DisplayName("Should throw InvalidCpfException when CPF has repeated digits or more than 11 digits")
	void testCreate_InvalidCpfException() {

		assertThrows(InvalidCpfException.class, () -> service.create(invalidCpfDto));

		verify(repository, never()).save(any(RestrictCpf.class));
	}

	@Test
	@DisplayName("Should read all CPFs successfully")
	void testRead() {
		List<RestrictCpf> list = new ArrayList<>();
		when(repository.findAll()).thenReturn(list);

		List<RestrictCpf> result = service.read();

		assertSame(list, result);
		verify(repository).findAll();
	}

	@Test
    @DisplayName("Should return an empty list")
    void testReadEmptyList() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<RestrictCpf> result = service.read();
        assertTrue(result.isEmpty());
    }

	@Test
	@DisplayName("Should find a CPF successfully")
	void testFindByCpf() {
		when(repository.existsByCpf(validCpf.getCpf())).thenReturn(true);
		when(repository.findByCpf(validCpf.getCpf())).thenReturn(validCpf);

		RestrictCpf result = service.findByCpf(validCpf.getCpf());

		assertSame(validCpf, result);
		verify(repository).findByCpf(validCpf.getCpf());
	}

	@Test
	@DisplayName("Should throw NotFoundCpfException when CPF doesn't exist")
	void testFindByCpf_NotFoundCpfException() {
		when(repository.existsByCpf(validCpf.getCpf())).thenReturn(false);
		
		assertThrows(NotFoundCpfException.class, () -> service.findByCpf(validCpf.getCpf()));
		
		verify(repository, never()).findByCpf(validCpf.getCpf());
	}

	@Test
	@DisplayName("Should throw InvalidCpfException when CPF has repeated digits or more than 11 digits")
	void testFind_InvalidCpfException() {

		assertThrows(InvalidCpfException.class, () -> service.findByCpf(invalidCpfDto.cpf()));

		verify(repository, never()).findByCpf(invalidCpf.getCpf());
	}

	@Test
	@DisplayName("Should update an CPF given a new valid CPF")
	public void testUpdateWithValidCpf() {
		when(repository.existsByCpf(validCpf.getCpf())).thenReturn(true);

		service.update(validCpf.getCpf(), updateValidCpfDto);

		verify(repository, times(1)).updateCpf(updateValidCpfDto.cpf(), validCpf.getCpf());
	}

	@Test
	@DisplayName("Should throw InvalidCpfException when CPF has repeated digits or more than 11 digits")
	void testUpdate_InvalidCpfException() {
		assertThrows(InvalidCpfException.class, () -> service.update(validCpf.getCpf(), invalidCpfDto));

		verify(repository, never()).updateCpf(updateInvalidCpfDto.cpf(), validCpf.getCpf());
	}

	@Test
	@DisplayName("Should throw NotFoundCpfException when CPF doesn't exist")
	void testUpdate_NotFoundCpfException() {
		when(repository.existsByCpf(validCpf.getCpf())).thenReturn(false);
		
		assertThrows(NotFoundCpfException.class, () -> service.update(validCpf.getCpf(), updateValidCpfDto));
		
		verify(repository, never()).updateCpf(updateInvalidCpfDto.cpf(), validCpf.getCpf());
	}

	@Test
	@DisplayName("Should delete an CPF given a new valid CPF")
	public void testDeleteWithValidCpf() {
		when(repository.existsByCpf(validCpf.getCpf())).thenReturn(true);

		assertDoesNotThrow(() -> service.delete(validCpf.getCpf()));

		verify(repository, times(1)).deleteByCpf(validCpf.getCpf());
	}

	@Test
	@DisplayName("Should throw InvalidCpfException when CPF has repeated digits or more than 11 digits")
	void testDelete_InvalidCpfException() {
		assertThrows(InvalidCpfException.class, () -> service.delete(invalidCpf.getCpf()));

		verify(repository, never()).deleteByCpf(invalidCpf.getCpf());
	}

	@Test
	@DisplayName("Should throw NotFoundCpfException when CPF doesn't exist")
	void testDelete_NotFoundCpfException() {
		when(repository.existsByCpf(validCpf.getCpf())).thenReturn(false);
		
		assertThrows(NotFoundCpfException.class, () -> service.delete(validCpf.getCpf()));
		
		verify(repository, never()).deleteByCpf(validCpf.getCpf());
	}


}
