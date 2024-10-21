import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { HeaderComponent } from './common/header/header.component';
import { ProductComponent } from './pages/product/product.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LogComponent } from './pages/log/log.component';
import { NgIf } from '@angular/common';  // Correct NgIf import
import { FooterComponent } from './common/footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, ProductComponent, DashboardComponent, LogComponent, NgIf,FooterComponent],  // Ensure NgIf is imported
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']  // Corrected styleUrl to styleUrls
})
export class AppComponent {
  title = 'demo-project';

  constructor(public router: Router) {}  // Inject Router service
}
