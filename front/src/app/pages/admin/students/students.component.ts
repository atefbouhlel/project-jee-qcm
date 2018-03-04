import {Component, OnInit, ViewChild} from '@angular/core';
import {Popup} from "ng2-opd-popup";
import {AdminService} from "../../../services/admin.service";
import {Student} from "../../../models/Student";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  @ViewChild('updateTemplate') popupUpdate: Popup;
  @ViewChild('deleteTemplate') popupDelete: Popup;
  @ViewChild('successTemplate') popupSuccess: Popup;

  studentsList: any;
  newStudent: Student;
  selectedStudent: Student;

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.adminService.getAllStudents()
      .subscribe(data => {
        this.studentsList = data;
      }, err => {
        console.log(err);
      });

    this.newStudent = new Student();
    this.selectedStudent = new Student();
  }

  updateStudentPopup(selectedStudent) {
    console.log('******');
    console.log(selectedStudent);
    console.log('******');
    this.selectedStudent = selectedStudent;
    this.popupUpdate.options = {
      header: "Modification d'un étudiant",
      color: "purple",
      widthProsentage: 70,
      animationDuration: 2,
      showButtons: true, // You can hide this in case you want to use custom buttons
      confirmBtnContent: "Modifier", // The text on your confirm button
      cancleBtnContent: "Annuler", // the text on your cancel button
      confirmBtnClass: "btn btn-success", // your class for styling the confirm button
      cancleBtnClass: "btn btn-default", // you class for styling the cancel button
      animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
    };
    this.popupUpdate.show(this.popupUpdate.options);
  }

  deleteStudentPopup(selectedStudent){
    this.selectedStudent = selectedStudent;
    this.popupDelete.options = {
      header: "Alerte",
      color: "purple",
      widthProsentage: 40,
      animationDuration: 1,
      showButtons: true, // You can hide this in case you want to use custom buttons
      confirmBtnContent: "Supprimer", // The text on your confirm button
      cancleBtnContent: "Annuler", // the text on your cancel button
      confirmBtnClass: "btn btn-danger", // your class for styling the confirm button
      cancleBtnClass: "btn btn-default", // you class for styling the cancel button
      animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
    };
    this.popupDelete.show(this.popupDelete.options);
  }

  createStudent() {
    this.popupSuccess.options = {
      header: "Sauvegarde reussie",
      color: "green",
      widthProsentage: 40,
      animationDuration: 1,
      showButtons: true, // You can hide this in case you want to use custom buttons
      confirmBtnContent: "Ok", // The text on your confirm button
      cancleBtnContent: "Fermer", // the text on your cancel button
      confirmBtnClass: "btn btn-success", // your class for styling the confirm button
      cancleBtnClass: "btn btn-default", // you class for styling the cancel button
      animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
    };

    this.adminService.createStudent(this.newStudent)
      .then(student => {
        console.log("create Student");
        this.studentsList.push(student);
        this.popupSuccess.show();
      });
  }
  updateStudent() {
    this.adminService.updateStudent(this.selectedStudent)
      .then(student => {
        this.popupUpdate.hide();
      });
  }

  deleteStudent() {
    this.adminService
      .deleteStudent(this.selectedStudent.id)
      .then(() => {
        this.studentsList = this.studentsList.filter(s => s !== this.selectedStudent);
        this.selectedStudent = new Student();
        this.popupDelete.hide();
      });
  }

}
