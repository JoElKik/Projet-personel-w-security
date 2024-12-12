import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import { ContactService } from '../services/Contact.service';
import { error } from '@angular/compiler-cli/src/transformers/util';

@Component({
  selector: 'app-form-contact',
  templateUrl: './form-contact.component.html',
  styleUrls: ['./form-contact.component.scss']
})
export class FormContactComponent implements OnInit{
  contactForm!: FormGroup;
  emailRgex!: RegExp;

  constructor(
    private contactService: ContactService,
    private formBuilder: FormBuilder,
              private router: Router) { }

  ngOnInit(): void {

    this.emailRgex = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

    this.contactForm = this.formBuilder.group({
      Nom: [null, [Validators.required]],
      Prenom: [null, [Validators.required]],
      Email: [null, [Validators.required, Validators.pattern(this.emailRgex)]],
      Adresse: [null, [Validators.required]],
      Objet: [null, [Validators.required]],
      Message : [null, [Validators.required]]

    })


  }
  SendEmail() {

    this.contactService.sendEmail({ pNom: this.contactForm.value.Nom,
                                    pPrenom:this.contactForm.value.Prenom,
                                    pEmail: this.contactForm.value.Email,
                                    pAdresse: this.contactForm.value.Adresse,
                                    pObjet: this.contactForm.value.Objet,
                                    pMessage: this.contactForm.value.Message}).subscribe(
                                      result => {
                                        console.log(this.contactForm.value.Nom)
                                        console.log(this.contactForm.value.Prenom)
                                        console.log(this.contactForm.value.Email)
                                        console.log(this.contactForm.value.Objet)
                                        console.log(this.contactForm.value.Message)                                        
                                      },error =>{console.log(this.contactForm.value.Nom)
                                        console.log(this.contactForm.value.Prenom)
                                        console.log(this.contactForm.value.Email)
                                        console.log(this.contactForm.value.Objet)
                                        console.log(this.contactForm.value.Message) 

                                      })
  }
}


