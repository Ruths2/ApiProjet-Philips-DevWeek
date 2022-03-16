import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Faixaetaria } from '../model/faixaetaria';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FaixaetariaService {
  constructor(private http:HttpClient) { }

  listFaixaEtaria(): Observable<Faixaetaria[] >{
   const caminhourl = '/api/faixaetaria';
    
    return this.http.get<Faixaetaria[]>(caminhourl);
 }
}
