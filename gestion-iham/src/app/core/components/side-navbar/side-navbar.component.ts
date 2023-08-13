import { Component, OnInit } from '@angular/core';
import { HttpclientService } from '../../services/HttpClientService';
import { IMenu } from '../../models/core';
import * as Menu from '../../models/menu';
import { GENERAL } from '../../models/../../shared/models/constatnts';
import { JwtService } from 'src/app/shared/services/jwt-service';
import { menuEtudiant } from '../../models/menu';


@Component({
  selector: 'app-side-navbar',
  templateUrl: './side-navbar.component.html',
  styleUrls: ['./side-navbar.component.scss']
})
export class SideNavbarComponent implements OnInit {

  menuList!: IMenu[];
  constructor(private httpService: HttpclientService, private jwtService: JwtService) { }

  ngOnInit() {
    this.initMenu();
  }

  private initMenu(): void {
    const profile = this.jwtService.getUserApp()?.PROFILE;
    switch (profile) {
      case GENERAL.PROFILE.ADMIN : {
        this.menuList = Menu.menuAdmin;
        break;
      }
      case GENERAL.PROFILE.ENSEIGNANT : {
        this.menuList = Menu.menuAdmin;
        break;

      }
      case GENERAL.PROFILE.ETUDIANT : {
        this.menuList = Menu.menuEtudiant;
        break;

      }
    }
  }
}
