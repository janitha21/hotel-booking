import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-registration',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './product-registration.component.html',
  styleUrls: ['./product-registration.component.css']
})
export class ProductRegistrationComponent {
  public credentials = {
    userName: null,
    password: null
  };
  public ownerId: number | null = null; // Store the returned long here
  public loginError: string = ''; // Error message for failed login

  constructor(private http: HttpClient, private router: Router) {}

  setText() {
    // Log the credentials for debugging
    console.log('User Name:', this.credentials.userName);
    console.log('Password:', this.credentials.password);

    // Send the credentials to the backend
    this.http.post<number>('http://localhost:8080/check-owner', this.credentials)
      .subscribe(
        (response: number) => {
          this.ownerId = response;

          // Check if the ownerId is greater than 1
          if (this.ownerId > 1) {
            console.log('Login successful! Owner ID:', this.ownerId);
            localStorage.setItem('ownerId', this.ownerId.toString()); // Store ownerId in localStorage
            this.router.navigate(['/RegHotels']); // Navigate to the dashboard on success
          } else {
            this.loginError = 'Invalid username or password. Please try again.';
            console.log('Login failed');
          }
        },
        (error) => {
          console.error('Error:', error);
          this.loginError = 'An error occurred while logging in. Please try again.';
        }
      );
  }
}
