import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/cart.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products:any[] = [
    { title:"Samsung S21", price:500,photoURL:'https://www.tunisianet.com.tn/235653-large/smartphone-samsung-galaxy-s21-fe-5g-8-go-256-go-violet.jpg' },
    { title:"Samsung S20", price:1500,photoURL:'https://www.tunisianet.com.tn/235653-large/smartphone-samsung-galaxy-s21-fe-5g-8-go-256-go-violet.jpg' },
    { title:"Samsung S30", price:200,photoURL:'https://www.tunisianet.com.tn/235653-large/smartphone-samsung-galaxy-s21-fe-5g-8-go-256-go-violet.jpg' },
    
  ];

  constructor(private cart: CartService) { }

  ngOnInit(): void {
  }


  addProductToCart(p){
    this.cart.addToCart(p);
  }


}
