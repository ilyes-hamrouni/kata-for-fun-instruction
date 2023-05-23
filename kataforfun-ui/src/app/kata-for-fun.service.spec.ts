import { KataForFunService } from "./kata-for-fun.service";
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { TestBed } from "@angular/core/testing";

describe('KataForFunService', ()=> {
    let service: KataForFunService;
    let http:HttpTestingController;
    beforeEach(() => {
        TestBed.configureTestingModule(
            {
                imports: [HttpClientTestingModule]
            }
        );
        service = TestBed.inject(KataForFunService);
        http = TestBed.inject(HttpTestingController);
    });

    it('it should be created', () => {
        expect(service).toBeTruthy();
    })
    it('it should convert number', () => {
        service.convertNumber(33).subscribe(
            (data) => {
                console.log(data)
                expect(data).toEqual("FooFooFoo");
            }
        )
        
    })
});


