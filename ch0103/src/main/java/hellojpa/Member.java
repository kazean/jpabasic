package hellojpa;

import javax.persistence.*;

@Entity
public class Member {

    @Id @Column(name="MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;

    public Member(){

    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

}
