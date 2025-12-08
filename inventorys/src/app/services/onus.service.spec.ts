import { TestBed } from '@angular/core/testing';

import { OnusService } from './onus.service';

describe('OnusService', () => {
  let service: OnusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OnusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
