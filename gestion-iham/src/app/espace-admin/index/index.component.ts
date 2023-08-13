import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { SubMenu, listSubMenu } from '../models/departement.model';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit{

  @ViewChild('sidenav') sidenav!: MatSidenav;
  showSubDepatement: boolean = false;
  showSubSemistre: boolean = false;
  menus= listSubMenu;
  constructor(){}
  ngOnInit(): void {
  
  }

  mouseenter() {
    
  }

  mouseleave() {
  
  }
  openSidenav() {
    this.sidenav.toggle();
  }

  toggleSubMenu(subMenu : SubMenu = SubMenu.Departement): void {

    switch (subMenu) {
      case SubMenu.Departement: {
        this.showSubDepatement = !this.showSubDepatement;
        break;
      }
      case SubMenu.Semistre: {
        this.showSubSemistre = !this.showSubSemistre;
        break;
      }
    }
  }

  }

