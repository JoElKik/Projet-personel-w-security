import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Injectable({
  providedIn: 'root'
})
export class SessionLoginService {

  LOGIN_URL = '/api/connexion'
  LOGOUT_URL = '/api/deconnexion'
  REGISTER_URL = '/api/inscription'

  constructor(
    private httpClient: HttpClient
  ) { }

  login({pUsername, pPassword}: { pUsername: any, pPassword: any }){
    const loginData={
      username: pUsername,
      password: pPassword
    };
    return new Observable<boolean>((observer) => {
      this.httpClient.post(this.LOGIN_URL, loginData).subscribe(result => {
        observer.next(true);
        observer.complete()
      },error => {
        observer.error(false);
        observer.complete();
        });
    })
  }

  register({pNom,pEmail,pPassword}: { pNom: any, pEmail: any, pPassword: any }){
    const registerData={
      nom: pNom,
      email: pEmail,
      mdp: pPassword
    };
    return new Observable<boolean>((observer) => {
      this.httpClient.post(this.REGISTER_URL, registerData).subscribe(result => {
        observer.next(true);
        observer.complete()
      },error => {
        observer.error(false);
        observer.complete();
        });
    })
  }


  logout(){
    return new Observable<Boolean>((observer) =>{
    this.httpClient.post(this.LOGOUT_URL, {}).subscribe(result =>{
      observer.next(true);
      observer.complete();
      }, error => {
      observer.error(false);
      observer.complete();
      })
    })
  }
}
