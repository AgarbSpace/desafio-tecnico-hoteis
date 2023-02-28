package com.desafiohoteis.api.Model;

import com.desafiohoteis.api.DTO.RestrictCpfDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
public class RestrictCpf {
  
	public RestrictCpf(RestrictCpfDTO data) {
		LocalDateTime now = LocalDateTime.now();
		String isoDateTime = now.format(DateTimeFormatter.ISO_DATE_TIME);
		this.createdAt = isoDateTime + "Z";
		this.cpf = data.cpf();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 11, nullable = false)
	private String cpf;

	@Column(length = 30, nullable = false)
	private String createdAt;
}
