package Harvest.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Orders {

    private int orderId;
    private LocalDate orderDate;
    private BigDecimal orderTotal;
    private int userId;

    public Orders(int orderId, LocalDate orderDate, BigDecimal orderTotal, int userId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.userId = userId;
    }

    public Orders() {
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
