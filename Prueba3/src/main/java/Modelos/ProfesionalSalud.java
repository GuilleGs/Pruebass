package Modelos;

public class ProfesionalSalud extends Persona{

    private String profesion, universidad;
    private int anioEgreso;

    public ProfesionalSalud(String rut, String nombre, String apPaterno, String apMaterno, int edad, String profesion, String universidad, int anioEgreso) {
        super(rut, nombre, apPaterno, apMaterno, edad);
        this.profesion = profesion;
        this.universidad = universidad;
        this.anioEgreso = anioEgreso;
    }

    public ProfesionalSalud(String profesion, String universidad, int anioEgreso) {
        this.profesion = profesion;
        this.universidad = universidad;
        this.anioEgreso = anioEgreso;
    }
    public ProfesionalSalud(){

    }

    public String getProfesion() {
        return profesion;
    }

    public String getUniversidad() {
        return universidad;
    }

    public int getAnioEgreso() {
        return anioEgreso;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public void setAnioEgreso(int anioEgreso) {
        this.anioEgreso = anioEgreso;
    }

    public String toString(){
        return super.toString("Profesional Salud")+
                " -> Profesion        : "+profesion+"\n"+
                " -> Universidad      : "+universidad+"\n"+
                " -> Anio Egreso      : "+anioEgreso+"\n";
    }

    @Override
    public String toString(String titulo){
        return super.toString(titulo)+
                " -> Profesion        : "+profesion+"\n"+
                " -> Universidad      : "+universidad+"\n"+
                " -> Anio Egreso      : "+anioEgreso+"\n";
    }

}
