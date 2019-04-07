import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MarketComponent } from './market/market.component';
import { MenuComponent } from './menu/menu.component';
import { OurpoolstatsComponent } from './ourpoolstats/ourpoolstats.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { MenuOurpoolstatsComponent } from './menu/menu-ourpoolstats/menu-ourpoolstats.component';
import { MenuOptionsComponent } from './menu/menu-options/menu-options.component';
import { CoinComponent } from './ourpoolstats/coin/coin.component';
import { ListCoinMarketComponent } from './ourpoolstats/coin/list-coin-market/list-coin-market.component';
import { AccountComponent } from './ourpoolstats/account/account.component';
import { WhitOutInternetComponent } from './ourpoolstats/whit-out-internet/whit-out-internet.component';
import { UserOperationComponent } from './ourpoolstats/user-operation/user-operation.component';
import { AddImageComponent } from './ourpoolstats/user-operation/add-image/add-image.component';
import { ChangeEmailComponent } from './ourpoolstats/user-operation/change-email/change-email.component';
import { ChengeUserTypeComponent } from './ourpoolstats/user-operation/chenge-user-type/chenge-user-type.component';
import { ChatComponent } from './ourpoolstats/user-operation/chat/chat.component';
import { CreateUserComponent } from './ourpoolstats/user-operation/create-user/create-user.component';
import { DeleteUserComponent } from './ourpoolstats/user-operation/delete-user/delete-user.component';
import { SetPasswordComponent } from './ourpoolstats/user-operation/set-password/set-password.component';
import { UserLogComponent } from './ourpoolstats/user-operation/user-log/user-log.component';
import { UserOnlineComponent } from './ourpoolstats/user-operation/user-online/user-online.component';
import { CoinGekoInfoComponent } from './ourpoolstats/coin/coin-geko-info/coin-geko-info.component';
import { CoinMarketInfoComponent } from './ourpoolstats/coin/coin-market-info/coin-market-info.component';
import { InfoCoinGekoComponent } from './ourpoolstats/coin/info-coin-geko/info-coin-geko.component';
import { InfoCoinMarketComponent } from './ourpoolstats/coin/info-coin-market/info-coin-market.component';
import { ListBalanceBuyComponent } from './ourpoolstats/coin/list-balance-buy/list-balance-buy.component';
import { ListBalanceSellComponent } from './ourpoolstats/coin/list-balance-sell/list-balance-sell.component';
import { ListCoinGekoComponent } from './ourpoolstats/coin/list-coin-geko/list-coin-geko.component';
import { ForumComponent } from './forum/forum.component';
import { MenuAccountComponent } from './menu/menu-account/menu-account.component';
import { MenuActionComponent } from './menu/menu-action/menu-action.component';
import { MenuCoinComponent } from './menu/menu-coin/menu-coin.component';
import { MenuCurrencySellComponent } from './menu/menu-currency-sell/menu-currency-sell.component';
import { MenuMarketComponent } from './menu/menu-market/menu-market.component';
import { MenuValueCoinComponent } from './menu/menu-value-coin/menu-value-coin.component';
import { GraphicCoinMarketComponent } from './ourpoolstats/coin/graphic-coin-market/graphic-coin-market.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbPaginationModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import { AlertsComponent } from './ourpoolstats/alerts/alerts.component';
import { AccordionComponent } from './ourpoolstats/accordion/accordion.component';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {HttpClient } from '@angular/common/http';
import { MenuLanguageComponent } from './menu/menu-language/menu-language.component';
import { TranslateComponent } from './translate/translate.component';
import { AddCoinComponent } from './ourpoolstats/user-operation/add-coin/add-coin.component';
import { DeleteCoinComponent } from './ourpoolstats/user-operation/delete-coin/delete-coin.component';
import { ListUserLogComponent } from './ourpoolstats/user-operation/list-user-log/list-user-log.component';
import { ListUserComponent } from './ourpoolstats/user-operation/list-user/list-user.component';
import { MatListModule } from '@angular/material';
import { MatExpansionModule } from '@angular/material';
import { MatSortModule } from '@angular/material';
import { MatPaginatorModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ListBuyComponent } from './market/list-buy/list-buy.component';
import { ListSellComponent } from './market/list-sell/list-sell.component';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MarketComponent,
    MenuComponent,
    OurpoolstatsComponent,
    MenuOurpoolstatsComponent,
    MenuOptionsComponent,
    CoinComponent,
    ListCoinMarketComponent,
    AccountComponent,
    WhitOutInternetComponent,
    UserOperationComponent,
    AddImageComponent,
    ChangeEmailComponent,
    ChengeUserTypeComponent,
    ChatComponent,
    CreateUserComponent,
    DeleteUserComponent,
    SetPasswordComponent,
    UserLogComponent,
    UserOnlineComponent,
    CoinGekoInfoComponent,
    CoinMarketInfoComponent,
    InfoCoinGekoComponent,
    InfoCoinMarketComponent,
    ListBalanceBuyComponent,
    ListBalanceSellComponent,
    ListCoinGekoComponent,
    ForumComponent,
    MenuAccountComponent,
    MenuActionComponent,
    MenuCoinComponent,
    MenuCurrencySellComponent,
    MenuMarketComponent,
    MenuValueCoinComponent,
    GraphicCoinMarketComponent,
    AlertsComponent,
    AccordionComponent,
    MenuLanguageComponent,
    TranslateComponent,
    AddCoinComponent,
    DeleteCoinComponent,
    ListUserLogComponent,
    ListUserComponent,
    ListBuyComponent,
    ListSellComponent
    
    
    
  ],
  imports: [
    NgbModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule, 
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    NgbPaginationModule,
    NgbAlertModule,
    FormsModule,
    MatListModule,
    MatExpansionModule,
     MatSortModule,
     BrowserAnimationsModule,
     FlexLayoutModule,
    MatPaginatorModule ,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
    

  ],
  providers:[],
  bootstrap: [AppComponent]
})
export class AppModule { }
