import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }


  getProductsList(){
    return this.http.get(environment.api+'/api/products/list');
  }
  
  getCategoriesList(){
    return this.http.get(environment.api+'/api/categories/list');
  }
  

  addNewProduct(body){
    return this.http.post(environment.api+'/api/products/add',body);
  }

  editProduct(body,id){
    return this.http.post(environment.api+'/api/products/update/'+id,body);
  }


  deleteProduct(id){
    return this.http.delete(environment.api+'/api/products/delete/'+id);
  }


  findProductByID(id){
    return this.http.get(environment.api+'/api/products/find/'+id);
  }


  /**************************************************************************** */

  getClientsList(){
    return this.http.get(environment.api+'/api/clients/list')
  }
  

  buyProductForClient(data){
    return this.http.post(environment.api+'/api/clients/sells/buy',data)
  }


  getClientsSells(){
    
    return this.http.get(environment.api+'/api/clients/sells/list')
  }
  
}
