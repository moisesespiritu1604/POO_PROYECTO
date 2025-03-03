import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactoComponent } from './contacto/contacto.component';
import { HabitacionComponent } from './habitacion/habitacion.component';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { PagoComponent } from './pago/pago.component';
import { RegistroComponent } from './registro/registro.component';
import { ReporteComponent } from './reporte/reporte.component';
import { ReservaComponent } from './reserva/reserva.component';
import { ServicioComponent } from './servicio/servicio.component';

const routes: Routes = [
  //enrutamiento
  {path: "" , component: InicioComponent},
  {path:"pago", component:PagoComponent},
  {path:"reserva", component:ReservaComponent},
  {path:"habitacion", component:HabitacionComponent},
  {path:"registro", component:RegistroComponent},
  {path:"servicio", component:ServicioComponent},
  {path:"contacto", component:ContactoComponent},
  {path:"login", component:LoginComponent},
  {path:"reporte", component:ReporteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
