package com.monaco.Entities;

import javax.persistence.*;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@Entity
@Table(name = "TAGS_REF")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TAG_NAME_ID")
    Integer tagNameID;

    @Column(name="TAG_NAME")
    String  tagName;

    public Tag() {

    }

    public Tag(String tagName, Integer tagNameID) {
        this.tagName = tagName;
        this.tagNameID = tagNameID;
    }

    public String getTagName() {
        return tagName;
    }

    public int getTagNameID() {
        return tagNameID;
    }

    @Override
    public String toString() {
        return "-== Tag ==-" + "\n" + tagName + "\n" + tagNameID + "\n" + "-========-";
    }
}
