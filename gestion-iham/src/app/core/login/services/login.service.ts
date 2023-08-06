
import { Injectable, NgZone } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable, delay} from 'rxjs';
import { UserApp, UserSignIn } from '../models/login.model';
import { HttpClient } from '@angular/common/http';
import { urlApi } from 'src/app/shared/url-api/url.api';
import { JwtService } from 'src/app/shared/services/jwt-service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { GENERAL } from 'src/app/shared/models/constatnts';


export interface UserProfile {
    username: string;
}



@Injectable({
  providedIn: 'root'
})
export class LoginService {



    constructor(private httpclient: HttpClient, private jwtService: JwtService, private activatedRoute: ActivatedRoute,
        private jwtHelperService: JwtHelperService,
               private router: Router){}

    authentification(user: UserSignIn): Observable<any> {

        return this.httpclient.post<any>(urlApi.login, user, { observe: 'response' }).pipe(delay(2000));
    }

    redirectBasedOnUserProfile(jwt: string) {
        this.jwtService.saveToken(jwt);
        const userApp: UserApp = this.jwtHelperService.decodeToken(jwt!)!;

        if( userApp) {
            const profile : string = userApp.PROFILE!;
            switch(profile) {
                case GENERAL.PROFILE.ADMIN : {
                    this.router.navigate([GENERAL.URL.COURANT, GENERAL.URL.ADMIN]);
                    break;
                }
                default : {
                    //this.router.navigate([GENERAL.URL.COURANT]);
                    break;   
                }
            }
        }

    }

    

}