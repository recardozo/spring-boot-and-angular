import { TestBed } from '@angular/core/testing';

import { HttpIntercepterAuthService } from './http-intercepter-auth.service';

describe('HttpIntercepterAuthService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpIntercepterAuthService = TestBed.get(HttpIntercepterAuthService);
    expect(service).toBeTruthy();
  });
});
