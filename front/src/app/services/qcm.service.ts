import { Injectable } from '@angular/core';
import {Headers, Http, Response} from "@angular/http";
import "rxjs/add/operator/map";
import {AuthenticationService} from "./authentication.service";
import {QCM} from "../models/QCM";
import {Observable} from "rxjs/Observable";

@Injectable()
export class QcmService {
  private qcmsUrl = 'http://localhost:8080/qcms';
  qcmList: any;
  selectedQcm: QCM;

  newQcm: QCM;
  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + this.authenticationService.getToken()
  });

  constructor(
    private http: Http,
    private authenticationService: AuthenticationService
  ) {
    this.newQcm = new QCM();
  }


  getQcms() {
    return this.http.get(this.qcmsUrl, {headers: this.headers})
      .map(resp => resp.json());
  }

  getStudentQcms() {
    return this.http.get('http://localhost:8080/student/myqcms', {headers: this.headers})
      .map(resp => resp.json());
  }

  createQcm(): Promise<QCM> {
    console.log("here");
    console.log(this.newQcm);
    return this.http
      .post(this.qcmsUrl + '/create', JSON.stringify(this.newQcm), {headers: this.headers})
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
    /*
    return this.http.post(this.qcmsUrl + '/create', JSON.stringify({qcm: this.newQcm}), {headers: this.headers})
      .map((response: Response) => {
        console.log(response);
        return true;
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
      */
  }

  getLoggedProfUes(){
    return this.http.get('http://localhost:8080/professor/myues', {headers: this.headers})
      .map(resp => resp.json());
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred: ', error); // for demo only
    return Promise.reject(error.message || error);
  }

}
