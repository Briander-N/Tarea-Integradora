package app;

import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmpleadoServicio servicio = new EmpleadoServicio();

        int opcion = 0;

        do {

            System.out.println("\n===== CLINICA SALUD TOTAL =====");
            System.out.println("1. Registrar medico");
            System.out.println("2. Registrar administrativo");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Buscar por cedula");
            System.out.println("5. Reemplazar informacion");
            System.out.println("6. Eliminar registro");
            System.out.println("7. Calcular pagos");
            System.out.println("8. Mostrar estadisticas");
            System.out.println("9. Salir");

            try {

                System.out.print("Seleccione una opcion: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:

                        System.out.println("\n=== REGISTRAR MEDICO ===");

                        System.out.print("Cedula: ");
                        String cedulaM = sc.nextLine();

                        if (servicio.existeCedula(cedulaM)) {
                            System.out.println("Cedula ya registrada.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombreM = sc.nextLine();

                        if (!Validador.textoValido(nombreM)) {
                            System.out.println("Nombre invalido.");
                            break;
                        }

                        System.out.print("Edad: ");
                        int edadM = Integer.parseInt(sc.nextLine());

                        if (!Validador.edadValida(edadM)) {
                            System.out.println("Edad invalida.");
                            break;
                        }

                        System.out.print("Telefono: ");
                        String telefonoM = sc.nextLine();

                        if (!Validador.telefonoValido(telefonoM)) {
                            System.out.println("Telefono invalido.");
                            break;
                        }

                        System.out.print("Correo: ");
                        String correoM = sc.nextLine();

                        if (!Validador.correoValido(correoM)) {
                            System.out.println("Correo invalido.");
                            break;
                        }

                        System.out.print("Especialidad: ");
                        String especialidad = sc.nextLine();

                        System.out.print("Pacientes atendidos: ");
                        int pacientes = Integer.parseInt(sc.nextLine());

                        System.out.print("Valor consulta: ");
                        double valorConsulta = Double.parseDouble(sc.nextLine());

                        Medico medico = new Medico(
                                cedulaM,
                                nombreM,
                                edadM,
                                telefonoM,
                                correoM,
                                especialidad,
                                pacientes,
                                valorConsulta
                        );

                        servicio.agregar(medico);

                        System.out.println("Medico registrado correctamente.");

                        break;

                    case 2:

                        System.out.println("\n=== REGISTRAR ADMINISTRATIVO ===");

                        System.out.print("Cedula: ");
                        String cedulaA = sc.nextLine();

                        if (servicio.existeCedula(cedulaA)) {
                            System.out.println("Cedula ya registrada.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombreA = sc.nextLine();

                        System.out.print("Edad: ");
                        int edadA = Integer.parseInt(sc.nextLine());

                        System.out.print("Telefono: ");
                        String telefonoA = sc.nextLine();

                        System.out.print("Correo: ");
                        String correoA = sc.nextLine();

                        System.out.print("Departamento: ");
                        String departamento = sc.nextLine();

                        System.out.print("Horas trabajadas: ");
                        int horas = Integer.parseInt(sc.nextLine());

                        System.out.print("Valor por hora: ");
                        double valorHora = Double.parseDouble(sc.nextLine());

                        Administrativo admin = new Administrativo(
                                cedulaA,
                                nombreA,
                                edadA,
                                telefonoA,
                                correoA,
                                departamento,
                                horas,
                                valorHora
                        );

                        servicio.agregar(admin);

                        System.out.println("Administrativo registrado.");

                        break;

                    case 3:

                        servicio.mostrarTodos();

                        break;

                    case 4:

                        System.out.print("Ingrese cedula: ");
                        String buscarCedula = sc.nextLine();

                        Empleado encontrado = servicio.buscar(buscarCedula);

                        if (encontrado != null) {

                            encontrado.mostrarInformacion();

                        } else {

                            System.out.println("Registro no encontrado.");
                        }

                        break;

                    case 5:

                        System.out.print("Cedula del empleado: ");
                        String cedulaEditar = sc.nextLine();

                        Empleado editar = servicio.buscar(cedulaEditar);

                        if (editar != null) {

                            System.out.print("Nuevo nombre: ");
                            editar.setNombre(sc.nextLine());

                            System.out.print("Nueva edad: ");
                            editar.setEdad(
                                    Integer.parseInt(sc.nextLine())
                            );

                            System.out.print("Nuevo telefono: ");
                            editar.setTelefono(sc.nextLine());

                            System.out.print("Nuevo correo: ");
                            editar.setCorreo(sc.nextLine());

                            System.out.println("Datos actualizados.");

                        } else {

                            System.out.println("Empleado no encontrado.");
                        }

                        break;

                    case 6:

                        System.out.print("Cedula a eliminar: ");
                        String eliminarCedula = sc.nextLine();

                        if (servicio.eliminar(eliminarCedula)) {

                            System.out.println("Registro eliminado.");

                        } else {

                            System.out.println("Empleado no encontrado.");
                        }

                        break;

                    case 7:

                        System.out.println("\n=== PAGOS ===");

                        for (Empleado e : servicio.getEmpleados()) {

                            System.out.println(
                                    e.getNombre()
                                            + " -> "
                                            + e.calcularPago()
                            );
                        }

                        break;

                    case 8:

                        servicio.estadisticas();

                        break;

                    case 9:

                        System.out.println("Saliendo del sistema...");

                        break;

                    default:

                        System.out.println("Error: opcion invalida.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Error: debe ingresar numeros validos.");

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 9);

        sc.close();
    }
}