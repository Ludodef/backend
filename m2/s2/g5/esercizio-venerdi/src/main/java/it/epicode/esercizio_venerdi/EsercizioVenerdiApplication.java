package it.epicode.esercizio_venerdi;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsercizioVenerdiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioVenerdiApplication.class, args);
	}


}
