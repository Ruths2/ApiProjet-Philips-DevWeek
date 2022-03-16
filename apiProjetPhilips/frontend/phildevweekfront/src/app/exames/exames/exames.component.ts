import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Faixaetaria } from '../model/faixaetaria';
import { Ocorrencia } from '../model/ocorrencia';
import { Regiao } from '../model/regiao';
import { FaixaetariaService } from '../service/faixaetaria.service';
import { OcorrenciaService } from '../service/ocorrencia.service';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-exames',
  templateUrl: './exames.component.html',
  styleUrls: ['./exames.component.css']
})

export class ExamesComponent implements OnInit, OnDestroy {

  ocorrencia_exame: Ocorrencia[] = [];
  regioes: Regiao[] = [];
  faixaetarias: Faixaetaria[] = [];

  readonly subscriptions = new Subscription();

  constructor(
    private ocorrenciaService: OcorrenciaService,
    private regiaoService: RegiaoService,
    private faixaEtariaService: FaixaetariaService,
  ) { }

  ngOnInit(): void {
    this.listarRegioes();
    this.listarOcorrencias();
    this.listarFaixas();
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  private listarRegioes(): void {
    const subscription = this.regiaoService.listRegiao().subscribe((regioes => {
      this.regioes = regioes;
    }));

    this.subscriptions.add(subscription);
  }

  private listarOcorrencias(): void{
    const subscriptionOcorrencias = this.ocorrenciaService.listOcorrencias().subscribe((
        ocorrecias => {this.ocorrencia_exame = ocorrecias
      }
    ));

    this.subscriptions.add(subscriptionOcorrencias);
  }

  private listarFaixas(): void{
    const subscriptionFaixas = this.faixaEtariaService.listFaixaEtaria().subscribe(( 
      faixa => {this.faixaetarias = faixa}
    ));

    this.subscriptions.add(subscriptionFaixas)
  }

}
