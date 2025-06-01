package com.example.orderservice.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")  // Название таблицы
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;  // Номер заказа

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id") // Чтобы сохранить внешний ключ в таблице OrderLineItems
    private List<OrderLineItems> orderLineItemsList;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderLineItems> getOrderLineItemsList() {
        return orderLineItemsList;
    }

    public void setOrderLineItemsList(List<OrderLineItems> orderLineItemsList) {
        this.orderLineItemsList = orderLineItemsList;
    }
}
