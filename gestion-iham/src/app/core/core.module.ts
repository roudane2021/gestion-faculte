import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { LoginComponent } from './components/login/login.component';
import { MainShellComponent } from './components/main-shell/main-shell.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { HeaderComponent } from './components/header/header.component';
import { SideNavbarComponent } from './components/side-navbar/side-navbar.component';



@NgModule({
  declarations: [
    LoginComponent,
    MainShellComponent,
    SidebarComponent,
    HeaderComponent,
    SideNavbarComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    LoginComponent,
    MainShellComponent,
    SidebarComponent
  ]
})
export class CoreModule { }
