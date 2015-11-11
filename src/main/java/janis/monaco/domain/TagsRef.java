package janis.monaco.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "TAGS_REF", schema = "", catalog = "monaco")
public class TagsRef {
    private int tagNameId;
    private String tagName;
    private Collection<Route> routesByTagNameId;
    private Collection<User> usersByTagNameId;

    @Id
    @Column(name = "TAG_NAME_ID")
    public int getTagNameId() {
        return tagNameId;
    }

    public void setTagNameId(int tagNameId) {
        this.tagNameId = tagNameId;
    }

    @Basic
    @Column(name = "TAG_NAME")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagsRef tagsRef = (TagsRef) o;

        if (tagNameId != tagsRef.tagNameId) return false;
        if (tagName != null ? !tagName.equals(tagsRef.tagName) : tagsRef.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagNameId;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tagsRefByRouteTagId")
    public Collection<Route> getRoutesByTagNameId() {
        return routesByTagNameId;
    }

    public void setRoutesByTagNameId(Collection<Route> routesByTagNameId) {
        this.routesByTagNameId = routesByTagNameId;
    }

    @OneToMany(mappedBy = "tagsRefByUserTagId")
    public Collection<User> getUsersByTagNameId() {
        return usersByTagNameId;
    }

    public void setUsersByTagNameId(Collection<User> usersByTagNameId) {
        this.usersByTagNameId = usersByTagNameId;
    }
}
