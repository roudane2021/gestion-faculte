import { Injectable } from '@angular/core';
import { EspaceAdminModule } from '../espace-admin.module';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { urlApi } from 'src/app/shared/url-api/url.api';

@Injectable({
  providedIn: 'root'
})
export class DepartementService {

  constructor(private httpClient : HttpClient) { }

  listDepartement(): Observable<any>{


    return this.httpClient.post(urlApi.listDepartment, {}, { observe: 'response' });
  }
}
