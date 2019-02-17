import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBalanceBuyComponent } from './list-balance-buy.component';

describe('ListBalanceBuyComponent', () => {
  let component: ListBalanceBuyComponent;
  let fixture: ComponentFixture<ListBalanceBuyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListBalanceBuyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBalanceBuyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
