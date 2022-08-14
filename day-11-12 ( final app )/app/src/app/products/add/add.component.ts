import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {


  form = new FormGroup({
    title: new FormControl('',Validators.required),
    price: new FormControl('',Validators.required),
    quantity: new FormControl('',Validators.required),
    category: new FormControl('',Validators.required),
    
  })


  successMessage='';
  errorMessage='';
  

  categories:any[] = [];

  constructor(private api:ApiService) { }

  ngOnInit(): void {
    this.api.getCategoriesList().toPromise().then((res:any[])=>{ 
      console.log(res); 
      this.categories = res;
     })
  }



  save(){
    this.api.addNewProduct(this.form.value).toPromise().then((res:any)=>{
      console.log(res);


      if (res.success === true) {
          this.successMessage = res.message;

      } else {
        this.errorMessage = res.message;
          
      }



      this.form.reset();
      
    }).catch((err)=>{
      console.log(err);
      
      this.errorMessage = "Soemthing went wrong, please try again."
    })
  }
}
