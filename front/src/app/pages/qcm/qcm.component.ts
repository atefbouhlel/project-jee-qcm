import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import { Router } from '@angular/router';
declare var $:any;

@Component({
  selector: 'app-qcm',
  templateUrl: './qcm.component.html',
  styleUrls: ['./qcm.component.css']
})
export class QcmComponent implements OnInit {
  location: Location;

  constructor(location: Location, public router: Router) {
    this.location = location;
  }

  ngOnInit() {
    $.getScript('../../../assets/js/initMenu.js');
    if (this.location.path() == '/qcm')
      this.router.navigate(['/qcm/config']);
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
