package com.ptaku.jascms;

import com.ptaku.jascms.entity.CarEntity;
import com.ptaku.jascms.entity.CustomerEntity;
import com.ptaku.jascms.entity.RepairEntity;
import com.ptaku.jascms.entity.ReservationEntity;
import com.ptaku.jascms.repository.CarRepository;
import com.ptaku.jascms.repository.CustomerRepository;
import com.ptaku.jascms.repository.RepairRepository;
import com.ptaku.jascms.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

    private CarRepository carRepository;
    private CustomerRepository customerRepository;
    private RepairRepository repairRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public H2Bootstrap(CarRepository carRepository, CustomerRepository customerRepository,
                       RepairRepository repairRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.repairRepository = repairRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-15", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-16", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-17", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-18", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-19", "dupa"));

        carRepository.save(new CarEntity("Mazda", "LUB3447E", "GGFHJK5555555", 205000L));
        carRepository.save(new CarEntity("Uno", "PUB3447E", "BGFHJK5555555", 200000L));
        carRepository.save(new CarEntity("Lada", "LUB3447E", "HBGFHJK5555555", 200700L));
        carRepository.save(new CarEntity("Audi", "YUB3447E", "BGFHJK5555555", 280040L));
        carRepository.save(new CarEntity("Jeep", "LUB3447E", "JBGFHJK5555555", 200000L));
        carRepository.save(new CarEntity("BMW", "JUB3447E", "BPGFHJK5555555", 200800L));

        customerRepository.save(new CustomerEntity("Jan", "Kowalski", "666555999", "jan@kowalski.com"));
        customerRepository.save(new CustomerEntity("Mateusz", "Kowalski", "666555999", "jan@kowalski.com"));
        customerRepository.save(new CustomerEntity("Łukasz", "Kowalski", "666555999", "jan@kowalski.com"));
        customerRepository.save(new CustomerEntity("Paweł", "Kowalski", "666555999", "jan@kowalski.com"));
        customerRepository.save(new CustomerEntity("Cezary", "Kowalski", "666555999", "jan@kowalski.com"));

        repairRepository.save(new RepairEntity("Wymiana opon", "O godz 11", 50.00));
        repairRepository.save(new RepairEntity("Wymiana opon", "O godz 11", 50.00));
        repairRepository.save(new RepairEntity("Wymiana opon", "O godz 11", 50.00));
        repairRepository.save(new RepairEntity("Wymiana silnika", "O godz 11", 800.00));
        repairRepository.save(new RepairEntity("Naprawa silnika", "O godz 11", 500.00));

    }
}
