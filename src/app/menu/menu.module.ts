import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenuRoutingModule } from './menu-routing.module';
import { MenuListComponent } from './components/menu-list/menu-list.component';
import { MenuSaucesComponent } from './components/menu-sauces/menu-sauces.component';
import { MenuPlatsComponent } from './components/menu-plats/menu-plats.component';
import { MenuEntreeComponent } from './components/menu-entree/menu-entree.component';
import { MenuBoissonsComponent } from './components/menu-boissons/menu-boissons.component';
import { MenuAccompagnementComponent } from './components/menu-accompagnement/menu-accompagnement.component';
import { RouterModule } from '@angular/router';

import {MenuComponent} from "./components/menu/menu.component";


@NgModule({
  declarations: [
    MenuAccompagnementComponent,
    MenuBoissonsComponent,
    MenuEntreeComponent,
    MenuPlatsComponent,
    MenuSaucesComponent,
    MenuListComponent,
    MenuComponent
  ],
  imports: [
    CommonModule,
    MenuRoutingModule,



  ],
  exports: [
    MenuAccompagnementComponent,
    MenuBoissonsComponent,
    MenuEntreeComponent,
    MenuPlatsComponent,
    MenuSaucesComponent,
    MenuListComponent,
    MenuComponent,
    RouterModule
  ]
})
export class MenuModule { }
