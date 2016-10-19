package org.fa7.database.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva extends BaseModel {

    //FIXME como será o relacionamento com voo
    public Reserva() {
    }


}

