package furama_managemrnt.serrvice.impl;

import furama_managemrnt.model.Position;
import furama_managemrnt.repository.IPositionRepository;
import furama_managemrnt.serrvice.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
