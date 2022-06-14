package Modelos;

import java.util.HashMap;
import java.util.Map;

public class Paciente extends Persona {
    private String email,prevision;
    private Map<IDcaso, Caso> casos;

    public Paciente(String rut, String nombre, String apPaterno, String apMaterno, int edad, String email, String prevision, Map<IDcaso, Caso> casos) {
        super(rut, nombre, apPaterno, apMaterno, edad);
        this.email = email;
        this.prevision = prevision;
        this.casos = casos;
    }

    public Paciente(String rut, String nombre, String apPaterno, String apMaterno, int edad, String email, String prevision) {
        super(rut, nombre, apPaterno, apMaterno, edad);
        this.email = email;
        this.prevision = prevision;
        this.casos = new HashMap<IDcaso,Caso>();
    }

    public Paciente() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public String getPrevision() {
        return prevision;
    }

    public Map<IDcaso, Caso> getCasos() {
        return casos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public void setCasos(Map<IDcaso, Caso> casos) {
        this.casos = casos;
    }

    public String toString(){
        return super.toString("Paciente")+
                " -> Email     : "+email+"\n"+
                " -> Prevision : "+prevision+"\n";
    }

    @Override
    public String toString(String titulo){
        return super.toString(titulo)+
                " -> Email     : "+email+"\n"+
                " -> Prevision : "+prevision+"\n";
    }

    public void getCasos(Map<IDcaso, Caso> mapa) {
    }
}
