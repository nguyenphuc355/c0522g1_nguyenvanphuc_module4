package furama_managemrnt.serrvice;

import furama_managemrnt.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
