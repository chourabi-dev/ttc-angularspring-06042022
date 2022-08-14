import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {

  form = new FormGroup({
    product: new FormControl('',Validators.required),
    quantity: new FormControl('',Validators.required),
    
  })
  products:any[] = [];

  sells:any[] = [];

  
  successMessage='';
  errorMessage='';


  constructor(private api:ApiService, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.getProducts();
    this.getSells();
  }

  getProducts(){
    this.api.getProductsList().toPromise().then((res:any[])=>{
      this.products = res;
    })
  }

  getSells(){

    const id = this.route.snapshot.params.id;
    this.api.getClientsSells().toPromise().then((res:any[])=>{

      console.log(res);

      let sells = res.filter( s => s.client.id === id );

      this.sells = res;

      console.log(sells);
      
      


    })
  }


  buy(){
    const id = this.route.snapshot.params.id;


    const sell = {
      quantity: this.form.value.quantity,
      client:id,
      product: this.form.value.product,
    }

    this.api.buyProductForClient(sell).toPromise().then((res:any)=>{
      console.log(res);

      if (res.success === true) {
        this.successMessage = res.message;

      } else {
        this.errorMessage = res.message;
        
      }
      
    }).catch((err)=>{
      this.errorMessage = "something went wrong.";
      
    })


  }
}
