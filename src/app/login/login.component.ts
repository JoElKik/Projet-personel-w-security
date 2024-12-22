import {Component, OnInit} from '@angular/core';
import {SessionLoginService} from "../services/session-login/session-login.service";
import {subscribeOn} from "rxjs";
import {Router} from "@angular/router";

import {Form, FormBuilder, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{
  InscriptionForm!: FormGroup;
  ConnexionForm!: FormGroup;
  emailRgex!: RegExp;
  username ='';
  password ='';
  wrongCredentials = false;
  constructor(
    private sessionLogin: SessionLoginService,
    private router: Router,
   private formBuilder: FormBuilder
) {}

  ngOnInit() {
    this.emailRgex = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    this.InscriptionForm = this.formBuilder.group({
      Nom: [null, [Validators.required]],
      Email: [null, [Validators.required, Validators.pattern(this.emailRgex)]],
      mdp: [null, [Validators.required]]

    })

    this.ConnexionForm = this.formBuilder.group({

      Email: ["Joel@maaaaail.com", [Validators.required, Validators.pattern(this.emailRgex)]],
      password: ["password", [Validators.required]]

    })
  }

  login(){
    this.sessionLogin.login({pUsername: this.ConnexionForm.value.Email, pPassword: this.ConnexionForm.value.password}).subscribe(
      result=>{
        console.log(this.ConnexionForm.value.password);
        console.log(this.ConnexionForm.value.Email);

    }, error => {


    })

  }
  register(){

    this.sessionLogin.register({ pNom: this.InscriptionForm.value.Nom,pEmail: this.InscriptionForm.value.Email, pPassword: this.InscriptionForm.value.mdp}).subscribe(
      result=>{
        console.log(this.InscriptionForm.value.Nom);
        console.log(this.InscriptionForm.value.Email);

    }, error => {


    })

  }
  logout(){
    this.sessionLogin.logout().subscribe(result=>{
      this.router.navigate(['/']);
    }, error => {
      this.wrongCredentials=true;

    })

  }

}
