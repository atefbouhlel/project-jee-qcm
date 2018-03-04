import {Question} from "./Question";
import {Ue} from "./Ue";

export class QCM {
  id: number;
  name: string;
  theme: string;
  difficulty: number;
  startdate: string;
  enddate: string;

  questions: Array<Question>;
  ues: Array<Ue>;

  constructor() {
    /*this.startdate = new Date();
    this.enddate = new Date();*/
    this.questions = new Array<Question>();
    this.questions.push(new Question());
    this.ues = new Array<Ue>();
  }
}
