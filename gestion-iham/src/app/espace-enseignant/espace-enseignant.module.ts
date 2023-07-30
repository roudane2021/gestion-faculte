import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EspaceEnseignantRoutingModule } from './espace-enseignant-routing.module';
import { IndexComponent } from './index/index.component';


@NgModule({
  declarations: [
    IndexComponent
  ],
  imports: [
    CommonModule,
    EspaceEnseignantRoutingModule
  ]
})
export class EspaceEnseignantModule { }
