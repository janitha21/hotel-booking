import { HttpClient,HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-hotels',
  standalone: true,
  imports: [FormsModule, HttpClientModule,],
  templateUrl: './register-hotels.component.html',
  styleUrl: './register-hotels.component.css'
})
export class RegisterHotelsComponent {
  public userData = {
    hotelName: null,
    hotelContact: null,
    hotelLoacation: null,
    hotelPhotoPath: null,
    hotelDescription: null

  };

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
    console.log('Form data:', this.userData);

    

    // Send the user data to the backend API
    const ownerId = localStorage.getItem('ownerId'); // Get ownerId from localStorage

    if (ownerId) {
      this.http.post(`http://localhost:8080/api/hotels/add/${ownerId}`, this.userData)
        .subscribe(
          response => {
            console.log('Success!', response);
            // Navigate to another page if needed
            this.router.navigate(['/products']);
          },
          error => {
            console.error('Error occurred:', error);
          }
        );
    } else {
      console.error('Owner ID is not found in local storage.');
    }
  }
}
