import { HttpClient } from '@angular/common/http';

export class LoginResponse {
    constructor(public status: String, public typeUser ) { }
}

export class GenericResponse {
    constructor(public status: String, public error: String,public data :Array<string>) { }
}

export class CoinGekoResponse {
    constructor(public status: String, public error: String ,public coingekoList :Array<CoinGeko>) { }
}

export class CoinMarketResponse {
    constructor(public status: String, public error: String ,public coinMarketList :Array<CoinMarket>) { }
}

export class CoinMarketInfoResponse {
    constructor(public status: String, public error: String ,public coinInfo :CoinMarket) { }
}

export class CurrentyCoinResponse {
    constructor(public status : string, public error : string,public value : number){}
}

export class BalanceResponse {
    constructor(public status: String, public error: String,public balance : Balance[]) { }
}

export class LogUserResponse {
    constructor(public status: String, public error: String,public userLog : Array<UserLog>) { }
}

export class UserListResponse {
    constructor(public status: String, public error: String,public userList : Array<UserList>) { }
}

export class StringResponse {
    constructor(public data:string[]) {}
}

export class PortfolioResponse {
    constructor(public status:string,
                public error : string,
                public master: Portfolio[],
                public partecipant: Portfolio[]) {}
}


export class Portfolio {
    constructor(public id :number,
                public username : string,
                public userType : string,
                public nameCoin : string,
                public priceInitial : number,
                public priceCurrent : number,
                public quantity : number,
                public partecipant : boolean,
                public nameCoinPartecipant : string){}
}

export class Login {
    constructor(public user: String, password: String) {}
}

export class User {
    constructor(public name : string ,public surname :string,  public username: String, password: String ,email: string) {

    }
}


export class CoinInfo {
    constructor(public nameCoin: String) {

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
                        quantity : number,
                        image : string) { }
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
                        ath_change_percentage : number,
                        ath_date : Date
                        ) { }
}

export class Balance{
        constructor(public id : number,public username : string, public nameCoin : string, public initialCurrency : number, public currentCurrency : number, public totalCurrency : number, public quantity : number,public util : number ,public image : string){}
}

export class UserLog {
    constructor(public userLogId : number,public username : string, public dateLogin : Date){}
}

export class UserList {
    constructor(public name : string,public surname : string,public username : string,public email : string,public userType : string){}
}

export function getName(){
    return 'ciao';
}

