import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChengePasswordComponent } from './chenge-password.component';

describe('ChengePasswordComponent', () => {
  let component: ChengePasswordComponent;
  let fixture: ComponentFixture<ChengePasswordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChengePasswordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChengePasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
