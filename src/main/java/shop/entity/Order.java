package shop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id @Column(name ="ORDER_ID") @GeneratedValue
    private Long id;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public Order(Long id, Long memberId, Date orderDate, OrderStatus status) {
        this.id = id;
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
