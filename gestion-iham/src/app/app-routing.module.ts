import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './core/login/login.component';
import { GENERAL } from './shared/models/constatnts';
import { AdminGuard, EnseignatGuard, EtudiantGuard, GuardWithProfile } from './shared/guards/all.guard';

const routes: Routes = [
  {path: GENERAL.URL.ADMIN, canActivateChild: [GuardWithProfile(GENERAL.PROFILE.ADMIN)],loadChildren: () => import('./espace-admin/espace-admin.module').then( m => m.EspaceAdminModule)},
  {path: GENERAL.URL.ETUDIANT, canActivateChild: [GuardWithProfile(GENERAL.PROFILE.ETUDIANT)], loadChildren: () => import('./espace-etudiant/espace-etudiant.module').then(m => m.EspaceEtudiantModule)},
  {path: GENERAL.URL.ENSEIGNANT, canActivateChild: [GuardWithProfile(GENERAL.PROFILE.ENSEIGNANT)], loadChildren: () => import('./espace-enseignant/espace-enseignant.module').then(m => m.EspaceEnseignantModule)},
  {path: GENERAL.URL.LOGIN, component: LoginComponent},
  {path: GENERAL.URL.EMPTY,pathMatch: 'full', redirectTo: 'espase-etudiant'},
  {path: GENERAL.URL.DEFAULT, redirectTo: 'departement'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
