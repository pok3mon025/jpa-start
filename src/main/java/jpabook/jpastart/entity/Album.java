package jpabook.jpastart.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artList;
    private String etc;

    public String getArtList() {
        return artList;
    }

    public void setArtList(String artList) {
        this.artList = artList;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
