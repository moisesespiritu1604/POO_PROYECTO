import {createReducer, on} from '@ngrx/store';
import * as states from './action';
import { SesionUsuario} from './interfaces';

export const initialSesionUsuario:SesionUsuario = {
    id: 0,
    correo: '',
    nombres: ''
};

const _sesionUsuarioReducer = createReducer(
    initialSesionUsuario, 
    on(states.sesionUsuario,(state,{id, correo, nombres}) => ( 
            {id: id, correo : correo, nombres : nombres} )
    )
);
export function sesionUsuarioReducer(state: SesionUsuario, action: any){
    return _sesionUsuarioReducer(state,action);
}
