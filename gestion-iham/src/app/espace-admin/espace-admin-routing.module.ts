import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { DepartementComponent } from './components/departement/departement.component';
import { CoursComponent } from './components/cours/cours.component';

const routes: Routes = [
  {path: '', component: IndexComponent, pathMatch: 'full'},
  {
    path: '',
    component: IndexComponent,
    children: [
      {
        path: 'departement',
        component: DepartementComponent,
      },
      {
        path: 'cours',
        component: CoursComponent,
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EspaceAdminRoutingModule { }
