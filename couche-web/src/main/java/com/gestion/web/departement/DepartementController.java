package com.gestion.web.departement;

import com.gestion.service.application.departement.IDepartementApplication;
import com.gestion.web.departement.dto.DepartementDto;
import com.gestion.web.departement.mapper.IDepartementDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/depatemant")
public class DepartementController {

    private final  IDepartementApplication departementApplication;
    private final IDepartementDtoMapper departementMapper;

    public DepartementController(IDepartementApplication departementApplication, IDepartementDtoMapper departementMapper) {
        this.departementApplication = departementApplication;
        this.departementMapper = departementMapper;
    }

    @GetMapping("/all")
    private List<DepartementDto> list() {

        return departementMapper.departementDtos(departementApplication.listOfAllDepartement());
    }
}
