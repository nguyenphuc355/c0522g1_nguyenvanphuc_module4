package furama_managemrnt.serrvice;

import furama_managemrnt.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);

    Facility findById(int id);

    void update(Facility facility);

    void remove(int id);

    Page<Facility> findAll(Pageable pageable);

//    Page<Facility> findByName(Pageable pageable, String name,String phoneNumber,String address);
}
