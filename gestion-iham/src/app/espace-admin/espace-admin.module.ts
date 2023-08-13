import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EspaceAdminRoutingModule } from './espace-admin-routing.module';
import { IndexComponent } from './index/index.component';
import { SharedModule } from '../shared/shared.module';
import { CoreModule } from '../core/core.module';
import { DepartementComponent } from './components/departement/departement.component';
import { CoursComponent } from './components/cours/cours.component';


@NgModule({
  declarations: [
    IndexComponent,
    DepartementComponent,
    CoursComponent
  ],
  imports: [
    CommonModule,
    EspaceAdminRoutingModule,
    CoreModule
  ]
})
export class EspaceAdminModule { }
