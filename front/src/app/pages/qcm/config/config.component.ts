import { Component, OnInit } from '@angular/core';
import {IMyDpOptions} from "angular4-datepicker/src/my-date-picker/interfaces";
import {Router} from "@angular/router";
import {QCM} from "../../../models/QCM";
import {QcmService} from "../../../services/qcm.service";
import {Question} from "../../../models/Question";

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit {

  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'dd-mm-yyyy',
  };

  private newQcm: QCM;
  public startDate: any = { date: { year: 2018, month: 10, day: 9 } };
  public endDate: any = { date: { year: 2018, month: 10, day: 9 } };

  constructor(private router: Router, private qcmService: QcmService) { }

  ngOnInit() {
    this.newQcm = new QCM();
  }

  onSubmit() {
    /*let q: Question = new Question();
    q.content = 'test';
    this.newQcm.questions.push(q);*/
    this.newQcm.startdate = this.startDate.date.year + '-' + this.startDate.date.month + '-' + this.startDate.date.day;
    this.newQcm.enddate = this.endDate.date.year + '-' + this.endDate.date.month + '-' + this.endDate.date.day;
    console.log(this.newQcm);
    this.qcmService.newQcm = this.newQcm;
    /*this.qcmService.createQcm()
      .then(qcm => {
        console.log("coucou");
      });*/
    this.router.navigate(['/qcm/questions']);
  }

}
