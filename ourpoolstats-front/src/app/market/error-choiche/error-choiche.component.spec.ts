import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorChoicheComponent } from './error-choiche.component';

describe('ErrorChoicheComponent', () => {
  let component: ErrorChoicheComponent;
  let fixture: ComponentFixture<ErrorChoicheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ErrorChoicheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ErrorChoicheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
