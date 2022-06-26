import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  articles:any[] = [
    { id:1, title:"HTML CSS JS" },
    { id:2, title:"React JS" },
    { id:3, title:"Angular Spring" },
    
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
