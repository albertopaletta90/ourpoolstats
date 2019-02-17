import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChengeUserTypeComponent } from './chenge-user-type.component';

describe('ChengeUserTypeComponent', () => {
  let component: ChengeUserTypeComponent;
  let fixture: ComponentFixture<ChengeUserTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChengeUserTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChengeUserTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
