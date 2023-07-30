package com.peaga.webservice.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);
    private int id;

    private OrderStatus(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }
    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getId()==code)
                return value;
        }
        throw new IllegalArgumentException("Error on OrderStatus id");
    }
}
