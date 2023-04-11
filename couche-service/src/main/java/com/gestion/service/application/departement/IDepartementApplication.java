package com.gestion.service.application.departement;


import com.gestion.service.application.departement.models.Departement;

import java.util.List;

public interface IDepartementApplication {
    Departement save(Departement departement);
    List<Departement> listOfAllDepartement();
}
