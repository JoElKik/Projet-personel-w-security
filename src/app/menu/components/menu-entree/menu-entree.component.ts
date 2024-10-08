import { Component, Input, OnInit } from '@angular/core';
import { Menucard } from 'src/app/core/models/menu-card';

@Component({
  selector: 'app-menu-entree',
  templateUrl: './menu-entree.component.html',
  styleUrls: ['./menu-entree.component.scss']
})
export class MenuEntreeComponent implements OnInit {
  @Input() menuCardEntree!: Menucard;
  ngOnInit(): void {

  }
}
