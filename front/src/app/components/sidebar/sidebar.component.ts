import { Component, OnInit } from '@angular/core';
import { ROUTES } from './sidebar-routes.config';
import {AuthenticationService} from "../../services/authentication.service";

declare var $:any;

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  userRole: string;

  constructor(private authService: AuthenticationService) { }

  ngOnInit() {
    $.getScript('../../assets/js/sidebar-moving-tab.js');
    this.userRole = this.authService.getUserRole();
    this.menuItems = ROUTES.filter(menuItem => menuItem.role === this.userRole || menuItem.role === 'all');
  }

}
