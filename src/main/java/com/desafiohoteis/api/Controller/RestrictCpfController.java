package com.desafiohoteis.api.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.*;

import com.desafiohoteis.api.DTO.RestrictCpfDTO;
import com.desafiohoteis.api.Service.RestrictCpfService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.desafiohoteis.api.Model.*;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cpf")
public class RestrictCpfController {
  
	@Autowired
	RestrictCpfService service;

	@PostMapping
	public void create(@RequestBody RestrictCpfDTO req) {
		service.create(req);
	}
	
	@GetMapping
	public List<RestrictCpf> read() {
		return service.read();
	}

	@PutMapping("/{cpf}")
	public void update(@PathVariable String cpf, @RequestBody @Valid RestrictCpfDTO req) {
		service.update(cpf, req);
	}
	
	@DeleteMapping("/{cpf}")
	public void delete(@PathVariable String cpf, @RequestBody @Valid RestrictCpfDTO req) {
		service.delete(cpf);
	}
}
