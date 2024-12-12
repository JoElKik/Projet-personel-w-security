import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";





@Injectable({
    providedIn: 'root'
  })
  export class ContactService {
  
    CONTACT_URL = '/api/contact'
    
  
    constructor(
      private httpClient: HttpClient
    ) { }
  
    sendEmail({pNom, pPrenom,pEmail,pAdresse,pObjet,pMessage}: { pNom: String, pPrenom: String,pEmail: String, pAdresse: String,pObjet: String, pMessage: String  }){
      const EmailData={
        nom: pNom,
        prenom: pPrenom,
        email: pEmail,
        adresse : pAdresse,
        Objet : pObjet,
        Message: pMessage
      };
      return new Observable<boolean>((observer) => {
        this.httpClient.post(this.CONTACT_URL, EmailData).subscribe(result => {
          observer.next(true);
          observer.complete()
        },error => {
          observer.error(false);
          observer.complete();
          });
      })
    }
  
}