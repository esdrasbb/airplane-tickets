package org.fa7.service;

import org.fa7.database.ReservaRepository;
import org.fa7.database.model.Reserva;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservaService {

    private static final Logger log = LoggerFactory.getLogger("system");

    @Autowired
    private ReservaRepository reservaRepository;

    //only for test
    public void validate() {

        log.info("Start validate...");

        reservaRepository.save(new Reserva());
        reservaRepository.save(new Reserva());
        reservaRepository.save(new Reserva());
        reservaRepository.save(new Reserva());

        log.info("Reserva found with findAll():");
        log.info("-------------------------------");
        for (Reserva reserva : reservaRepository.findAll()) {
            log.info(reserva.toString());
            log.info(reservaRepository.findOne(reserva.getId()).toString());
        }
    }

}
