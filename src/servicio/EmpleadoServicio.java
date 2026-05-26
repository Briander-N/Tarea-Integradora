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

    public void estadisticas() {

        int medicos = 0;
        int administrativos = 0;

        double pagoMedicos = 0;
        double pagoAdministrativos = 0;

        Empleado mayor = null;

        for (Empleado e : empleados) {

            if (e instanceof Medico) {
                medicos++;
                pagoMedicos += e.calcularPago();
            }

            if (e instanceof Administrativo) {
                administrativos++;
                pagoAdministrativos += e.calcularPago();
            }

            if (mayor == null ||
                    e.calcularPago() > mayor.calcularPago()) {
                mayor = e;
            }
        }

        System.out.println("Total medicos: " + medicos);
        System.out.println("Total administrativos: " + administrativos);
        System.out.println("Total empleados: " + empleados.size());
        System.out.println("Pago total medicos: " + pagoMedicos);
        System.out.println("Pago total administrativos: " + pagoAdministrativos);

        if (mayor != null) {
            System.out.println("Mayor ingreso: "
                    + mayor.getNombre()
                    + " - "
                    + mayor.calcularPago());
        }
    }

}
