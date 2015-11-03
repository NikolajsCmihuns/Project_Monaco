package janis.monakoTest.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "TAGS_REF", schema = "", catalog = "monaco_test")
public class TagsRefEntity {
    private int tagNameId;
    private String tagName;
    private Collection<RouteEntity> routesByTagNameId;
    private Collection<UserEntity> usersByTagNameId;

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

        TagsRefEntity that = (TagsRefEntity) o;

        if (tagNameId != that.tagNameId) return false;
        if (tagName != null ? !tagName.equals(that.tagName) : that.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagNameId;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tagsRefByRouteTagId")
    public Collection<RouteEntity> getRoutesByTagNameId() {
        return routesByTagNameId;
    }

    public void setRoutesByTagNameId(Collection<RouteEntity> routesByTagNameId) {
        this.routesByTagNameId = routesByTagNameId;
    }

    @OneToMany(mappedBy = "tagsRefByUserTagId")
    public Collection<UserEntity> getUsersByTagNameId() {
        return usersByTagNameId;
    }

    public void setUsersByTagNameId(Collection<UserEntity> usersByTagNameId) {
        this.usersByTagNameId = usersByTagNameId;
    }
}
