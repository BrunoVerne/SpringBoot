package com.ejemplo.demostracion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimerRestController {

    @GetMapping //mapear solicitudes HTTP GET a métodos específicos en un controlador
    public String saludar(){
        return "Hola mundo";
    }

    //get cuando me pasan algún parametro en el endpoint, en el PathVariable específico
    //le aviso el cambio de nombre de variable si estos son distintos(name != nombre)
    @GetMapping("/{name}")
    public String saludarNombre( @PathVariable(name = "name") String nombre){
        return String.format("Hola %s como estas", nombre);
    }

    @GetMapping("/{a}/{b}") //aca no aviso el cambio de nombre de variable porque se llaman igual
    public int sumar(@PathVariable int a, @PathVariable int b){
        return a  + b;
    }




}
