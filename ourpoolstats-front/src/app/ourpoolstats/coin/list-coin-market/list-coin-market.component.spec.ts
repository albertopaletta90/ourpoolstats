import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCoinMarketComponent } from './list-coin-market.component';

describe('ListCoinMarketComponent', () => {
  let component: ListCoinMarketComponent;
  let fixture: ComponentFixture<ListCoinMarketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListCoinMarketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCoinMarketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
