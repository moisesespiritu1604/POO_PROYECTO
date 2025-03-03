import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { retry, catchError } from "rxjs/operators";
import { Cliente, RespuestaImagenHabitacion, RespuestaImagenHotel, RespuestaImagenServicios, RespuestaServicios } from "./interfaces";

@Injectable({ providedIn: 'root'})
export class ApiService{
    httpOptions={
        headers: new HttpHeaders({
            'conten-type': 'application/json;charset=utf-8'
        })
    };
    errorHandl(error: any){
        let errorMessage='';
        if(error.error instanceof ErrorEvent){
            errorMessage=error.error.message;
        }
        else{
            errorMessage=`Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        console.log(errorMessage);
        return throwError(errorMessage);
    }
    constructor(private http: HttpClient){}
    obtenerImagenHotel(): Observable<RespuestaImagenHotel> {
        return this.http.post<RespuestaImagenHotel>('http://127.0.0.1:8080/obtener-imagenHotel',null,this.httpOptions).
        pipe(
            retry(1),
            catchError(this.errorHandl)
        );
    }
    obtenerImagenHabitacion(): Observable<RespuestaImagenHabitacion> {
        return this.http.post<RespuestaImagenHabitacion>('http://127.0.0.1:8080/obtener-imagenHabitacion',null,this.httpOptions).
        pipe(
            retry(1),
            catchError(this.errorHandl)
        );
    }
    obtenerServicios(): Observable<RespuestaServicios> {
        return this.http.post<RespuestaServicios>('http://127.0.0.1:8080/obtener-servicios',null,this.httpOptions).
        pipe(
            retry(1),
            catchError(this.errorHandl)
        );
    }
    obtenerImagenServicios(): Observable<RespuestaImagenServicios> {
        return this.http.post<RespuestaImagenServicios>('http://127.0.0.1:8080/obtener-imagenServicios',null,this.httpOptions).
        pipe(
            retry(1),
            catchError(this.errorHandl)
        );
    }
    agregarCliente(data: Cliente): Observable<Cliente> {
        return this.http.post<Cliente>('http://127.0.0.1:8080/crear-cuentacliente',data,this.httpOptions).
        pipe(
            retry(1),
            catchError(this.errorHandl)
        );
    }
    obtenerCliente(data: Cliente): Observable<Cliente> {
        return this.http.post<Cliente>('http://127.0.0.1:8080/autenticar-cliente',data,this.httpOptions).
        pipe(
            retry(1),
            catchError(this.errorHandl)
        );
    }
}