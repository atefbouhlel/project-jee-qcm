import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../../services/authentication.service";
import {QcmService} from "../../../services/qcm.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-student-qcm',
  templateUrl: './list-student-qcm.component.html',
  styleUrls: ['./list-student-qcm.component.css']
})
export class ListStudentQcmComponent implements OnInit {

  qcmsList: any;

  constructor(public qcmService: QcmService, private router: Router) { }

  ngOnInit() {
    this.qcmService.getStudentQcms()
      .subscribe(data => {
        this.qcmsList = data;
      }, err => {
        console.log(err);
      });
  }

  answerQcm(qcm) {
    this.qcmService.selectedQcm = qcm;
    this.router.navigate(['/qcm/answer']);
  }

}
