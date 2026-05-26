# Sistema de Gestión de Personal para Clínica Privada

## Descripción

Este proyecto fue desarrollado en Java utilizando Programación Orientada a Objetos (POO). El sistema permite gestionar el personal de una clínica privada mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar), búsqueda por cédula, cálculo de pagos y generación de estadísticas.

Los tipos de empleados gestionados son:

- Médicos
- Administrativos

---

# Funcionalidades

- Registrar médicos.
- Registrar administrativos.
- Mostrar empleados registrados.
- Buscar empleados por cédula.
- Actualizar información.
- Eliminar registros.
- Calcular pagos.
- Mostrar estadísticas.
- Validar datos ingresados por el usuario.

---

# Herencia

La herencia permite que una clase reutilice atributos y métodos de otra clase.

En este proyecto existe una clase padre llamada `Empleado`, que contiene la información común de todos los trabajadores:

- Cédula
- Nombre
- Edad
- Teléfono
- Correo

A partir de esta clase se crean las clases hijas:

- `Medico`
- `Administrativo`

Estas heredan los atributos y métodos de la clase `Empleado`, evitando duplicación de código y facilitando el mantenimiento del sistema.

---

# Encapsulamiento

El encapsulamiento consiste en proteger los atributos de una clase mediante el uso de modificadores de acceso.

Los atributos fueron declarados como `private`, impidiendo el acceso directo desde otras clases.

Para acceder o modificar los datos se utilizan métodos getters y setters.

Beneficios:

- Mayor seguridad de los datos.
- Mejor control sobre la información.
- Facilita futuras modificaciones del sistema.

---

# Polimorfismo

El polimorfismo permite que diferentes objetos respondan de forma distinta a un mismo método.

Se implementó utilizando:

```java
ArrayList<Empleado> empleados = new ArrayList<>();
```

La lista almacena tanto objetos `Medico` como objetos `Administrativo`.

Cada clase implementa su propia versión del método:

```java
calcularPago()
```

Médico:

```java
pago = pacientesAtendidos * valorConsulta;
```

Administrativo:

```java
pago = horasTrabajadas * valorHora;
```

De esta forma Java ejecuta automáticamente el método correspondiente según el tipo real del objeto.

---

# Excepciones

Las excepciones permiten controlar errores durante la ejecución del programa.

Se utilizó principalmente la estructura:

```java
try {
    // código
}
catch(Exception e) {
    // manejo del error
}
```

Excepciones utilizadas:

### NumberFormatException

Se produce cuando se intenta convertir texto a número y el contenido no es válido.

Ejemplo:

```java
Integer.parseInt("abc");
```

### Exception

Utilizada para capturar errores generales que puedan ocurrir durante la ejecución.

Beneficios:

- Evita que el programa se cierre inesperadamente.
- Permite mostrar mensajes de error claros al usuario.
- Mejora la estabilidad del sistema.

---

# Conversiones

Las conversiones permiten transformar datos de un tipo a otro.

### String a int

```java
String edad = "25";
int e = Integer.parseInt(edad);
```

### String a double

```java
String valor = "15.50";
double precio = Double.parseDouble(valor);
```

### Conversión explícita (Casting)

```java
double promedio = 9.8;
int nota = (int) promedio;
```

Resultado:

```java
9
```

Las conversiones fueron necesarias para procesar correctamente los datos ingresados por el usuario desde el teclado.

---

# Validaciones

Las validaciones permiten asegurar que los datos ingresados sean correctos antes de almacenarlos.

Se implementó una clase llamada `Validador`.

Validaciones aplicadas:

### Edad

- Mayor que 0.
- Menor que 150.

### Correo

Debe contener:

- @
- .

### Teléfono

Solo permite números.

### Campos obligatorios

No se permiten campos vacíos en:

- Nombre
- Correo
- Especialidad
- Departamento

### Valores positivos

Aplicado a:

- Pacientes atendidos.
- Valor consulta.
- Horas trabajadas.
- Valor por hora.

### Cédula

No se permiten registros duplicados.

Estas validaciones garantizan la integridad y calidad de la información almacenada.

---

# Tecnologías Utilizadas

- Java
- Programación Orientada a Objetos (POO)
- ArrayList
- Herencia
- Encapsulamiento
- Polimorfismo
- Excepciones
- Validaciones
- UML

---

# Autor

Estudiante de la Escuela Politécnica Nacional

Proyecto académico desarrollado para la materia de Programación Orientada a Objetos.
