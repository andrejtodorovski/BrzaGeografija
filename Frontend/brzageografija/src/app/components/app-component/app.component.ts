import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Answer } from '../Answer/Answer';
import { BgService } from '../../bg.service';
import { Result } from './result.model';

@Component({
  selector: 'app-root',
  templateUrl: '../app-component/app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'brzageografija';
  letter: String =''
  rezultat:Result | any=null;
  constructor(private bgService: BgService){}
  ngOnInit(): void {
    const button=document.getElementById("submit") as HTMLButtonElement;
button.disabled=true;
  }
  public submitResults(result: NgForm):Result{
    document.getElementById('submit')?.click();
      this.bgService.addResult(result.value).subscribe(
        (response: Result) => {
          console.log(response);
          this.rezultat=response;
          const button2=document.getElementById("letter") as HTMLButtonElement;
          button2.disabled=false;
          const button=document.getElementById("submit") as HTMLButtonElement;
          button.disabled=true;
        },
        (error : HttpErrorResponse) => {
          alert(error.message);
        }
      );
      return this.rezultat;
  }
  public generateLetter():String{
  this.bgService.getLetter().subscribe(
    (response:String)=>
  {
    console.log(response);
    this.letter=response.toUpperCase();
    const button=document.getElementById("submit") as HTMLButtonElement;
    const button2=document.getElementById("letter") as HTMLButtonElement;
    button2.disabled=true;


    button.disabled=false;
  }
  ,
  (error : HttpErrorResponse) => {
    alert(error.message);
  }
  );
  return this.letter;  

  }
}

