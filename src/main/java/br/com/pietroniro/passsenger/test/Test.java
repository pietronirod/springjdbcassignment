package br.com.pietroniro.passsenger.test;

import br.com.pietroniro.passsenger.dao.PassengerDao;
import br.com.pietroniro.passsenger.dto.Passenger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    private static PassengerDao dao;
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        dao = (PassengerDao) ctx.getBean("passengerDao");
//        createPassenger();
//        System.out.println(readPassenger());
//        updatePassenger();
        System.out.println(readPassenger());
        readlAllPassengers();
    }

    private static void createPassenger() {
        Passenger passenger = new Passenger();
        passenger.setId(1);
        passenger.setFirstName("David");
        passenger.setLastName("Pietroniro");

        if (dao.create(passenger) > 0) {
            System.out.println("Passenger created");
        }
    }

    private static Passenger readPassenger() {
        return dao.read(1);
    }

    private static void readlAllPassengers() {
        List<Passenger> list = dao.read();
        list.forEach(System.out::println);
    }

    private static void updatePassenger() {
        Passenger passenger = new Passenger();
        passenger.setId(1);
        passenger.setFirstName("John");
        passenger.setLastName("Connor");
        if (dao.update(passenger) > 0) {
            System.out.println("Passenger updated");
        }

    }
}
