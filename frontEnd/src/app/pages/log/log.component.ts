import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-log',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './log.component.html',
  styleUrl: './log.component.css'
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
    // Log the credentials for debugging
    console.log('User Name:', this.user.userEmail);
    console.log('Password:', this.user.userPassword);

    // Send the credentials to the backend
    this.http.post<number>('http://localhost:8080/log-in', this.user)
      .subscribe(
        (response: number) => {
          this.userId = response;

          // Check if the ownerId is greater than 1
          if (this.userId != 0) {
            console.log('Login successful! Owner ID:', this.userId);
            localStorage.setItem('userId', this.userId.toString()); // Store ownerId in localStorage
            this.router.navigate(['/products']); // Navigate to the dashboard on success
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
 

    
   

  signIn(){
    
    this.router.navigate(['/signCustomer']);
  }
}
