import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Answer } from '../Answer/Answer';
import { BgService } from '../../bg.service';

@Component({
  selector: 'app-root',
  templateUrl: '../app-component/app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'brzageografija';
  letter: String =''
  constructor(private bgService: BgService){}
  ngOnInit(): void {
  }
  public submitResults(result: NgForm):void{
    document.getElementById('submit')?.click();
      this.bgService.addResult(result.value).subscribe(
        (response: Answer) => {
          console.log(response);
          console.log(result.value);
        },
        (error : HttpErrorResponse) => {
          alert(error.message);
        }
      );
  }
  public generateLetter():String{
  this.bgService.getLetter().subscribe(
    (response:String)=>
  {
    console.log(response);
    this.letter=response.toUpperCase();
  }
  ,
  (error : HttpErrorResponse) => {
    alert(error.message);
  }
  );
  return this.letter;  

  }
}

