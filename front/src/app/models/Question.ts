import {Answer} from "./Answer";

export class Question {
  id: number;
  content: string;

  answers: Array<Answer>;

  constructor() {
    /*this.startdate = new Date();
    this.enddate = new Date();*/
    this.answers = new Array<Answer>();
    //this.answers.push(new Answer());
    //this.answers.push(new Answer());
  }

}
