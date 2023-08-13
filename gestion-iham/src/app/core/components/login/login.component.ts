import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FormsService } from 'src/app/shared/services/forms-services';
import { UserApp, UserSignIn } from './models/login.model';
import { LoginService } from './services/login.service';
import { catchError, of, tap } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { GENERAL } from 'src/app/shared/models/constatnts';
import { group } from '@angular/animations';
import { JwtService } from 'src/app/shared/services/jwt-service';
import { JwtHelperService, JwtModule } from '@auth0/angular-jwt';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{


  loginForm!: FormGroup;
  usernameCtrl!: FormControl;
  passwordCtrl!: FormControl;
  loading : boolean = false;
  hide = true;

  constructor(private fromBuild: FormBuilder, public formService: FormsService, private loginService: LoginService,
               private jwtHelperService: JwtHelperService){}

  ngOnInit(): void {
    this.initForm();
  }

  private initForm(): void {
    this.usernameCtrl = this.fromBuild.control('',  [Validators.email, Validators.required]);
    this.passwordCtrl = this.fromBuild.control('',  [Validators.required]);
    this.loginForm = this.fromBuild.group({
      'username': this.usernameCtrl,
      'password': this.passwordCtrl
    });
  }

  onSubmit() {
    if (! this.loginForm.valid) {
      return;
    }
    this.loading = true;
    const user : UserSignIn = this.loginForm.value;
    this.loginService.authentification(user).pipe(
      
     catchError(error => { return of(error)}),
     tap( (response: HttpResponse<any>)  => {
      if ( response && response.status === GENERAL.status.ok && response.headers && response.headers.has(GENERAL.Authorization)) {
        const jwt = response.headers.get('Authorization');
        const validJwt = !this.jwtHelperService.isTokenExpired(jwt);
        if (validJwt) {
          this.loginService.redirectBasedOnUserProfile(jwt!);
        }
      
      }
      this.inisialiseParam();
      
     }) 
    ).subscribe();

  }

 private inisialiseParam (): void {
    this.loading = false;
    this.usernameCtrl.setValue('');
    this.passwordCtrl.setValue('');
  }

  onDisabled() {
    return this.loginForm.invalid || this.loading;
  }

}


