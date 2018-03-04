import { Component, OnInit } from '@angular/core';
import {Http} from "@angular/http";
import {QcmService} from "../../../services/qcm.service";
import {AuthenticationService} from "../../../services/authentication.service";

@Component({
  selector: 'app-list-qcm',
  templateUrl: './list-qcm.component.html',
  styleUrls: ['./list-qcm.component.css']
})
export class ListQcmComponent implements OnInit {

  qcmsList: any;

  constructor(public qcmService: QcmService, private authService: AuthenticationService) { }

  ngOnInit() {
    console.log(this.authService.getToken());
    this.qcmService.getQcms()
      .subscribe(data => {
        this.qcmsList = data;
      }, err => {
        console.log(err);
      });
  }

}
