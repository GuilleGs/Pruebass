package Menus;

import java.util.Scanner;

public class MenuProfesional {
    public void ProfecionalMenu(){
        ProfesionalControlador profesionalControlador=new ProfesionalControlador();
        int opt;
        Scanner entrada=new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("    ----------- Menu -----------");
            System.out.println(" (1) -> Ingresar Profesional");
            System.out.println(" (2) -> Mostrar Profesional");
            System.out.println(" (3) -> Eliminar Profesional");
            System.out.println(" (4) -> Modificar Profesional");
            System.out.println(" (0) -> Salir");
            opt = Integer.parseInt(entrada.nextLine());
            if (opt == 1){
                profesionalControlador.generarProfesional();
            }
            if (opt ==2){
                profesionalControlador.imprimirProfesional();
            }
            if (opt ==3){
                profesionalControlador.eliminarProfesional();
            }
            if (opt ==4){
                profesionalControlador.modificarProfesional();
            }
            if (opt >4 || opt <0)
                System.out.println("Ingrese una opcion valida");
        } while (opt != 0);
    }
}
