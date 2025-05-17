package Controller;

import Clases.Alumno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerAlumno {
    List<Alumno> alumnos;

    public ControllerAlumno(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void agregarAlumno(Alumno nuevoAlumno){
        this.alumnos.add(nuevoAlumno);
    }


    @GetMapping(path = "/alumnos")
    public List<Alumno> getAlumnos(){
        return this.alumnos;
    }

    public int getcantidadAlumnos(){
        return this.alumnos.size();
    }

    @GetMapping(path = "/alumnos/{dato}")
    public Alumno getAlumnoPorNombreOApellido(@PathVariable String dato){
        Alumno alumnoEncontrado = null;
        int i = 0;

        while(alumnoEncontrado == null || i < this.getcantidadAlumnos()){
            Alumno alumnoActual = this.alumnos.get(i);
            if(alumnoActual.getApellido().equals(dato) ||
                    alumnoActual.getNombre().equals(dato)){
                alumnoEncontrado = alumnoActual;
            }
        }
        return alumnoEncontrado;
    }

    @GetMapping("/alumnos/{dni}")
    public Alumno getAlumnoPorDni(@PathVariable int dni){
        Alumno alumnoEncontrado = null;
        int i = 0;
        while(alumnoEncontrado == null || i < this.getcantidadAlumnos()){
            Alumno alumnoActual = this.alumnos.get(i);
            if(alumnoActual.getDni() == dni){
                alumnoEncontrado = alumnoActual;
            }
        }
        return alumnoEncontrado;
    }
}
