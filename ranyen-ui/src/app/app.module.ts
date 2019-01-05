import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BodyComponent } from './body/body.component';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { MaterialService } from './material.service';
import { LoginComponent } from './login/login.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { SignupFormComponent } from './signup-form/signup-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BodyComponent,
    HeaderMenuComponent,
    LoginComponent,
    LoginFormComponent,
    SignupFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MaterialService,
    ReactiveFormsModule,
    HttpClientModule 
  ],
  entryComponents:[
    SignupFormComponent,
    LoginFormComponent
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA,
  ]
})
export class AppModule { }
