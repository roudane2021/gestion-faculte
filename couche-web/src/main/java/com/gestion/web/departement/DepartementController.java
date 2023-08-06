package com.gestion.web.departement;

import com.gestion.service.application.common.execption.GestionException;
import com.gestion.service.application.departement.IDepartementApplication;
import com.gestion.web.commun.filter.FiltersDto;
import com.gestion.web.commun.mapper.IFilterMapper;
import com.gestion.web.departement.dto.DepartementDto;
import com.gestion.web.departement.dto.DepartementFilterDto;
import com.gestion.web.departement.mapper.IDepartementDtoMapper;
import com.gestion.web.departement.mapper.IDepartementFilterDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/depatements")
public class DepartementController {

    private final  IDepartementApplication departementApplication;
    private final IDepartementDtoMapper departementMapper;

    private final IDepartementFilterDtoMapper departementFilterDtoMapper;

    private final IFilterMapper filterMapper;

    public DepartementController(IDepartementApplication departementApplication, IDepartementDtoMapper departementMapper, IDepartementFilterDtoMapper departementFilterDtoMapper, IFilterMapper filterMapper) {
        this.departementApplication = departementApplication;
        this.departementMapper = departementMapper;
        this.departementFilterDtoMapper = departementFilterDtoMapper;
        this.filterMapper = filterMapper;
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartementDto> getDepartemetByCode(@PathVariable(name = "code") String code) throws GestionException {
        DepartementDto departementDto = departementMapper.departementDto(departementApplication.getDepartement(code));
        return ResponseEntity.ok(departementDto);
    }

    @PostMapping("/search")
   // @PostAuthorize("hasRole('ADMIN')")
   // @RolesAllowed("USER_ADMIN")
    public ResponseEntity<Page<DepartementDto>> searchDepartements(@RequestBody FiltersDto filtersDto, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();


        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(5));
        Page<DepartementDto> departementDtoList = departementApplication.searchDepartements(pageable, filterMapper.toFilters(filtersDto))
                .map(entity -> departementMapper.departementDto(entity));
        return ResponseEntity.ok(departementDtoList);
    }


    @PostMapping
    public ResponseEntity<DepartementDto> postDepartemet(@Validated @RequestBody DepartementDto departementDto) {
        departementDto = departementMapper.departementDto(departementApplication.save(departementMapper.departement(departementDto)));
        return ResponseEntity.ok(departementDto);
    }

}
