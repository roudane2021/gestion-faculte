package com.gestion.service.application.departement;


import com.gestion.service.application.common.execption.GestionException;
import com.gestion.service.application.departement.models.Departement;
import com.gestion.service.application.departement.models.DepartementFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartementApplication {
    Departement save(Departement departement);
    Departement getDepartement(String code) throws GestionException;

    Page<Departement> searchDepartements(Pageable pageable, DepartementFilter departementFilter);
    List<Departement> listOfAllDepartement();
}