package Menus;

import Data.file.CasoDF;
import Modelos.Caso;
import Modelos.IDcaso;
import Modelos.Paciente;

import java.util.Map;
import java.util.Scanner;

public class CasoControlador {
    public Paciente paciente = new Paciente();
    public PacienteControlador pacienteControlador=new PacienteControlador();
    public CasoDF casoDF=new CasoDF();
    public Caso caso=new Caso();

    public Caso casoCrado() {
        Scanner Entrada = new Scanner(System.in);
        String rut, descripcion;
        System.out.println("Ingrese el rut");
        rut = Entrada.nextLine();
        paciente =pacienteControlador.buscarPaciente (rut);
        if (paciente != null) {
            Map<IDcaso,Caso> temporal;
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

    public void ImprimrCasos(){
        Scanner Entrada = new Scanner(System.in);
        String rut;
        System.out.println("Ingrese el rut");
        rut = Entrada.nextLine();
        paciente = pacienteControlador.buscarPaciente(rut);
        Map<IDcaso,Caso> mapa;
        mapa=casoDF.getCaso(rut);
        for (Map.Entry<IDcaso,Caso>casos:mapa.entrySet()) {
            System.out.println(casos.getValue().getDescripcion());
        }
    }

}
