import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Location} from '@angular/common';

declare var $:any;
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  location: Location;

  constructor(location: Location, public router: Router) {
    this.location = location;
  }

  ngOnInit() {
    $.getScript('../../../assets/js/initMenu.js');
    if (this.location.path() == '/admin')
      this.router.navigate(['/admin/students']);
  }

  isMaps(path){
    var titlee = this.location.prepareExternalUrl(this.location.path());
    titlee = titlee.slice( 1 );

    if(path == titlee){
      return false;
    }
    else {
      return true;
    }
  }

}
