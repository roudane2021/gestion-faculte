import { Component, OnInit } from '@angular/core';
import { DepartementService } from '../services/departement.service';
import { tap } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit{
  constructor(private departementService: DepartementService, private spinner: NgxSpinnerService){}

  ngOnInit(): void {
    this.spinner.show();
    setTimeout(() => {
      this.spinner.hide();
    }, 5000);
  }
  }

