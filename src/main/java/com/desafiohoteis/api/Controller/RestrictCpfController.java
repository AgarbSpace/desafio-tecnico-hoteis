package com.desafiohoteis.api.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.desafiohoteis.api.Service.RestrictCpfService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cpf")
public class RestrictCpfController {
  
	@Autowired
	RestrictCpfService service;

}
