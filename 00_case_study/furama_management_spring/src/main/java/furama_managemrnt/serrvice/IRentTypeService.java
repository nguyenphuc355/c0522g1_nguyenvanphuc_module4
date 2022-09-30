package furama_managemrnt.serrvice;

import furama_managemrnt.model.Division;
import furama_managemrnt.model.RenType;

import java.util.List;

public interface IRentTypeService {
    List<RenType> findAll();
}
