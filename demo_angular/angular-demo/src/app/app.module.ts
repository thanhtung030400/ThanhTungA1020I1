import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentInformationComponent } from './student-information/student-information.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { StudentListComponent } from './student-list/student-list.component';
import { StudentTemplateFormComponent } from './student-template-form/student-template-form.component';
import { StudentReactiveFormComponent } from './student-reactive-form/student-reactive-form.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentInformationComponent,
    StudentListComponent,
    StudentTemplateFormComponent,
    StudentReactiveFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
