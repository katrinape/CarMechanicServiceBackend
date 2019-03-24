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
        RepairEntity repair = new RepairEntity("Wymiana opon", "O godz 11", 50.00);

        car.addRepair(repair);
        customer.addReservation(reservation);
        customer.addCar(car);
        customerRepository.save(customer);

        customer = new CustomerEntity("Mikołaj", "Pietroń", "236456987", "miki@fiki.com");
        reservation = new ReservationEntity("Naprawa hamulców", "2019-03-16", "Nikt nie potrafi tego zrobić");
        car = new CarEntity("BMW", "LUB456E", "1236523698GHJLURSWEB", 225000L);
        repair = new RepairEntity("Naprawa hamulców", "Wszystko jest zardzewiałe", 250.00);

        car.addRepair(repair);
        customer.addReservation(reservation);
        customer.addCar(car);
        customerRepository.save(customer);

        customer = new CustomerEntity("Łukasz", "Warzywoda", "321456963", "vandyke@wp.pl");
        reservation = new ReservationEntity("Naprawa zawieszenia", "2019-03-17", "Nikt nie potrafi tego zrobić");
        car = new CarEntity("Jeep", "WE1236E", "456328741MKJDGJLIYR", 267000L);
        repair = new RepairEntity("Naprawa zawieszenia", "Nikt nie potrafi tego zrobić", 320.00);

        car.addRepair(repair);
        customer.addReservation(reservation);
        customer.addCar(car);
        customerRepository.save(customer);

        customer = new CustomerEntity("Ola", "Wrona", "669879321", "ola@wp.pl");
        reservation = new ReservationEntity("Wymiana silnika", "2019-03-21", "Bardzo trudna strawa");
        car = new CarEntity("Mazda", "WE124KE", "456LKH789LKJ46312FGHJK", 278900L);
        repair = new RepairEntity("Wymiana silnika", "Wymieniono", 520.00);

        car.addRepair(repair);
        customer.addReservation(reservation);
        customer.addCar(car);
        customerRepository.save(customer);

    }
}
