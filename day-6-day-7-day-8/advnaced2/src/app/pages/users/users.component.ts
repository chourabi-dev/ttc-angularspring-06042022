import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  isLoading = true;


  users:any[] = [];
  
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.getDataFromServer();
  }


  getDataFromServer(){
    // i must make a GET HTTP call https://jsonplaceholder.typicode.com/users

    const url = 'https://jsonplaceholder.typicode.com/users';


                      // duration
    this.http.get(url).toPromise().then( (data:any[])=>{
      console.log(data);
 

      this.users = data;


      this.isLoading = false;
      
    } ).catch( (error)=>{
      console.log(error);

      this.isLoading = false;
      
    } );

  }

}
