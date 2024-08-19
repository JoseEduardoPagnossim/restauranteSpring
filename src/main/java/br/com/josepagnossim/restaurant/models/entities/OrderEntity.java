package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.enums.PaymentType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private double totalValue;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PaymentType paymentMethod;

    private double change;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = this.client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }


    public PaymentType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }


}
