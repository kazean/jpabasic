package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {
    @Id @Column(name = "TEAM_ID")
    @GeneratedValue
    private String id;
    private String name;


}
