import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact',
  templateUrl: './photos.component.html',
  styleUrls: ['./photos.component.scss']
})
export class ContactComponent implements OnInit {
  contactForm!: FormGroup;
  emailRgex!: RegExp;

  constructor(private formBuilder: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {

    this.emailRgex = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

    this.contactForm = this.formBuilder.group({
      Nom: [null, [Validators.required]],
      Prenom: [null, [Validators.required]],
      Email: [null, [Validators.required, Validators.pattern(this.emailRgex)]],
      Adresse: [null, [Validators.required]]

    })


  }
  onSubmitForm() {

    console.log(this.contactForm.value)
  }

}
