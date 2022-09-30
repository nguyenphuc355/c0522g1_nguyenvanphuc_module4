package repository.impl;

import model.FacilityType;
import repository.BaseRepository;
import repository.IFacilityTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepository implements IFacilityTypeRepository {
    private final String FACILITY_TYPE ="select * from facility_type;";
    @Override
    public List<FacilityType> findAll() {
        List<FacilityType> facilityTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(FACILITY_TYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("facility_type_id");
                String name = resultSet.getString("facility_type_name");

                FacilityType facilityType = new FacilityType(id,name);
                facilityTypeList.add(facilityType);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return facilityTypeList;
    }
}
