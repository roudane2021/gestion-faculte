import { Injectable } from '@angular/core';
import { GENERAL } from '../models/constatnts';
import { JwtHelperService } from '@auth0/angular-jwt';
import { UserApp } from 'src/app/core/login/models/login.model';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class JwtService {

  constructor(private jwtHelperService: JwtHelperService,
    private router: Router){}

  saveToken(token: string): void {
    localStorage.setItem(GENERAL.JWT_KEY, token);
  }

  getToken(): string | null {
    return localStorage.getItem(GENERAL.JWT_KEY);
  }

  removeToken(): void {
    localStorage.removeItem(GENERAL.JWT_KEY);
  }
  getUserApp(): UserApp | null {
    if ( this.getToken() ) {
      return this.jwtHelperService.decodeToken(this.getToken()!);
    }
    return null;
  }

  hasProfile(profile: string) : boolean {

    return this.getUserApp()?.PROFILE === profile;
  }

  roles() : string[] {

    return this.getUserApp()?.Authorization!;
  }

  login() : void {

    this.router.navigate([GENERAL.URL.LOGIN]);
  }

 

  
}