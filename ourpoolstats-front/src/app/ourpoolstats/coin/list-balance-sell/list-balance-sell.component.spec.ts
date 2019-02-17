import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBalanceSellComponent } from './list-balance-sell.component';

describe('ListBalanceSellComponent', () => {
  let component: ListBalanceSellComponent;
  let fixture: ComponentFixture<ListBalanceSellComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListBalanceSellComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBalanceSellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
