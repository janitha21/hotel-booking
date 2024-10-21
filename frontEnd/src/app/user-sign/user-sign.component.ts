import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-sign',
  standalone: true,
  imports: [ HttpClientModule, CommonModule,FormsModule], 
  templateUrl: './user-sign.component.html',
  styleUrls: ['./user-sign.component.css'] 
})
export class UserSignComponent {

  public user = {
    userEmail: null,
    userPassword: null,
    userName: null,
    userContactNumber: null
  };
  
  
  // public userId: number | null = null;
  // public loginError: string = '';

  constructor(private http: HttpClient, private router: Router) {}

   onSubmit() {
    console.log(this.user.userEmail);
    console.log('create data:', this.user);

    this.http.post(`http://localhost:8080/save-user`, this.user)
      .subscribe(
        response => {
          console.log('Success!', response);
          // Navigate to another page if needed
          this.router.navigate(['/log']);
        },
        error => {
          console.error('Error occurred:', error);
        }
      );
   }
}
