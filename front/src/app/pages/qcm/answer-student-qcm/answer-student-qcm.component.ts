import { Component, OnInit } from '@angular/core';
import {QcmService} from "../../../services/qcm.service";
import {Router} from "@angular/router";
import {Question} from "../../../models/Question";
import {Answer} from "../../../models/Answer";

@Component({
  selector: 'app-answer-student-qcm',
  templateUrl: './answer-student-qcm.component.html',
  styleUrls: ['./answer-student-qcm.component.css']
})
export class AnswerStudentQcmComponent implements OnInit {

  answerQcm: any;
  questionsAnswer: Array<Question>;
  score: number;

  isValidated: number;

  constructor(public qcmService: QcmService, private router: Router) { }


  ngOnInit() {
    this.score = 0;
    this.isValidated = 0;
    this.answerQcm = this.qcmService.selectedQcm;
    this.questionsAnswer = new Array<Question>();
    for (let item in this.answerQcm.questions) {
      console.log(item);
      this.questionsAnswer[item] = new Question();
      for (let j in this.answerQcm.questions[item].answers) {
        console.log(j);
        this.questionsAnswer[item].answers[j] = new Answer();
      }
    }

    console.log(this.questionsAnswer);
  }

  onSubmit(){
    console.log('valid answer');
    console.log(this.questionsAnswer);
    this.calculScore();
    console.log(this.score);
    this.isValidated = 1;
  }

  calculScore(){
    let nb = (20 / this.answerQcm.questions.length);
    for (let item in this.answerQcm.questions) {
      for (let j in this.answerQcm.questions[item].answers) {
        if (this.questionsAnswer[item].answers[j].iscorrect == this.answerQcm.questions[item].answers[j].iscorrect){
          console.log(item +" "+j);
          this.score += nb;
        }
      }
    }
  }

}
