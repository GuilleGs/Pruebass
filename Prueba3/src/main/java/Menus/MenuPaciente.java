package Menus;

import java.util.Scanner;

public class MenuPaciente {

    public void PacienteMenu() {
        PacienteControlador pacienteControlador = new PacienteControlador();
        int opt;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("    ----------- Menu -----------");
            System.out.println(" (1) -> Ingresar Paciente");
            System.out.println(" (2) -> Mostrar Paciente");
            System.out.println(" (3) -> Eliminar Paciente");
            System.out.println(" (4) -> Modificar Dato");
            System.out.println(" (0) -> Salir");
            opt = Integer.parseInt(entrada.nextLine());
            if (opt == 1) {
                pacienteControlador.generarPaciente();
            }
            if (opt == 2) {
                pacienteControlador.imprimirPaciente();
            }

            if (opt > 4 || opt < 0)
                System.out.println("Ingrese una opcion valida");
        } while (opt != 0);
    }
}


