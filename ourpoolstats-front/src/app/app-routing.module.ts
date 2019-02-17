import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { OurpoolstatsComponent } from './ourpoolstats/ourpoolstats.component';

const routes: Routes = [
  {
      path: '',
      component: LoginComponent
  },
  {
    path: 'succesLogin',
    component: OurpoolstatsComponent
  }
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}

