package furama_managemrnt.serrvice.impl;

import furama_managemrnt.model.Division;
import furama_managemrnt.repository.IDivisionRepository;
import furama_managemrnt.serrvice.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
