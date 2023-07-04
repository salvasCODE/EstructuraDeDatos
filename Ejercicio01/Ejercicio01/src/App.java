//Clase Registro de Estudiantes, con atributos Apellido , Nombre y Calificación.
class RegistroEstudiante {
    private String apellido;
    private String nombre;
    private int calificacion;

    //Constructor de la clase RegistroEstudiante.
    public RegistroEstudiante(String apellido, String nombre, int calificacion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    // Método getter para obtener el Apellido.
    public String getApellido() {
        return apellido;
    }

    // Método getter para obtener el Nombre.
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener la Calificación.
    public int getCalificacion() {
        return calificacion;
    }
}

//Clase Registro de Empleados, con atributos Apellido , Nombre y Salario.
class RegistroEmpleado {
    private String apellido;
    private String nombre;
    private double salario;

    //Constructor de la clase RegistroEmpleado.
    public RegistroEmpleado(String apellido, String nombre, double salario) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.salario = salario;
    }

    // Método getter para obtener el Apellido.
    public String getApellido() {
        return apellido;
    }

    // Método getter para obtener el Nombre.
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener el Salario.
    public double getSalario() {
        return salario;
    }

    // Método setter para establecer el Salario.
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método toString para representar el registro de empleado como una cadena de texto
    public String toString() {
        return apellido + ", " + nombre + " -> Salario: $ " + salario;
    }
}

class AumentoSalario {

    // Método para aplicar el aumento de salario a los empleados que cumplen los criterios
    public void aplicarAumento(RegistroEstudiante[] registrosEstudiantes, RegistroEmpleado[] registrosEmpleados) {
        for (RegistroEstudiante estudiante : registrosEstudiantes) {
            if (estudiante.getCalificacion() > 14) {
                String apellido = estudiante.getApellido();
                String nombre = estudiante.getNombre();
                for (RegistroEmpleado empleado : registrosEmpleados) {
                    if (empleado.getApellido().equals(apellido) && empleado.getNombre().equals(nombre)) {
                        double salarioActual = empleado.getSalario();
                        double aumento = salarioActual * 0.1;
                        double nuevoSalario = salarioActual + aumento;
                        empleado.setSalario(nuevoSalario);
                        break;
                    }
                }
            }
        }
    }
}

//Clase principal del programa.
public class App {
    public static void main(String[] args) {
        // Arreglos de registros de estudiantes y empleados
        RegistroEstudiante[] registrosEstudiantes = {
                new RegistroEstudiante("Alvarado", "Anderson", 18),
                new RegistroEstudiante("Capac", "Carlos", 17),
                new RegistroEstudiante("Gutierres", "Dario", 16)
        };

        RegistroEmpleado[] registrosEmpleados = {
                new RegistroEmpleado("Alvarado", "Anderson", 2000),
                new RegistroEmpleado("Barreto", "Cristian", 1500),
                new RegistroEmpleado("Gutierres", "Dario", 1800)
        };

        // Instancia de la clase AumentoSalario y llamada al método aplicarAumento
        AumentoSalario aumentoSalario = new AumentoSalario();
        aumentoSalario.aplicarAumento(registrosEstudiantes, registrosEmpleados);

        // Imprimir los registros actualizados de empleados
        System.out.println("Registro luego del aumento:");
        for (RegistroEmpleado empleado : registrosEmpleados) {
            System.out.println(empleado);
        }
    }
}