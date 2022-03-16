import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ocorrencia } from '../model/ocorrencia';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OcorrenciaService {
    constructor(private http:HttpClient) { }

  listOcorrencias(): Observable<Ocorrencia[]> {
    const caminho = '/api/ocorrencias'
    return this.http.get<Ocorrencia[]>(caminho);
  }
}
