import { Component, OnInit } from '@angular/core';
import { ApiService } from '../ApiService';
import { Cliente, ImagenHotel } from '../interfaces';


@Component({
  selector: 'app-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.scss']
})
export class ReservaComponent implements OnInit {
  lista: ImagenHotel[] = [];
  imagenHotel?: ImagenHotel = undefined;
  indice1: number = -1;
  precios: number[]=[80,200,300,800];

  nombres: string='';
  apellidoPaterno: string='';
  apellidoMaterno: string='';
  tipoDocumento: string='';
  numeroDocumento: number=0;
  direcion: string='';
  telefono: number=0;
  correo: string='';
  credencial: string='';
  credencialRepetida: string='';

  

  precioHabitacion: number=0;
  indice: number=0;
  cantidad:number=4;
  mensaje: string="";
  constructor(private api: ApiService) { }
  ngOnInit(): void {
    this.api.obtenerImagenHotel().subscribe( data=>{
      this.lista=data.lista;
    });
  }
  registrar(): void{
    console.log(this.nombres);
    console.log(this.apellidoPaterno);
    console.log(this.apellidoMaterno);
    console.log(this.tipoDocumento);
    console.log(this.numeroDocumento);
    console.log(this.direcion);
    console.log(this.telefono);
    console.log(this.correo);
    console.log(this.credencial);
    console.log(this.credencialRepetida);
    if(this.credencial==this.credencialRepetida){
      const cliente: Cliente ={
        idCliente: undefined,
        nombre: this.nombres,
        apellidoPaterno: this.apellidoPaterno,
        apellidoMaterno: this.apellidoMaterno,
        tipoDocumento: this.tipoDocumento,
        nroDocumento: this.numeroDocumento,
        direccion: this.direcion,
        telefono: this.telefono,
        email: this.correo,
        contraseña: this.credencial,
      };
      this.api.agregarCliente(cliente).subscribe( retorno=>{
        this.mensaje='El usuario' + retorno.nombre + 'fue registrado correctamente';
      });
    }
    else{
      this.mensaje='Las contraseñas no coinciden';
    }
    
  }
  

  ponerPrecio1(): void{
    this.precioHabitacion=this.precios[0];
  }
  ponerPrecio2(): void{
    this.precioHabitacion=this.precios[1];
  }
  ponerPrecio3(): void{
    this.precioHabitacion=this.precios[2];
  }
  ponerPrecio4(): void{
    this.precioHabitacion=this.precios[3];
  }
}
