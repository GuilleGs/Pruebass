package Menus;

import Data.file.ProfesionalDF;
import Modelos.ProfesionalSalud;

import java.util.Scanner;

public class ProfesionalControlador {
    public ProfesionalSalud profesionalSalud=new ProfesionalSalud();
    public ProfesionalDF profesionalSaludDF=new ProfesionalDF();

    //Metodo que agrega un objeto profesionalSalud
    public ProfesionalSalud profesionalcreado(){
        Scanner Entrada=new Scanner(System.in);
        String rut,nombre,apPaterno,apMaterno,profesion,universidad;
        int edad,anioEgreso;
        System.out.println("Ingrese rut Profesional");
        rut=Entrada.nextLine();
        System.out.println("Nombre:");
        nombre=Entrada.nextLine();
        System.out.println("Apellido Paterno");
        apPaterno=Entrada.nextLine();
        System.out.println("Apellido Materno");
        apMaterno=Entrada.nextLine();
        System.out.println("Edad");
        edad=Integer.parseInt(Entrada.nextLine());
        System.out.println("Profesion");
        profesion=Entrada.nextLine();
        System.out.println("Universidad");
        universidad=Entrada.nextLine();
        System.out.println("Año de egreso");
        anioEgreso=Integer.parseInt(Entrada.nextLine());
        return new ProfesionalSalud(rut,nombre,apPaterno,apMaterno,edad,profesion,universidad,anioEgreso);
    }

    //Metodo que agrega un objeto profesionalSalud
    public void generarProfesional(){
        profesionalSalud = profesionalcreado();
        profesionalSaludDF.insertarProfesional(profesionalSalud);
    }

    //Metodo que busca un profesionalSalud por su rut
    public ProfesionalSalud buscarProfesional(String rut){
        profesionalSalud = profesionalSaludDF.getProfesional(rut);
        return profesionalSalud;
    }

    //Metodo que imprime por consola un profesionalSalud
    public void imprimirProfesional(){
        String rut;
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Ingrese el rut");
        rut= Entrada.nextLine();
        profesionalSalud = buscarProfesional(rut);
        if (profesionalSalud != null){
            System.out.println(profesionalSalud.toString());
        }
        else{
            System.out.println("No existe esta persona");
        }
    }

    //Metodo que elmina un objeto profesionalSalud
    public ProfesionalSalud eliminarProfesional(){
        String rut;
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Ingrese el rut");
        rut= Entrada.nextLine();
        profesionalSalud = buscarProfesional(rut);
        profesionalSaludDF.deleteProfesional(profesionalSalud);
        return profesionalSalud;
    }

    //Metodo que modifica un objeto profesionalSalud
    public boolean modificarProfesional(){
        String rut;
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Ingrese el rut");
        rut= Entrada.nextLine();
        profesionalSalud = buscarProfesional(rut);
        if (profesionalSalud == null)
            return false;
        else
            profesionalSaludDF.updateProfesional(profesionalSalud);
        return true;
    }
}
