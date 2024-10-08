import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { CoreModule } from './core/core.module';
import { MenuComponent } from './menu/components/menu/menu.component';
import { ContactComponent } from './Photos/photos.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { FormContactComponent } from './form-contact/form-contact.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,

    ContactComponent,
     LoginComponent,
     FormContactComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CoreModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [
    AppComponent,
    HomeComponent,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
