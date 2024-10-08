import { Component, OnInit } from '@angular/core';
import { Menucard } from './core/models/menu-card';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  menucards!: Menucard[];

  ngOnInit() {
  }

}
