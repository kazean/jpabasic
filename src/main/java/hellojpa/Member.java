package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="MEMBER_TB")
public class Member {

    @Id
    private Long id;
//    @Column(name="member_name")
    private String name;
    private int ag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAg() {
        return ag;
    }

    public void setAg(int ag) {
        this.ag = ag;
    }
}
