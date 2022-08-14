import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/api.service';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {



  form = new FormGroup({
    title: new FormControl('',Validators.required),
    price: new FormControl('',Validators.required),
    quantity: new FormControl('',Validators.required),
    category: new FormControl('',Validators.required),
    
  })


  successMessage='';
  errorMessage='';
  

  categories:any[] = [];

  constructor(private api:ApiService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.api.getCategoriesList().toPromise().then((res:any[])=>{ 
      console.log(res); 
      this.categories = res;
     });


     // init form
     const id = this.route.snapshot.params.id;

     this.api.findProductByID(id).toPromise().then((data:any)=>{
      console.log(data);

      this.form.setValue(data);
      
     })
  }



  save(){
    const id = this.route.snapshot.params.id;


    this.api.editProduct(this.form.value,id).toPromise().then((res:any)=>{
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
