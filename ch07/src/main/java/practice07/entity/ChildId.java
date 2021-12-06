package practice07.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class ChildId implements Serializable {
//    @Column(name = "PARENT_ID")

    @Column(name = "CHILD_ID")
    private String id;

    private String parentId;

    public ChildId() {
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() + this.parentId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ChildId chdObj = (ChildId)obj;
        return chdObj.getId().equals(this.id) && chdObj.getParentId().equals(this.parentId);
    }
}
