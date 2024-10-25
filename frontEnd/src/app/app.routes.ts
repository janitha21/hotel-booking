import { Routes } from '@angular/router';
import { ProductComponent } from './pages/product/product.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ProductRegistrationComponent } from './pages/product-registration/product-registration.component';
import { LogComponent } from './pages/log/log.component';
import { RegisterHotelsComponent } from './pages/register-hotels/register-hotels.component';
import { UserSignComponent } from './user-sign/user-sign.component';
import { BookHotelComponent } from './book-hotel/book-hotel.component';

//import { BookHotelComponent } from './book-hotel/book-hotel.component';

export const routes: Routes = [
    {
        path : "",
        component : LogComponent
    },
    {
        path : "products",
        component : ProductComponent
    },
    {
        path : "dash",
        component : DashboardComponent
    },
    {
        path : "regProduct",
        component : ProductRegistrationComponent
    },
    {
        path : "log",
        component : LogComponent
    },
    {
        path : "RegHotels",
        component : RegisterHotelsComponent
    },
    {
        path : "signCustomer",
        component : UserSignComponent
    },
    {
        path : "bookHotel",
        component : BookHotelComponent
    }


    


];


















