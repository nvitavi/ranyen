import { TestBed } from '@angular/core/testing';

import { RanyenService } from './ranyen.service';

describe('RanyenService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RanyenService = TestBed.get(RanyenService);
    expect(service).toBeTruthy();
  });
});
