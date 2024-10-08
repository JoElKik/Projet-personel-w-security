import {Injectable, Input} from '@angular/core';
import { Menucard } from '../core/models/menu-card';
import {Observable} from "rxjs";
import {Produits} from "src/app/core/models/Produits";
import {Client} from "src/app/core/models/Client";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class MarieTraiteurService {


    constructor(private http: HttpClient) { }

    getAllProduits(): Observable<Produits[]> {

        return this.http.get<Produits[]>('/api/produits');
    }
  // UpdateProduits(): Observable<Produits[]> {
  //
  //   return this.http.put('http://localhost:8080/api/produits/{id]',"");
  // }
  // DeleteProduits(): Observable<Produits[]> {
  //
  //   return this.http.delete('http://localhost:8080/api/produits/{id]');
  // }







}
