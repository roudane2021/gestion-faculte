import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepartementRoutingModule } from './departement-routing.module';
import { ListDepartementComponent } from './components/list-departement/list-departement.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    ListDepartementComponent
  ],
  imports: [
    CommonModule,
    DepartementRoutingModule,
    SharedModule
  ]
})
export class DepartementModule { }
