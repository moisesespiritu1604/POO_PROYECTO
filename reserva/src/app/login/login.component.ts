import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import * as action from './../action';
import { ApiService } from '../ApiService';
import { Cliente, SesionUsuario } from '../interfaces';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  email : string='';
  clave: string='';
  mensaje: string='';
  constructor(
    private api: ApiService, 
    private StoreSesion: Store<{sesionUsuario}>,
    private route: Router
    ) { }
  
  ngOnInit(): void {
    
  }
  ingresar(): void{
    const cliente: Cliente={
      idCliente: 0,
      nombre: '',
      apellidoPaterno:'',
      apellidoMaterno:'',
      tipoDocumento:'',
      nroDocumento: 0,
      direccion: '',
      telefono: 0,
      email: this.email,
      contraseña: this.clave,
    };
    this.api.obtenerCliente(cliente).subscribe( respuesta=>{
      if(respuesta.idCliente != null){
        this.mensaje='Validacion exitosa';
        const sesionUsuario: SesionUsuario={
          id : respuesta.idCliente,
          correo: respuesta.email,
          nombres: respuesta.nombre +' ' +respuesta.apellidoPaterno,
        };
        this.StoreSesion.dispatch(action.sesionUsuario(sesionUsuario));
        this.route.navigateByUrl("");
      }
      else{
        this.mensaje='Los datos ingresados son incorrectos';
      }
    });
  }
}
