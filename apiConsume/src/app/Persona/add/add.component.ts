import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/Modelo/Persona';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  per:Persona = new Persona();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
  }

  Guardar(nombre:String, apellido: String){    
    this.per.nombre = nombre;
    this.per.apellido = apellido;
    this.service.createPersona(this.per)
    .subscribe(data=>{
      this.router.navigate(["listar"]);
    })
  }

}
