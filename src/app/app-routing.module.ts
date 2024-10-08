import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/components/menu/menu.component';
import { MenuListComponent } from './menu/components/menu-list/menu-list.component';
import { ContactComponent } from './Photos/photos.component';
import {LoginComponent} from "./login/login.component";
import {FormContactComponent} from "./form-contact/form-contact.component";

const routes: Routes = [
  { path: 'menu', loadChildren: () => import('./menu/menu.module').then(m => m.MenuModule) },
  { path: '', component: HomeComponent },
  { path: 'photos', component: ContactComponent },
  { path: 'contact', component: FormContactComponent },
  { path: 'login', component: LoginComponent }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
