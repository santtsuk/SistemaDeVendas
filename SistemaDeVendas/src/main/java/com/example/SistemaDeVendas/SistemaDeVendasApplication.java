package com.example.SistemaDeVendas;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.repositories.CargoRepositoryMySql;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class 	SistemaDeVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeVendasApplication.class, args);

	}
}
