import { Component, OnInit } from '@angular/core';
import { ProductCardComponent } from '../product-card/product-card.component';
import { NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [ProductCardComponent,NgFor,FormsModule],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit {
 
  
  // saveSearchName() {
  //   if (this.searchName) {
      
  //     console.log(this.searchName);
      
      
  //   }
  // }


 ngOnInit(): void {
    
     this.loadProductInformation();
     
 }
 


 public searchName: string | null = null;
 public productInfo : any = [];  

 
 private api : string = 'http://localhost:8080/api/hotels/getAllHotels';
 

 loadProductInformation(){
     
  fetch(this.api)
  .then(res=>res.json()
  .then(data=>{

    this.productInfo=data;
    console.log(this.productInfo);
    
    console.log( localStorage.getItem('userId1'));

    console.log( localStorage.getItem('authToken'));

   



    

  /* async loadProductInformation(){
     
  await fetch("https://fakestoreapi.com/products")
  .then(res=>res.json()
  .then(data=>{

    this.productInfo=data;
    console.log(this.productInfo);
    */

    
    
  })

)


 }

 changeApi() {

  if (this.searchName) {
    this.api = `http://localhost:8080/api/hotels/search-hotel/${this.searchName}`;
    this.loadProductInformation();
  } 
}


}
