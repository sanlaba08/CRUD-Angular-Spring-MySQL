import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Persona } from '../Modelo/Persona';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  persona:Persona;

  constructor(private http:HttpClient) { }

  /* En el servicio nosotros obtendremos la url de nuestra api rest o api externa para poder empezar 
  a manipular los datos */

  url="http://localhost:8080/personas/";

  getPersonas(){
    return this.http.get<Persona[]>(this.url);
  }

  createPersona(persona:Persona){
    return this.http.post<Persona>(this.url, persona);
  }

  getPersonaId(id:number){
    return this.http.get<Persona>(this.url+id);
  }

  updatePersona(persona:Persona){
    return this.http.put<Persona>(this.url+persona.id, persona);
  }

  deletePersona(id:number){
    return this.http.delete<Persona>(this.url+id);
  }

}
