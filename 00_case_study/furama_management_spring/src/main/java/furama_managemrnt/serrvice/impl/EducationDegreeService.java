package furama_managemrnt.serrvice.impl;

import furama_managemrnt.model.EducationDegree;
import furama_managemrnt.repository.IEducationDegreeRepository;
import furama_managemrnt.serrvice.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
