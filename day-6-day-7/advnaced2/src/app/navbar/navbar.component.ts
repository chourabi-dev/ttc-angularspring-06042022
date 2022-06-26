import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  list:any[]=[];
  constructor(private cart:CartService) { }

  ngOnInit(): void {
    this.list = this.cart.getProductFromCart();
  }

}
