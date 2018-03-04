import { TestBed, inject } from '@angular/core/testing';

import { QcmService } from './qcm.service';

describe('QcmService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QcmService]
    });
  });

  it('should ...', inject([QcmService], (service: QcmService) => {
    expect(service).toBeTruthy();
  }));
});
