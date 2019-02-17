import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuCurrencySellComponent } from './menu-currency-sell.component';

describe('MenuCurrencySellComponent', () => {
  let component: MenuCurrencySellComponent;
  let fixture: ComponentFixture<MenuCurrencySellComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuCurrencySellComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuCurrencySellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
