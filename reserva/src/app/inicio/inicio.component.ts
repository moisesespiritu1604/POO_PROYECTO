import { Component, OnInit } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { ApiService } from '../ApiService';
import { ImagenHotel, SesionUsuario } from '../interfaces';
import { initialSesionUsuario } from '../reducer';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss']
})
export class InicioComponent implements OnInit {

  lista: ImagenHotel[] = [];
  imagenHotel?: ImagenHotel = undefined;
  indice: number = -1;
  sesionUsuario$ : Observable<any>;
  sesionUsuario : SesionUsuario;
  constructor(
    private api: ApiService,
    private StoreSesion: Store<{sesionUsuario}>
    ) { }
  ngOnInit(): void {
    this.sesionUsuario=initialSesionUsuario;
    this.sesionUsuario$ = this.StoreSesion.pipe(select('sesionUsuario'));
    this.sesionUsuario$.subscribe(reaccion=>{
      this.sesionUsuario=reaccion;
    } );
    this.api.obtenerImagenHotel().subscribe(data=>{
      this.lista=data.lista;
    });
  }
  verProducto(): void {
    this.imagenHotel =this.lista[this.indice]
  }
}
