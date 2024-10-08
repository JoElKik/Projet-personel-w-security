import { Component, Input } from '@angular/core';
import { Menucard } from 'src/app/core/models/menu-card';

@Component({
  selector: 'app-menu-sauces',
  templateUrl: './menu-sauces.component.html',
  styleUrls: ['./menu-sauces.component.scss']
})
export class MenuSaucesComponent {
  @Input() menuCardSauce!: Menucard;

}
