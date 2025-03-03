import {createAction, props} from '@ngrx/store';
import { SesionUsuario} from './interfaces';
export const sesionUsuario = createAction('sesionUsuario',props<SesionUsuario>());