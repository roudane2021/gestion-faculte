import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MaterialModule } from './material/material.module';
import { TranslateModule, TranslateService } from '@ngx-translate/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HasRoleDirective } from './directives/has-role.directive';



@NgModule({
  declarations: [
    HasRoleDirective
  ],
  imports: [
    CommonModule,
    MaterialModule,
    TranslateModule.forChild(),
  ],
  exports: [
    RouterModule,
    MaterialModule,
    TranslateModule,
    ReactiveFormsModule,
    HasRoleDirective
  ],
  entryComponents: [
    //HasRoleDirective
  ]
  
})
export class SharedModule {

  constructor(private translateService: TranslateService) {
    // Définition de la langue par défaut
    this.translateService.setDefaultLang('en');
    this.translateService.use('fr');
  }
 }
