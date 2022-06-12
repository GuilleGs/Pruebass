package Data.file;

import Modelos.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteDF {
    private final Data dataFile;

    public PacienteDF(){
        this.dataFile=new Data("Paciente");
    }

    //Objeto paciente, en una linea CSV
    public String pacientetoCSV(Paciente paciente){
        List<String> datalist=new ArrayList<>();
        datalist.add((paciente.getRut()));
        datalist.add(paciente.getNombre());
        datalist.add(paciente.getApPaterno());
        datalist.add(paciente.getApMaterno());
        datalist.add(Integer.toString(paciente.getEdad()));
        datalist.add(paciente.getEmail());
        datalist.add(paciente.getPrevision());
        return Data.listToCSV(datalist);
    }

    //obtener un paciente desde un csv
    public Paciente pacientefromCSV(String csv){
        String[] parts = csv.split(",");
        return new Paciente(parts[0],parts[1],parts[2],parts[3],Integer.parseInt((parts[4])),parts[5],parts[6]);
    }

    //obtener un paciente por su rut
    public Paciente getPaciente(String rut){
        List<String> data = this.dataFile.getData();
        for (String csv : data){
            if (csv.split(",")[0].equals(rut))
                return pacientefromCSV(csv);
        }
        return null;
    }

    //Agrega un paciente al archivo
    public boolean insertarPaciente(Paciente paciente){
        return this.dataFile.insertLine(pacientetoCSV(paciente));
    }

    //Actualiza los datos de un paciente
    public boolean updatePaciente(Paciente paciente){
        String oldLine = pacientetoCSV(null), newLine = pacientetoCSV(paciente);
        return this.dataFile.updateLine(oldLine,newLine);
    }

    //Elimina un paciente
    public boolean deletePaciente(Paciente paciente){
        return this.dataFile.deleteLine(pacientetoCSV(paciente));
    }
}
