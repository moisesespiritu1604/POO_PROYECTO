import { Component, OnInit } from '@angular/core';
import { ApiService } from '../ApiService';
import { ImagenServicios } from '../interfaces';

@Component({
  selector: 'app-servicio',
  templateUrl: './servicio.component.html',
  styleUrls: ['./servicio.component.scss']
})
export class ServicioComponent implements OnInit {

  lista: ImagenServicios[] = [];
  imagenServicios?: ImagenServicios = undefined;
  indice: number = -1;
  constructor(private api: ApiService) { }
  ngOnInit(): void {
    this.api.obtenerImagenServicios().subscribe(data=>{
      this.lista=data.lista;
    });
  }
  verServicios(): void {
    this.imagenServicios =this.lista[this.indice]
  }
  

}
// Add scroll reveal animation
window.addEventListener('scroll', function() {
  var reveals = document.querySelectorAll('.animate__animated');
  for (var i = 0; i < reveals.length; i++) {
      var windowHeight = window.innerHeight;
      var elementTop = reveals[i].getBoundingClientRect().top;
      var elementVisible = 150;
      if (elementTop < windowHeight - elementVisible) {
          reveals[i].classList.add('animate__fadeInUp');
      }
  }
});
