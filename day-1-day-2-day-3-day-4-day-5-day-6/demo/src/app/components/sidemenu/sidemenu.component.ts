import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidemenu',
  templateUrl: './sidemenu.component.html',
  styleUrls: ['./sidemenu.component.css']
})
export class SidemenuComponent implements OnInit {


  menus:any[]=[
    { title:"Menu a", link:"#" },
    { title:"Menu b", link:"#" },
    { title:"Menu c", link:"#" },
    
  ];

  constructor() { }

  ngOnInit(): void {
  }

}