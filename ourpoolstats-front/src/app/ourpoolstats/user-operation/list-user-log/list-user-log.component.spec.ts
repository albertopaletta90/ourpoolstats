import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListUserLogComponent } from './list-user-log.component';

describe('ListUserLogComponent', () => {
  let component: ListUserLogComponent;
  let fixture: ComponentFixture<ListUserLogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListUserLogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListUserLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
