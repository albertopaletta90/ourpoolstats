import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { OurpoolstatsComponent } from './ourpoolstats/ourpoolstats.component';
import { MarketComponent } from './market/market.component';
import { MenuComponent } from './menu/menu.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { MenuOurpoolstatsComponent } from './menu/menu-ourpoolstats/menu-ourpoolstats.component';
import { MenuOptionsComponent } from './menu/menu-options/menu-options.component';
import { CoinComponent } from './ourpoolstats/coin/coin.component';
import { ListCoinMarketComponent } from './ourpoolstats/coin/list-coin-market/list-coin-market.component';
import { AccountComponent } from './ourpoolstats/account/account.component';
import { ErrorComponent } from './ourpoolstats/error/error.component';
import { SuccesComponent } from './ourpoolstats/succes/succes.component';
import { WhitOutInternetComponent } from './ourpoolstats/whit-out-internet/whit-out-internet.component';
import { UserOperationComponent } from './ourpoolstats/user-operation/user-operation.component';
import { AddImageComponent } from './ourpoolstats/user-operation/add-image/add-image.component';
import { ChangeEmailComponent } from './ourpoolstats/user-operation/change-email/change-email.component';
import { ChengePasswordComponent } from './ourpoolstats/user-operation/chenge-password/chenge-password.component';
import { ChengeUserTypeComponent } from './ourpoolstats/user-operation/chenge-user-type/chenge-user-type.component';
import { ChatComponent } from './ourpoolstats/user-operation/chat/chat.component';
import { CreateUserComponent } from './ourpoolstats/user-operation/create-user/create-user.component';
import { DeleteComponent } from './ourpoolstats/user-operation/delete/delete.component';
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
import { BuyComponent } from './market/buy/buy.component';
import { ErrorChoicheComponent } from './market/error-choiche/error-choiche.component';
import { MenuAccountComponent } from './menu/menu-account/menu-account.component';
import { MenuActionComponent } from './menu/menu-action/menu-action.component';
import { MenuCoinComponent } from './menu/menu-coin/menu-coin.component';
import { MenuCurrencySellComponent } from './menu/menu-currency-sell/menu-currency-sell.component';
import { MenuMarketComponent } from './menu/menu-market/menu-market.component';
import { MenuValueCoinComponent } from './menu/menu-value-coin/menu-value-coin.component';

const routes: Routes = [
  {
      path: '',
      component: LoginComponent
  },
  {
    path: 'dashboard',
    component: OurpoolstatsComponent
  },
  {
    path : 'market',
    component : MarketComponent
  },
  {
    path : 'forum',
    component : ForumComponent
  },
  {
    path : 'account',
    component : AccountComponent
  },
  {
    path : 'errorLogin',
    component : ErrorComponent
  },
  {
    path : 'createUser',
    component : CreateUserComponent
  },
  {
    path : 'deleteUser',
    component : DeleteUserComponent
  },
  {
    path : 'changeTypeUser',
    component : ChengeUserTypeComponent
  },
  {
    path : 'infoCoinMarket',
    component : CoinMarketInfoComponent
  },
  {
    path : 'coinkego',
    component : ListCoinGekoComponent
  },
  {
    path : 'coinmarket',
    component : OurpoolstatsComponent
  },{
    path : 'setPassword',
    component : SetPasswordComponent
  }
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}

