import { Component } from '@angular/core';
import { ProductComponent } from '../../pages/product/product.component';
import { RouterLink } from '@angular/router';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink,NgIf,FormsModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  public searchName: string | null = null;



  saveSearchName() {
    if (this.searchName) {
      localStorage.setItem('searchName', this.searchName); // Store searchName in localStorage
      
    }
  }


  

 public isAdmin(): boolean {
    const id = localStorage.getItem('userId');
    // Convert the stored value to a number
    const userId = id ? Number(id) : null;

    if (userId && userId < 10) {
      // Logic for admin users (when userId is greater than 10)
     // console.log("Admin1");
      return true; // Admin users return true
    } else {
      // Logic for non-admin users (userId is 10 or less, or null)
      //console.log("Not admin");
      return false; // Non-admin users return false
    }
  }
  
  

}

