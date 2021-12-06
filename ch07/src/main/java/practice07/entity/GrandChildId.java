package practice07.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class GrandChildId implements Serializable {
    @Embedded
    private ChildId childId;

    @Column(name = "GRANDCHILD_ID")
    private String id;

    public GrandChildId() {
    }

    public ChildId getChildId() {
        return childId;
    }

    public void setChildId(ChildId childId) {
        this.childId = childId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return this.childId.hashCode()+this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        GrandChildId gchd = (GrandChildId) obj;
        return gchd.getChildId().equals(childId) && gchd.equals(id);
    }
}
