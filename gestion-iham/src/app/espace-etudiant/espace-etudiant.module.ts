import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EspaceEtudiantRoutingModule } from './espace-etudiant-routing.module';
import { IndexComponent } from './index/index.component';


@NgModule({
  declarations: [
    IndexComponent
  ],
  imports: [
    CommonModule,
    EspaceEtudiantRoutingModule
  ]
})
export class EspaceEtudiantModule { }
