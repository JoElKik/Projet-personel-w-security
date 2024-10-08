import { Component, Input } from '@angular/core';
import { Menucard } from 'src/app/core/models/menu-card';

@Component({
  selector: 'app-menu-plats',
  templateUrl: './menu-plats.component.html',
  styleUrls: ['./menu-plats.component.scss']
})
export class MenuPlatsComponent {
  @Input() menuCardPlats!: Menucard;
}
