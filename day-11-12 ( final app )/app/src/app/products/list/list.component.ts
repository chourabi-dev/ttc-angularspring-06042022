import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  products:any[] = [];


  constructor(private api:ApiService) { }

  ngOnInit(): void {
    this.getProducts();
  }


  getProducts(){
    this.api.getProductsList().toPromise().then((res:any[])=>{
      console.log(res);

      this.products = res;
      
    }).catch((err)=>{
      console.log(err);
      
    })
  }




  deleteProduct(id){
    this.api.deleteProduct(id).toPromise().then((res)=>{
      this.getProducts();
    })
  }
}
