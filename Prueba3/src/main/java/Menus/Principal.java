package Menus;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        MenuPaciente menuPaciente=new MenuPaciente();
        MenuCaso menuCaso=new MenuCaso();
        MenuProfesional menuProfesional=new MenuProfesional();
        int opt;
        Scanner entrada=new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("    ----------- Menu -----------");
            System.out.println(" (1) -> Menu Paciente");
            System.out.println(" (2) -> Menu Caso");
            System.out.println(" (3) -> Menu Profesional Salud");
            System.out.println(" (3) -> Menu Centro Salud");
            System.out.println(" (0) -> Salir");
            opt = Integer.parseInt(entrada.nextLine());
            if (opt == 1){
                menuPaciente.PacienteMenu();
            }
            if (opt ==2){
                menuCaso.CasoMenu();
            }
            if (opt == 3){
                menuProfesional.ProfecionalMenu();
            }

            if (opt >2 || opt <0)
                System.out.println("Ingrese una opcion valida");
        } while (opt != 0);
    }
}
