import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuEntreeComponent } from './components/menu-entree/menu-entree.component';
import { MenuPlatsComponent } from './components/menu-plats/menu-plats.component';
import { MenuAccompagnementComponent } from './components/menu-accompagnement/menu-accompagnement.component';
import { MenuBoissonsComponent } from './components/menu-boissons/menu-boissons.component';
import { MenuSaucesComponent } from './components/menu-sauces/menu-sauces.component';
import { MenuListComponent } from './components/menu-list/menu-list.component';


const routes: Routes = [
  { path: '', component: MenuListComponent },
  { path: '?type="Entree"', component: MenuEntreeComponent },
  { path: 'Plats', component: MenuPlatsComponent },
  { path: 'Accompagnements', component: MenuAccompagnementComponent },
  { path: 'Boisson', component: MenuBoissonsComponent },
  { path: 'Sauces', component: MenuSaucesComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MenuRoutingModule { }
