package practice07.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
        @AttributeOverride(name="id", column = @Column(name="SELLER_ID")),
        @AttributeOverride(name="name", column = @Column(name = "SELLLER_NAME"))
})
public class Seller extends  BaseEntity{
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
