package furama_managemrnt.serrvice;

import furama_managemrnt.model.CustomerType;
import furama_managemrnt.model.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
