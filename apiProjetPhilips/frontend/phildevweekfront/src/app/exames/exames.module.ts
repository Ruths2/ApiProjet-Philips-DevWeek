import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';

import { ExamesRoutingModule } from './exames-routing.module';
import { ExamesComponent } from './exames/exames.component';
import {MatSortModule} from '@angular/material/sort';

@NgModule({
  declarations: [
    ExamesComponent
  ],
  imports: [
    CommonModule,
    ExamesRoutingModule,
    MatSortModule,
    MatCardModule
  ]
})
export class ExamesModule { }
