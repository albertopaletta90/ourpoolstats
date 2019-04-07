import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteCoinComponent } from './delete-coin.component';

describe('DeleteCoinComponent', () => {
  let component: DeleteCoinComponent;
  let fixture: ComponentFixture<DeleteCoinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteCoinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteCoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
