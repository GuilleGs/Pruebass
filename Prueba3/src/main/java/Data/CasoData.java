package Data;

import Modelos.Caso;
import Modelos.IDcaso;

import java.util.HashMap;

public interface CasoData {

    public Caso get(IDcaso id);
    HashMap<IDcaso, Caso> getCaso();
    HashMap<IDcaso,Caso> getCaso(String rutPaciente);
    HashMap<IDcaso,Caso> getCaso(IDcaso iDcaso);
    void insertarCaso(Caso caso);
    void actualizarCaso(Caso caso);
    void eliminarCaso(Caso caso);

}
