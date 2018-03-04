import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthGuard} from "../../guards/auth.guard";
import {AdminComponent} from "./admin.component";
import {UsersComponent} from "./users/users.component";
import {ProfessorsComponent} from "./professors/professors.component";
import {UeComponent} from "./ue/ue.component";
import {StudentsComponent} from "./students/students.component";

const routes: Routes = [
  { path: 'admin',  component: AdminComponent, canActivateChild: [ AuthGuard ],
    children: [
      { path: 'students', component: StudentsComponent },
      { path: 'enseignants', component: ProfessorsComponent },
      { path: 'ue', component: UeComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
