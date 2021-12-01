package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class  Team {
    @Id @Column(name = "TEAM_ID")
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name="TEAM_ID")
    private List<Member> members = new ArrayList<>();

    public Team(){
    }

    public Team( String name) {
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

    public List<Member> getMembers() {
        return members;
    }
/*
    public void addMembers(Member member) {
        this.members.add(member);
        if(member.getTeam() != this){
            member.setTeam(this);
        }
    }
    */
}
