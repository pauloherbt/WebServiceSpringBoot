package com.peaga.webservice.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
@Entity(name="tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant instant;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(Integer id, Instant instant, User client) {
        this.id = id;
        this.instant = instant;
        this.client = client;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public Instant getInstant() {
        return instant;
    }

    public User getClient() {
        return client;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}