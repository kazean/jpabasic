package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    private LocalDateTime createDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Member getMember() {
        return member;
    }

    public void changeMember(Member member) {
        if(this.member != null && this.member.getOrders().contains(this))  this.member.getOrders().remove(this);
        this.member = member;
        if(!member.getOrders().contains(this))   member.getOrders().add(this);
    }

    public Product getProduct() {
        return product;
    }

    public void changeProduct(Product product) {
        if(this.product != null && this.product.getOrders().contains(this)) this.product.getOrders().remove(this);
        this.product = product;
        if(!product.getOrders().contains(this)) product.getOrders().add(this);
    }
}
