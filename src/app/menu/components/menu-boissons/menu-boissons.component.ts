import { Component, Input } from '@angular/core';
import { Menucard } from 'src/app/core/models/menu-card';

@Component({
  selector: 'app-menu-boissons',
  templateUrl: './menu-boissons.component.html',
  styleUrls: ['./menu-boissons.component.scss']
})
export class MenuBoissonsComponent {
  @Input() menuCardBoisson!: Menucard;

}
