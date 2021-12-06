package practice07.entity;

import javax.persistence.*;

@Entity
//@IdClass(GrandChildId.class)
public class GrandChild {
    /*@Id @Column(name="GRANDCHILD_ID")
    private String id;*/

    @EmbeddedId
    private GrandChildId grandChildId;

    @MapsId("childId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    public Child child;

    private String name;

    public GrandChild() {
    }

    public GrandChildId getGrandChildId() {
        return grandChildId;
    }

    public void setGrandChildId(GrandChildId grandChildId) {
        this.grandChildId = grandChildId;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
