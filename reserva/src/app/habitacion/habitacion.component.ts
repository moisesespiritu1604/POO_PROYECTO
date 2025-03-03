import { Component, OnInit } from '@angular/core';
import { ApiService } from '../ApiService';
import { ImagenHabitacion } from '../interfaces';

@Component({
  selector: 'app-habitacion',
  templateUrl: './habitacion.component.html',
  styleUrls: ['./habitacion.component.scss']
})
export class HabitacionComponent implements OnInit {
  lista2: ImagenHabitacion[] = [];
  imagenHabitacion?: ImagenHabitacion = undefined;
  indice: number = -1;
  constructor(private api: ApiService) { }
  ngOnInit(): void {
    this.api.obtenerImagenHabitacion().subscribe(data=>{
      this.lista2=data.lista2;
    });
  }
  verImagenes(): void {
    this.imagenHabitacion =this.lista2[this.indice]
  }

  

}
