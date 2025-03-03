import { Component, OnInit } from '@angular/core';
import { ApiService } from '../ApiService';
import { Reserva } from '../interfaces';

@Component({
  selector: 'app-pago',
  templateUrl: './pago.component.html',
  styleUrls: ['./pago.component.scss']
})
export class PagoComponent implements OnInit {
  /*idPago?: number=undefined;
  reserva: Reserva={
    idReserva:  0,
    cliente: api.obtenerServicios,
    tipoDocumento: string,
    fecha_ingreso: string,
    fecha_salida: string,
    costo_reserva: number,
    estado: string="2312"
  };*/
  tipoComprobante: string='';
  numeroComprobante: number=0;
  pagoTotal: number=0;
  fechaEmision: string='';
  fechaPago: string='';
  estadoPago: string='';
  
  constructor(private api: ApiService) { }

  ngOnInit(): void {
  }

}
