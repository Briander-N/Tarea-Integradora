package modelo;

public class Medico extends Empleado{
    private String especialidad;
    private int pacientesAtendidos;
    private double valorConsulta;

    public Medico(String cedula, String nombre, int edad, String telefono, String correo, String especialidad, int pacientesAtendidos, double valorConsulta) {
        super(cedula, nombre, edad, telefono, correo);
        this.especialidad = especialidad;
        this.pacientesAtendidos = pacientesAtendidos;
        this.valorConsulta = valorConsulta;
    }

    @Override
    public double calcularPago(){
        return pacientesAtendidos * valorConsulta;
    }
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();

        System.out.println("Especialidad: " + especialidad);
        System.out.println("Pacientes: " + pacientesAtendidos);
        System.out.println("Valor consulta: " + valorConsulta);
        System.out.println("Pago: " + calcularPago());
    }
}
