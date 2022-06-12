package Modelos;

import java.util.Map;

public class Caso {

    private IDcaso id;
    private String descripcion;

    public Caso(IDcaso id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public Caso(){
        this.id=id;
        this.descripcion=descripcion;
    }
    public IDcaso getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(IDcaso id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
