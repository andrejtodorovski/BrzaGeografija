import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './components/app-component/app.component';
import { BgService } from './bg.service';
import { AnswerComponent } from './components/Answer/answer.component';

@NgModule({
  declarations: [
    AppComponent,
    AnswerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BgService, HttpClient, HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
