import { TestBed } from '@angular/core/testing';

import { Rateservice } from './rateservice';

describe('Rateservice', () => {
  let service: Rateservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Rateservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
