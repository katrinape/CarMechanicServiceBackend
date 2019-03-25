package com.ptaku.jascms;

import com.ptaku.jascms.entity.CarEntity;
import com.ptaku.jascms.entity.CustomerEntity;
import com.ptaku.jascms.entity.RepairEntity;
import com.ptaku.jascms.entity.ReservationEntity;
import com.ptaku.jascms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

    private CustomerRepository customerRepository;


    @Autowired
    public H2Bootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        CustomerEntity customer = new CustomerEntity("Jan", "Kowalski", "666555999", "jan@kowalski.com");
        ReservationEntity reservation = new ReservationEntity("Wymiana opon", "2019-03-15", "Nie będzie łatwo");
        CarEntity car = new CarEntity("Mazda", "LUB3447E", "1236547412MNBCZXCVBN", 205000L);
        RepairEntity repair = new RepairEntity(reservation.getTitle(), reservation.getDescription(), 50.00);

        car.addRepair(repair);
        customer.addReservation(reservation);
        customer.addCar(car);
        customerRepository.save(customer);

        customer = new CustomerEntity("Mikołaj", "Pietrow", "236456987", "miki@fiki.com");
        reservation = new ReservationEntity("Naprawa hamulców", "2019-03-16", "Nikt nie potrafi tego zrobić");
        car = new CarEntity("BMW", "LUB456E", "1236523698GHJLURSWEB", 225000L);
        repair = new RepairEntity(reservation.getTitle(), reservation.getDescription(), 250.00);

        car.addRepair(repair);
        customer.addReservation(reservation);
        customer.addCar(car);
        customerRepository.save(customer);

        customer = new CustomerEntity("Ola", "Nowak", "669321456", "ola@wp.pl");
        reservation = new ReservationEntity("Naprawa silnika", "2019-03-18", "Wszystkie części trzeba kupić");
        car = new CarEntity("Maseratti", "WE7456E", "189545632198GHJLURSWEB", 225090L);
        repair = new RepairEntity(reservation.getTitle(), reservation.getDescription(), 950.00);

        car.addRepair(repair);
        customer.addReservation(reservation);
        customer.addCar(car);
        customerRepository.save(customer);

        customer = new CustomerEntity("Marek", "Janik", "236456987", "marek@gmail.com");
        reservation = new ReservationEntity("Naprawa zawieszenia", "2019-03-19", "Bardzo zardzewiałe");
        car = new CarEntity("Opel", "WE895LP", "123UIO3698GH456SWEB", 245000L);
        repair = new RepairEntity(reservation.getTitle(), reservation.getDescription(), 350.00);

        car.addRepair(repair);
        customer.addReservation(reservation);
        customer.addCar(car);
        customerRepository.save(customer);
    }
}
