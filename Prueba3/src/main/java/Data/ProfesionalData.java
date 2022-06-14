package Data;

import Modelos.ProfesionalSalud;

public interface ProfesionalData {
    ProfesionalSalud getProfesional(String rut);
    boolean insertarProfesional(ProfesionalSalud profesionalSalud);
    boolean updateProfesional(ProfesionalSalud profesionalSalud);
    boolean deleteProfesional(ProfesionalSalud profesionalSalud);
}
