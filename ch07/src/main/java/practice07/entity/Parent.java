package practice07.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id
    @Column(name = "PARENT_ID")
    private String id;

    private String name;

    /*@ManyToMany
    @JoinTable(
            name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
    )
    private List<Child> childList = new ArrayList<>();*/

}
