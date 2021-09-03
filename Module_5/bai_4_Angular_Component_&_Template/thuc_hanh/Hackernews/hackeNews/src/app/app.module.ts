import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { FontSizeEditorComponent } from './font-size-editor.component';

@NgModule({
  declarations: [
    FontSizeEditorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [FontSizeEditorComponent]
})
export class AppModule { }
