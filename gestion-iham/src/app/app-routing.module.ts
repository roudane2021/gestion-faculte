import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './core/login/login.component';

const routes: Routes = [
  {path: 'espace-admin', loadChildren: () => import('./espace-admin/espace-admin.module').then( m => m.EspaceAdminModule)},
  {path: 'espase-etudiant', loadChildren: () => import('./espace-etudiant/espace-etudiant.module').then(m => m.EspaceEtudiantModule)},
  {path: 'espase-enseignant', loadChildren: () => import('./espace-enseignant/espace-enseignant.module').then(m => m.EspaceEnseignantModule)},
  {path: 'login', component: LoginComponent},
  {path: '**', redirectTo: 'departement'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
