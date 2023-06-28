import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'departement', loadChildren: () => import('./departement/departement.module').then(m => m.DepartementModule)},
  {path: '**', redirectTo: 'departement'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
