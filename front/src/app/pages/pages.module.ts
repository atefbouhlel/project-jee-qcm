import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeModule } from './home/home.module';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {QcmModule} from "./qcm/qcm.module";
import {FormsModule} from "@angular/forms";
import {AdminModule} from "./admin/admin.module";

@NgModule({
  imports: [
    CommonModule,
    HomeModule,
    QcmModule,
    AdminModule,
    FormsModule
  ],
  declarations: [
    LoginComponent,
    SignupComponent,
    NotFoundComponent,
  ]
})
export class PagesModule { }
