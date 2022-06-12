package Modelos;

public abstract class Persona {
    private String rut,nombre,apPaterno,apMaterno;
    private int edad;

    public Persona(String rut, String nombre, String apPaterno, String apMaterno, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.edad = edad;
    }

    public Persona() {

    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString(){
        return "Datos person: \n"+
                " ->Rut              : "+rut+"\n"+
                " ->Nombre           : "+nombre+"\n"+
                " ->Apellido paterno : "+apPaterno+"\n"+
                " ->Apellido materno : "+apMaterno+"\n";
    }

    public String toString(String titulo){
        return "Datos "+titulo+": \n"+
                " -> Rut              : "+rut+"\n"+
                " -> Nombre           : "+nombre+"\n"+
                " -> Apellido paterno : "+apPaterno+"\n"+
                " -> Apellido materno : "+apMaterno+"\n";
    }

}
