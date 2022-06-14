package Menus;

import Data.file.PacienteDF;
import Modelos.Paciente;

import java.util.Scanner;

public class PacienteControlador {
    public Paciente paciente=new Paciente();
    public PacienteDF pacienteDF= new PacienteDF();

    public Paciente pacienteCreado(){
        Scanner Entrada=new Scanner(System.in);
        String rut,nombre,apPaterno,apMaterno,email,prevision;
        int edad;
        System.out.println("Rut");
        rut=Entrada.nextLine();
        System.out.println("Nombre:");
        nombre=Entrada.nextLine();
        System.out.println("Apellido Paterno");
        apPaterno=Entrada.nextLine();
        System.out.println("Apellido Materno");
        apMaterno=Entrada.nextLine();
        System.out.println("Edad");
        edad=Integer.parseInt(Entrada.nextLine());
        System.out.println("Email");
        email=Entrada.nextLine();
        System.out.println("Prevision");
        prevision=Entrada.nextLine();
        return new Paciente(rut,nombre,apPaterno,apMaterno,edad,email,prevision);
    }

    //Metodo que agrega un objeto profesionalSalud
    public void generarPaciente(){
        paciente = pacienteCreado();
        pacienteDF.insertarPaciente(paciente);
    }

    public Paciente buscarPaciente(String rut){
        paciente=pacienteDF.getPaciente(rut);
        return paciente;
    }

    public void imprimirPaciente(){
        String rut;
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Ingrese el rut");
        rut=Entrada.nextLine();
        paciente=buscarPaciente(rut);
        if (paciente!=null){
            System.out.println(paciente.toString());
        }
        else
            System.out.println("No existe esta persona");
    }
}
