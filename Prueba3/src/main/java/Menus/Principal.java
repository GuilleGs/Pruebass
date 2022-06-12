package Menus;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        MenuPaciente menuPaciente=new MenuPaciente();
        MenuCaso menuCaso=new MenuCaso();
        int opt;
        Scanner entrada=new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("    ----------- Menu -----------");
            System.out.println(" (1) -> Paciente");
            System.out.println(" (2) -> Caso");
            System.out.println(" (3) -> Eliminar Datos");
            System.out.println(" (4) -> Modificar Datos");
            System.out.println(" (5) -> Buscar Datos");
            System.out.println(" (0) -> Salir");
            opt = Integer.parseInt(entrada.nextLine());
            if (opt == 1){
                menuPaciente.generarPaciente();
            }
            if (opt ==2){
                menuCaso.generarCaso();
            }
            if (opt ==3){
                menuPaciente.imprimirPaciente();
            }
            if (opt ==4){
                menuCaso.buscarCaso();
            }
            if (opt==5){

            }
            if (opt >5 || opt <0)
                System.out.println("Ingrese una opcion valida");
        } while (opt != 0);
    }
}
