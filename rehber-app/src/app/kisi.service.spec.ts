import { TestBed } from '@angular/core/testing';

import { KisiService } from './kisi.service';

describe('KisiService', () => {
  let service: KisiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KisiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
