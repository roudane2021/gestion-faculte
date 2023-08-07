import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, finalize } from "rxjs";
import { JwtService } from "../services/jwt-service";
import { GENERAL } from "../models/constatnts";
import { NgxSpinnerService } from "ngx-spinner";


@Injectable({
    providedIn: 'root'
})

export class AuthInterceptor implements HttpInterceptor {

    constructor(private jwtService: JwtService, private spinner: NgxSpinnerService){}


    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        const url: string = req.url;
        this.spinner.show();

        if ( url?.endsWith(GENERAL.URL.LOGIN) ) {
            return next.handle(req).pipe(finalize(() => {this.spinner.hide()}));
        }

        req = req.clone(
            {
                headers: req.headers.set(GENERAL.Authorization, `Bearer ${this.jwtService.getToken()}`)
            }
        );
       
        return next.handle(req).pipe(finalize(() => {this.spinner.hide()}));
    }

}
