package Data.file;

import Modelos.Caso;
import Modelos.IDcaso;
import Data.CasoData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CasoDF implements CasoData {
    private final Data datafile;

    public CasoDF(){
        this.datafile = new Data("Caso");
    }

    public String casoToCSV(Caso caso){
        List<String> dataList = new ArrayList<>();
        dataList.add(caso.getId().getRut());
        dataList.add(Integer.toString(caso.getId().getIterador()));
        dataList.add(caso.getDescripcion());
        return Data.listToCSV(dataList);
    }

    public Caso casoFromCSV(String csv){
        String[] parts = csv.split(",");
        return new Caso(new IDcaso(parts[0],Integer.parseInt(parts[1])),parts[2]);
    }

    public Caso get(IDcaso id){
        return null;
    }

    public Caso getCaso(String rut, int iterador) {
        List<String> data = this.datafile.getData();
        for (String csv : data)
            if ((csv.split(",")[0].equals(rut)) && ((Integer.parseInt(csv.split(",")[0]) == iterador))){
                return casoFromCSV(csv);
        }
        return null;
    }

    public HashMap<IDcaso, Caso> getCaso(){
        HashMap<IDcaso,Caso> casos = new HashMap<>();
        List<String> data = this.datafile.getData();
        IDcaso id;
        String[] parts;
        Caso caso;
        for (String csv: data){
            parts=csv.split(",");
            id=new IDcaso(parts[0],Integer.parseInt(parts[1]));
            caso =new Caso(id, parts[2]);
            casos.put(id,casoFromCSV(csv));
        }
        return casos;
    }

    public HashMap<IDcaso,Caso> getCaso(String rutPaciente){
        HashMap<IDcaso,Caso> casos=new HashMap<>();
        List<String> data=this.datafile.getData();
        IDcaso id;
        String[] parts;
        Caso caso;
        for (String csv:data){
            parts = csv.split(",");
            if (parts[0].equals(rutPaciente)){
                id=new IDcaso(parts[0],Integer.parseInt(parts[1]));
                caso = new Caso(id,parts[2]);
                casos.put(id,casoFromCSV(csv));
            }
        }
        return casos;
    }

    public Caso getCaso(IDcaso iDcaso){
        List<String> data = this.datafile.getData();
        IDcaso id;
        String[] parts;
        for (String csv: data){
            parts=csv.split(",");
            if ((csv.split(",")[0].equals(iDcaso.getRut())) && (Integer.parseInt(parts[1])==iDcaso.getIterador())){
                id=new IDcaso(parts[0],Integer.parseInt(parts[1]));
                return new Caso(id,parts[2]);
            }
        }
        return null;
    }

    public void insertarCaso(Caso caso){
        this.datafile.insertLine(casoToCSV(caso));
    }

    public void actualizarCaso(Caso caso){
        String oldLine=casoToCSV(get(caso.getId())),newLine=casoToCSV(caso);
        this.datafile.updateLine(oldLine,newLine);
    }

    public void eliminarCaso(Caso caso){
        this.datafile.deleteLine(casoToCSV(caso));
    }

}
