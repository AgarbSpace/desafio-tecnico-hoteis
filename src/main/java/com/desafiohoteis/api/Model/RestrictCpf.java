package com.desafiohoteis.api.Model;

import com.desafiohoteis.api.DTO.RestrictCpfDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class RestrictCpf {
  
	public RestrictCpf(RestrictCpfDTO data) {
		this.cpf = data.cpf();
		this.createdAt = data.createdAt();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 11, nullable = false)
	private String cpf;

	@Column(length = 24, nullable = false)
	private Date createdAt;
}
