package org.acme.carro.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class Carro extends PanacheEntity {
    public String modelo;
    public String fabricante;
}
