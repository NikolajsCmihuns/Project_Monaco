package com.monaco.Entities;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@Entity
@Table(name = "TAGS_REF")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TAG_NAME_ID")
    private Integer tagNameID;

    @Column(name="TAG_NAME")
    private String tagName;

    public Tag() {

    }

    public Tag(String tagName, Integer tagNameID) {
        this.tagName = tagName;
        this.tagNameID = tagNameID;
    }

    public Integer getTagNameID() {
        return tagNameID;
    }

    public void setTagNameID(Integer tagNameID) {
        this.tagNameID = tagNameID;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "-== Tag ==-" + "\n" + tagName + "\n" + tagNameID + "\n" + "-========-";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (!getTagNameID().equals(tag.getTagNameID())) return false;
        return getTagName().equals(tag.getTagName());

    }

    @Override
    public int hashCode() {
        int result = getTagNameID().hashCode();
        result = 31 * result + getTagName().hashCode();
        return result;
    }
}
