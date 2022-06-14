package Data;

import Modelos.Caso;
import Modelos.IDcaso;

import java.util.HashMap;

public interface CasoData {

    Caso get(IDcaso id);
    Caso getCaso(String rut, int iterador);
    HashMap<IDcaso, Caso> getCaso();
    HashMap<IDcaso,Caso> getCaso(String rutPaciente);
    Caso getCaso(IDcaso iDcaso);
    void insertarCaso(Caso caso);
    void actualizarCaso(Caso caso);
    void eliminarCaso(Caso caso);

}
