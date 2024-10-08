import { Component, Input } from '@angular/core';
import { Menucard } from 'src/app/core/models/menu-card';
import {Produits} from "../../../core/models/Produits";

@Component({
  selector: 'app-menu-accompagnement',
  templateUrl: './menu-accompagnement.component.html',
  styleUrls: ['./menu-accompagnement.component.scss']
})
export class MenuAccompagnementComponent {
  @Input() Produits$!: Produits;
}
