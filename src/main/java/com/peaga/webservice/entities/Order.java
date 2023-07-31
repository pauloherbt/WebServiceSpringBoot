package com.peaga.webservice.entities;

import com.peaga.webservice.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name="tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant instant;
    private Integer orderStatus; //tratar como integer para facilitar manutencao
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> itens = new HashSet<>();


    public Order(Integer id, Instant instant, User client, OrderStatus orderStatus) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        setOrderStatus(orderStatus);
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
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public Set<OrderItem> getItens() {
        return itens;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getId();
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
