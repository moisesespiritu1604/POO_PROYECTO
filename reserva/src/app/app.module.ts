import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {InicioComponent} from './inicio/inicio.component'
import { PagoComponent } from './pago/pago.component';
import { ReservaComponent } from './reserva/reserva.component';
import { HabitacionComponent } from './habitacion/habitacion.component';
import { RegistroComponent } from './registro/registro.component';
import { ServicioComponent } from './servicio/servicio.component';
import { ContactoComponent } from './contacto/contacto.component';
import { ReporteComponent } from './reporte/reporte.component';
import { StoreModule } from '@ngrx/store';
import { sesionUsuarioReducer } from './reducer';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    PagoComponent,
    ReservaComponent,
    HabitacionComponent,
    RegistroComponent,
    ServicioComponent,
    ContactoComponent,
    ReporteComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    StoreModule.forRoot({sesionUsuario: sesionUsuarioReducer })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
