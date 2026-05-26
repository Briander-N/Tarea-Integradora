package servicio;

import modelo.*;
import java.util.ArrayList;


public class EmpleadoServicio {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public boolean existeCedula(String cedula){
        for(Empleado e : empleados){
            if (e.getCedula().equals(cedula)){
                return true;
            }
        }

        return false;
    }

    public void agregar(Empleado empleado){
        empleados.add(empleado);
    }

    public void mostrarTodos(){
        if (empleados.isEmpty()) {
            System.out.println("No existen registros.");
            return;
        }

        for (Empleado e : empleados) {
            e.mostrarInformacion();
            System.out.println("------------------");
        }
    }

    public Empleado buscar(String cedula){
        for(Empleado e : empleados){
            if(e.getCedula().equals(cedula)){
                return e;
            }
        }

        return null;
    }

    public boolean eliminar(String cedula) {

        Empleado e = buscar(cedula);

        if (e != null) {
            empleados.remove(e);
            return true;
        }

        return false;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }


}
