package com.gestion.web;

import com.gestion.infrastructure.repositories.impl.DepartementRepository;
import com.gestion.model.entities.DepartementEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.gestion.*"})
@EntityScan("com.gestion.model")
@EnableJpaRepositories("com.gestion.infrastructure.repositories")
public class GestionApplication  implements CommandLineRunner {

  private  DepartementRepository departementRepository;

    public GestionApplication(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(GestionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DepartementEntity departement;
        departement = DepartementEntity.builder().code("1234").nom("INFORMATIQUE").libelle("INFO").build();
        departementRepository.save(departement);
        departement = DepartementEntity.builder().code("1235").nom("MATHEMATIQUE").libelle("MATH").build();
        departementRepository.save(departement);
        departement = DepartementEntity.builder().code("1236").nom("PHYSIQUE").libelle("PH").build();
        departementRepository.save(departement);
        departement = DepartementEntity.builder().code("1237").nom("Science").libelle("Sc").build();
        departementRepository.save(departement);
    }
}
