import {Component, OnInit, ViewChild} from '@angular/core';
import {QcmService} from "../../../services/qcm.service";
import {Router} from "@angular/router";
import {QCM} from "../../../models/QCM";
import {Popup} from "ng2-opd-popup";
import {Ue} from "../../../models/Ue";

@Component({
  selector: 'app-ue',
  templateUrl: './ue.component.html',
  styleUrls: ['./ue.component.css']
})
export class UEComponent implements OnInit {
  @ViewChild('studentsListTemplate') popupStudents: Popup;

  uesList: Array<Ue>;
  private newQcm: QCM;
  constructor(private router: Router, private qcmService: QcmService) { }

  ngOnInit() {

    if (this.qcmService.newQcm.questions.length == 0){
      console.log('nooooooo');
      this.router.navigate(['/qcm/config']);
    }
    this.newQcm = this.qcmService.newQcm;

    this.qcmService.getLoggedProfUes()
      .subscribe(data => {
        this.uesList = data;
      }, err => {
        console.log(err);
      });
    /*
    this.uesList = new Array<Ue>();
    let ue1 = new Ue();
    ue1.name = "SGBD";

    let ue2 = new Ue();
    ue2.name = "NoSQL";

    let ue3 = new Ue();
    ue3.name = "JEE";

    this.uesList.push(ue1, ue2, ue3);*/
  }

  affectUes(){
    this.newQcm.ues = this.uesList.filter(ue => ue.isSelected);
    // this.newQcm.questions[0].answers[0].id = 1;
    //this.newQcm.questions[0].answers[1].id = 2;
    this.qcmService.createQcm()
      .then(qcm => {
        console.log("coucou qcm");
        console.log(qcm);
      });
    console.log(this.newQcm);
  }

  displayStudentsList(ue){
    this.popupStudents.options = {
      header: "Liste des étudiants de" + ue.name,
      color: "purple",
      widthProsentage: 70,
      animationDuration: 2,
      showButtons: true, // You can hide this in case you want to use custom buttons
      confirmBtnContent: "Ok", // The text on your confirm button
      cancleBtnContent: "Fermer", // the text on your cancel button
      confirmBtnClass: "btn btn-success", // your class for styling the confirm button
      cancleBtnClass: "btn btn-default", // you class for styling the cancel button
      animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
    };
    this.popupStudents.show(this.popupStudents.options);
  }

}
