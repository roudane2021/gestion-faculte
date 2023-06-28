import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListDepartementComponent } from './components/list-departement/list-departement.component';

const routes: Routes = [
  {path: 'list-departemet', component:ListDepartementComponent},
  {path: '', pathMatch: 'full', redirectTo: 'list-departemet'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DepartementRoutingModule { }
