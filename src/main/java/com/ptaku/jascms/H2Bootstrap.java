package com.ptaku.jascms;

import com.ptaku.jascms.entity.ReservationEntity;
import com.ptaku.jascms.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

    private ReservationRepository reservationRepository;

    @Autowired
    public H2Bootstrap(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-15", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-16", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-17", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-18", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-19", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-20", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-25", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-30", "dupa"));
        reservationRepository.save(new ReservationEntity("Wymiana opon", "2019-03-31", "dupa"));

    }
}
