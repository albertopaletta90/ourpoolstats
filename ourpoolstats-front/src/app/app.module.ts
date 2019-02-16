import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MarketComponent } from './market/market.component';
import { MenuComponent } from './menu/menu.component';
import { OurpoolstatsComponent } from './ourpoolstats/ourpoolstats.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MarketComponent,
    MenuComponent,
    OurpoolstatsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
