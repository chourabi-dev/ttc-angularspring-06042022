import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  clients:any[] = [];



  constructor(private api:ApiService) { }

  ngOnInit(): void {
    this.getClients();
  }


  getClients(){
    this.api.getClientsList().toPromise().then((res:any[])=>{
      this.clients = res;
    })
  }

}
