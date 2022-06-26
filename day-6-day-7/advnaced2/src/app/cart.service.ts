import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private cart:any[]  =[];

  constructor() { }


  addToCart(produit){
    this.cart.push(produit);
  }


  getProductFromCart(){
    return this.cart;
  }

}
