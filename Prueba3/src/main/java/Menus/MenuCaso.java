package Menus;

import Data.file.CasoDF;
import Modelos.Caso;
import Modelos.IDcaso;
import Modelos.Paciente;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuCaso {
    public Paciente paciente = new Paciente();
    public MenuPaciente menuPaciente = new MenuPaciente();
    public CasoDF casoDF=new CasoDF();
    public Caso caso=new Caso();

    public Caso casoCrado() {
        Scanner Entrada = new Scanner(System.in);
        String rut, descripcion;
        System.out.println("Ingrese el rut");
        rut = Entrada.nextLine();
        paciente = menuPaciente.buscarPaciente(rut);
        if (paciente != null) {
            Map<IDcaso,Caso> temporal=new HashMap<>();
            temporal=casoDF.getCaso(rut);
           int largo= temporal.size()+1;
            IDcaso id=new IDcaso(rut,largo);
            System.out.println("Descripcion");
            descripcion=Entrada.nextLine();
            return new Caso(id,descripcion);
        }
        else
            System.out.println("Error");
        return null;
    }

    public void generarCaso(){
        caso=casoCrado();
        casoDF.insertarCaso(caso);
    }

    public void buscarCaso(){
        Scanner Entrada = new Scanner(System.in);
        String rut, descripcion;
        short i=1;
        System.out.println("Ingrese el rut");
        rut = Entrada.nextLine();
        paciente = menuPaciente.buscarPaciente(rut);
        Map<IDcaso,Caso> mapa=new HashMap<>();
        mapa=casoDF.getCaso(rut);
        paciente.getCasos(mapa);
        int opt,largo;
        largo= (short) mapa.size();
        do {
            System.out.println("Elija un caso entre 1 y "+largo);
            opt = Integer.parseInt(Entrada.nextLine());
        }while(opt < 0 || opt>=largo);
        IDcaso id = new IDcaso(rut,opt);
        paciente.setCasos(mapa);
        System.out.println(ca);
    }
    public void imprimirCaso(){

    }
}
