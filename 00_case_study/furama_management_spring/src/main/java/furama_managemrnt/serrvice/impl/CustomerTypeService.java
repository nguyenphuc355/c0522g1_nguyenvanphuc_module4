package furama_managemrnt.serrvice.impl;

import furama_managemrnt.model.CustomerType;
import furama_managemrnt.repository.ICustomerTypeRepository;
import furama_managemrnt.serrvice.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;


    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
