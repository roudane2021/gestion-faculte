import { CanActivateChildFn } from "@angular/router";
import { JwtService } from "../services/jwt-service";
import { inject } from "@angular/core";
import { GENERAL } from "../models/constatnts";


export function GuardWithProfile(
    profile: string,
  ): CanActivateChildFn {
    return () => {
        const jwtService: JwtService = inject(JwtService);

        if (jwtService.hasProfile(profile)) {
        return  true;
        }
        jwtService.login();
        return false;
    };
  }

export const AdminGuard : CanActivateChildFn = () => {

    const jwtService: JwtService = inject(JwtService);

    if (jwtService.hasProfile(GENERAL.PROFILE.ADMIN)) {
    return  true;
    }
    jwtService.login();
    return false;
}

export const EtudiantGuard : CanActivateChildFn = () => {

    const jwtService: JwtService = inject(JwtService);

    if (jwtService.hasProfile(GENERAL.PROFILE.ETUDIANT)) {
    return  true;
    }
    jwtService.login();
    return false;
}

export const EnseignatGuard : CanActivateChildFn = () => {

    const jwtService: JwtService = inject(JwtService);

    if (jwtService.hasProfile(GENERAL.PROFILE.ENSEIGNANT)) {
    return  true; 
    }
    jwtService.login();
    return false;
}