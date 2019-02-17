
export class LoginResponse {
    constructor(public user: String, public status: String, public password: String, coinkarket : CoinMarket[], coingeko :CoinGeko[]) { }
}

export class Response {
    constructor(public status: String, public error: String) { }
}

export class CoinGekoResponse {
    constructor(public status: String, public error: String ,coingeko :CoinGeko) { }
}

export class CoinMarketResponse {
    constructor(public status: String, public error: String ,coinmarket :CoinMarket) { }
}

export class BalanceResponse {
    constructor(public status: String, public error: String,balance : Balance[]) { }
}

export class LogUserResponse {
    constructor(public status: String, public error: String,logUser : UserLog[]) { }
}


export class User {
    constructor(public user: String, password: String) {

    }
}

export class CoinMarket {
    constructor(public id: string,
                        name : string ,
                        symbol : string,
                        rank : number,
                        price_usd : number,
                        price_btc : number,
                        _24h_volume_usd : number,
                        market_cap_usd : number,
                        available_supply : number,
                        total_supply : number ,
                        max_supply : number ,
                        percent_change_1h : number ,
                        percent_change_24h : number ,
                        percent_change_7d : number ,
                        last_updated : number ,
                        quantity : number) { }
}

export class CoinGeko {
    constructor(public id: string,
                        name : string ,
                        symbol : string,
                        rank : number,
                        image : string,
                        current_price : number,
                        price_btc : number,
                        market_cap_rank : number,
                        total_volume : number,
                        high_24h : number,
                        low_24h : number ,
                        price_change_24h : number ,
                        price_change_percentage_24h : number ,
                        market_cap_change_24h : number ,
                        market_cap_change_percentage_24h : number ,
                        circulating_supply : number ,
                        total_supply : number,
                        ath : number,
                        ath_change_percentage : number
                        ) { }
}

export class Balance{
        constructor(public id : number,
                           username : string,
                           nameCoin : string,
                           initialCurrency : number,
                           currentCurrency : number,
                           totalCurrency : number,
                           quantity : number){}
}

export class UserLog {
    constructor(public userLogId : number,
                       username : string,
                       dateLogin : Date
                ){}

}



 class UserService {
    isLoggedIn(): boolean {
      return false;
    }
  }

