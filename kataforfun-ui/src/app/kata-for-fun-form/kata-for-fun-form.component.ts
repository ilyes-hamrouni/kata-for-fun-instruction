import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { KataForFunService } from '../kata-for-fun.service';

@Component({
  selector: 'app-kata-for-fun-form',
  templateUrl: './kata-for-fun-form.component.html'
})
export class KataForFunFormComponent implements OnInit {


  @Output() submitNumberOutput = new EventEmitter<any>();

  constructor(private kataForFunService: KataForFunService) {

  }

  numberForm = new FormGroup({
    number: new FormControl('',Validators.required)
  })

  ngOnInit(): void {
  }

  submitNumber(): void {
    this.kataForFunService.convertNumber(this.numberForm.value.number).subscribe(
      (data:any) => {
           // should extract the interface to be gloabl.
           this.submitNumberOutput.emit({"numberToConvert": this.numberForm.value.number, result: data.result});
           
      },
      (err) => {
        //todo notifications of error.
          console.log("error occured");
      },
      ()=>{
        this.numberForm.reset();
      }
    )
  }

}
