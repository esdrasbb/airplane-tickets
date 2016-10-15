package org.fa7.database;

import org.fa7.database.model.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {

//    List<Reserva> findById(Long id);
}
