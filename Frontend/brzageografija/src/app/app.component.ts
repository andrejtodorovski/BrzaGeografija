import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Answer } from './Answer';
import { BgService } from './bg.service';
import { Country } from './Country';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'brzageografija';
  public countries: Country[] = [];
  constructor(private bgService: BgService){}
  ngOnInit(): void {
    this.getCountries();
  }
  public getCountries():void{
    this.bgService.getAllCountries().subscribe(
      (response: Country[]) => {
        this.countries = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
      );
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
}

