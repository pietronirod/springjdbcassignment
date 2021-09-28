package br.com.pietroniro.passsenger.dao.impl;

import br.com.pietroniro.passsenger.dao.PassengerDao;
import br.com.pietroniro.passsenger.dao.rowmapper.PassengerRowMapper;
import br.com.pietroniro.passsenger.dto.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("passengerDao")
public class PassengerDaoImpl implements PassengerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Passenger passenger) {
        return jdbcTemplate.update("insert into passenger values(?,?,?)",
                passenger.getId(), passenger.getFirstName(), passenger.getLastName());
    }

    @Override
    public int update(Passenger passenger) {
        return jdbcTemplate.update("update passenger set firstname=?, lastname=? where id=?",
                passenger.getFirstName(), passenger.getLastName(), passenger.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from passenger where id=?", id);
    }

    @Override
    public Passenger read(int id) {
        return jdbcTemplate.queryForObject("select * from passenger where id=?",
                new PassengerRowMapper(), id);
    }

    @Override
    public List<Passenger> read() {
        return (List<Passenger>) jdbcTemplate.query("select * from passenger", new PassengerRowMapper());
    }
}
