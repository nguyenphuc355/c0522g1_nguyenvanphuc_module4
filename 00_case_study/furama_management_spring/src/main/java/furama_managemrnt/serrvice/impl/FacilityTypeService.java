package furama_managemrnt.serrvice.impl;

import furama_managemrnt.model.FacilityType;
import furama_managemrnt.repository.IFacilityTypeRepository;
import furama_managemrnt.serrvice.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
