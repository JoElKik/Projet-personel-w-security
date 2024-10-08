import { Component, Input, OnInit } from '@angular/core';
import { Menucard } from '../../../core/models/menu-card';
import { MarieTraiteurService } from '../../../services/MarieTraiteur.service';
import {Produits} from "../../../core/models/Produits";
import {Observable} from "rxjs";

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.scss']
})
export class MenuListComponent implements OnInit {
    Produits$! : Observable<Produits[]>


    constructor(private marieTraiteurService: MarieTraiteurService) { }






    ngOnInit() {
        this.Produits$ = this.marieTraiteurService.getAllProduits();




    }
}
