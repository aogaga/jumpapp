import {Component, OnInit, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Rateservice} from './service/rateservice';
import {Rateresponse} from './models/rateresponse.model';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReactiveFormsModule, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit {
  form!: FormGroup;
  rateResponse?: Rateresponse;
  convertedAmount?: number;

  constructor(private rateService: Rateservice, private fb: FormBuilder) {
    this.loadDataAndForm();
  }
  ngOnInit(): void {


  }

  loadDataAndForm(){
    this.form = this.fb.group({
      amount: [null, Validators.required],
      currency: ['', Validators.required]
    });

    this.rateService.getRate().subscribe(rate => {
      this.rateResponse = new Rateresponse(rate);
    });

    this.form.valueChanges.subscribe(() => {
      this.autoConvert();
    });
  }
  convert() {
    this.autoConvert();
    console.log(`Converted Amount: ${this.convertedAmount}`);
  }

  autoConvert() {
    const amount = this.form.value.amount;
    const currency = this.form.value.currency;

    if (this.rateResponse && amount && currency) {
      this.convertedAmount = this.rateResponse.convert(amount, currency);
    } else {
      this.convertedAmount = undefined;
    }
  }

}
