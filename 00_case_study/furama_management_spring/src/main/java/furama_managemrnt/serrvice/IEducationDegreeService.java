package furama_managemrnt.serrvice;

import furama_managemrnt.model.CustomerType;
import furama_managemrnt.model.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
}
