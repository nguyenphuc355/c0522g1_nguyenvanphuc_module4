package furama_managemrnt.serrvice;

import furama_managemrnt.model.CustomerType;
import furama_managemrnt.model.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
}
