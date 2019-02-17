import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuValueCoinComponent } from './menu-value-coin.component';

describe('MenuValueCoinComponent', () => {
  let component: MenuValueCoinComponent;
  let fixture: ComponentFixture<MenuValueCoinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuValueCoinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuValueCoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
