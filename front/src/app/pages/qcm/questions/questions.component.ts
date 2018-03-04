import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {QcmService} from "../../../services/qcm.service";
import {QCM} from "../../../models/QCM";
import {Question} from "../../../models/Question";
import {Answer} from "../../../models/Answer";

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  private newQcm: QCM;
  constructor(private router: Router, private qcmService: QcmService) { }

  ngOnInit() {
    console.log('---------');
    if (!this.qcmService.newQcm.name){
      console.log('nooooooo');
      this.router.navigate(['/qcm/config']);
    }
    this.newQcm = this.qcmService.newQcm;
    console.log(this.qcmService.newQcm);
  }

  onSubmit() {
    console.log('sub');
    this.router.navigate(['/qcm/ue']);
  }

  addQuestion(){
    console.log('add');
    this.newQcm.questions.push(new Question());
  }

  addAnswer(question){
    console.log('add answer');
    console.log(question);
    question.answers.push(new Answer());
  }

  deleteAnswer(question, answer){

    console.log('delete answer');
    question.answers = question.answers.filter(a => a !== answer);
  }

  deleteQuestion(question){
    console.log('delete');
    this.newQcm.questions = this.newQcm.questions.filter(q => q !== question);
  }

}
