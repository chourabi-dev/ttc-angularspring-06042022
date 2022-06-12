import { Component } from '@angular/core';
import { Employee } from './models/Employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  // dec 1
  projectName:string = "Angular project";
  email = 'tchourabi@gmail.com';
  year:number = 2022;
  user = { username:"chourabi taher", phone:93863732 };


  // *ngFor

  employees:Employee[] = [
    new Employee("chourabi taher",'tchourabi@gmail.com',"93863732",2000),
    new Employee("chourabi taher",'tchourabi@gmail.com',"93863732",2005),
    new Employee("chourabi taher",'tchourabi@gmail.com',"93863732",2017),
    new Employee("chourabi taher",'tchourabi@gmail.com',"93863732",2020),
    
  ]


  /*************************************************** */



  // *ngIf
  affichageBloc:boolean = true;



  /********************************attrs************************** */


  photoURL:string='https://www.easytutoriel.com/wp-content/uploads/2021/09/fond-d-ecran-anime-windows-11-10-tutoriel-facile.jpg';


  myColor:string="red";

  mySize:number = 28;




  /**********************************events*************************** */


  mouseClick(){
    console.log("clicked !!!");
    
  }



  /// like button
 /*
  likes:number = 5;
  didLike:boolean = false;


  likeButtonClick(){
    if (this.didLike == false) {
      this.likes++;
    } else {
      this.likes--;
    }

    this.didLike = ! this.didLike;
  }*/


  // collapse

  isOpned:boolean = false
  readMore(){
    this.isOpned = true;
  }



  readLess(){
    this.isOpned = false;
  }



  /****************** text views****************** */

  size = 12;
  color = "black"

  incrementSize(){
    this.size++;
  }

  decrementSize(){
    this.size--;
  }


  changeColor(event){ 
    this.color = event.target.value;
  }


  /** SHOPPING LIST */

  products:any[]=[];


  typing(event){
    console.log(event);
    const code = event.code;
 

    if (code === 'Enter') {
        const value= event.target.value;

        this.products.push(
          {
            product: value,
            date : new Date()
          }
        );

        // init input
        event.target.value='';
    } 
    
  }



  removeShoppingItem(index){
    this.products.splice(index,1);
  }





  /*********************** array search ******************* */


  fruits:string[] = [
    'water malone',
    'annanas',
    'apples',
    'oranges'
  ]; 
  searchArray =  [
    'water malone',
    'annanas',
    'apples',
    'oranges'
  ] 

  searching(event){
    const val = event.target.value;

    let res = this.fruits.filter( (f)=>f.indexOf(val)  != -1)
  
    this.searchArray = res;
    
  }


  /***************************************** */

  today = new Date();

}
