import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import {FormsModule} from "@angular/forms";
import {AdminComponent} from "./admin.component";
import {ComponentsModule} from "../../components/components.module";
import { UsersComponent } from './users/users.component';
import {AdminRoutingModule} from "./admin.routing";
import { StudentsComponent } from './students/students.component';
import { ProfessorsComponent } from './professors/professors.component';
import { UeComponent } from './ue/ue.component';
import {PopupModule} from "ng2-opd-popup";

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    ComponentsModule,
    AdminRoutingModule,
    FormsModule,
    PopupModule.forRoot()
  ],
  declarations: [ AdminComponent, UsersComponent, StudentsComponent, ProfessorsComponent, UeComponent]
})
export class AdminModule { }
