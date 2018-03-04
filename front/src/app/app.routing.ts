import { NgModule } from '@angular/core';
import { CommonModule, HashLocationStrategy, LocationStrategy } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import {QcmComponent} from "./pages/qcm/qcm.component";
import {AuthGuard} from "./guards/auth.guard";
import {AdminComponent} from "./pages/admin/admin.component";
// import { NotFoundComponent } from './pages/not-found/not-found.component';


const routes: Routes = [
      { path: 'home',      component: HomeComponent, canActivate: [AuthGuard] },
      { path: 'qcm', component: QcmComponent, canActivate: [AuthGuard]},
      { path: 'admin', component: AdminComponent, canActivate: [AuthGuard]},
      { path: 'login',     component: LoginComponent },
      { path: 'signup',    component: SignupComponent },
      { path: '',          redirectTo: 'home', pathMatch: 'full' },
      // { path: '**',        component: NotFoundComponent },
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, { useHash: true })
  ],
  providers: [
    { provide: LocationStrategy, useClass: HashLocationStrategy }
  ],
  exports: [
    RouterModule
  ],
})
export class AppRoutingModule { }

