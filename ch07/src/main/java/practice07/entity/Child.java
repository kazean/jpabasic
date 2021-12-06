package practice07.entity;

import javax.persistence.*;

@Entity
//@IdClass(ChildId.class)
public class Child {
    @EmbeddedId
    private ChildId childId;

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent parent;

    private String name;

    public Child() {
    }

    public ChildId getChildId() {
        return childId;
    }

    public void setChildId(ChildId childId) {
        this.childId = childId;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@ManyToOne
    @JoinTable(
            name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
    )
    private Parent parent;*/
}
