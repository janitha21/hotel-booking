import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';

interface JwtPayload {
  sub: string;   // Username or email
  userID: number; // Ensure this matches the property name in your JWT
  exp: number;   // Expiration time
}

@Component({
  selector: 'app-log',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './log.component.html',
  styleUrls: ['./log.component.css']
})
export class LogComponent {
  public user = {
    userEmail: null,
    userPassword: null
  };

  public userId: number | null = null; 
  public loginError: string = ''; 
  
  
  
  constructor(private http: HttpClient, private router: Router) {}

  logIn() {
    // Basic input validation
    if (!this.user.userEmail || !this.user.userPassword) {
      this.loginError = 'Please enter both email and password.';
      return;
    }

    // Make a POST request to the login API
    this.http.post<{ token?: string, error?: string }>('http://localhost:8080/log-in', this.user)
      .subscribe(
        (response) => {
          console.log(response);
          
          // Check if the token is present in the response
          if (response.token) {
            // Store the token in local storage
            localStorage.setItem('authToken', response.token);

            // Decode the token
            try {
              const decodedToken = jwtDecode<JwtPayload>(response.token);
              this.userId = decodedToken.userID; // This should match the JWT payload structure

              console.log(`User ID: ${this.userId}`);
              this.router.navigate(['/products']); // Navigate to the desired route after login

             // localStorage.setItem('userId1', this.userId.toString());
            
              
              

            } catch (error) {
              console.error('Error decoding token:', error);
              this.loginError = 'Failed to decode token. Please try again.';
            }
          } else if (response.error) {
            this.loginError = response.error; // Display error message
          }
        },
        (error: HttpErrorResponse) => {
          // Check if the error contains a specific message from the backend
          if (error.error && error.error.error) {
            console.error('Login failedaaa:', error.error.error); // Log the specific error message
            this.loginError = error.error.error; // Display error message
            this.router.navigate(['/products']);
          } else {
            console.error('Login failedaaa:', error.message); // Log a generic error message
            this.loginError = 'An error occurred during login. Please try again.';
            this.router.navigate(['/products']);
          }
        }
      );
  }

  signIn() {
    this.router.navigate(['/signCustomer']);
  }
}
