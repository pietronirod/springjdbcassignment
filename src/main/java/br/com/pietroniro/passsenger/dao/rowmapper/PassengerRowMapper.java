package br.com.pietroniro.passsenger.dao.rowmapper;

import br.com.pietroniro.passsenger.dto.Passenger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerRowMapper implements RowMapper<Passenger> {

    @Override
    public Passenger mapRow(ResultSet resultSet, int i) throws SQLException {
        Passenger passenger = new Passenger();
        passenger.setId(resultSet.getInt(1));
        passenger.setFirstName(resultSet.getString(2));
        passenger.setLastName(resultSet.getString(3));
        return passenger;
    }
}
