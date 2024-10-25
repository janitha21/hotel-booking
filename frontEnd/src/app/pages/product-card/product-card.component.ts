import { HttpClient,HttpClientModule } from '@angular/common/http';
import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
declare var bootstrap: any;

@Component({
  selector: 'app-product-card',
  standalone: true,
  imports: [HttpClientModule, FormsModule],
  templateUrl: './product-card.component.html',
  styleUrl: './product-card.component.css'
})
export class ProductCardComponent {
   
  constructor(private http: HttpClient, private router: Router) {}
  
  
   @Input()
   public saveProduct:any = null;

   makeBooking(){
     
     const token=localStorage.getItem('authToken');

     if(token){
     this.router.navigate(['/bookHotel']);
     }
     else{
      console.log("log in please");
      const toastElement = document.getElementById('loginToast');
      const toast = new bootstrap.Toast(toastElement);
      toast.show();
      
     }
      
    
   }

}
