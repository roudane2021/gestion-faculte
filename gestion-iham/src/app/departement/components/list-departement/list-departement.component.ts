import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-list-departement',
  templateUrl: './list-departement.component.html',
  styleUrls: ['./list-departement.component.scss']
})
export class ListDepartementComponent implements OnInit{

  constructor(private translateService: TranslateService) {
  }
  ngOnInit(): void {
  }

  useLanguage(language: string): void {
    this.translateService.use(language);
}

}
