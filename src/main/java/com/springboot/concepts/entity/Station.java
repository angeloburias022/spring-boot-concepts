package com.springboot.concepts.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_station")
public class Station {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
     * The @ManyToOne association uses FetchType.LAZY because, 
     * otherwise, we’d fallback to EAGER fetching which is bad for performance.
    */
    @ManyToOne(fetch = FetchType.LAZY)
    private Line line;

    private String stationName;
    private String stationAlias;
    private int isLastStation;
    private int status;
    
    /**
     * The child entity, PostComment, implement the equals and hashCode methods.
     * Since we cannot rely on a natural identifier for equality checks, we need to
     * use the entity identifier instead for the equals method. However, you need to
     * do it properly so that equality is consistent across all entity state
     * transitions, which is also the reason why the hashCode has to be a constant
     * value. Because we rely on equality for the removeComment, it’s good practice
     * to override equals and hashCode for the child entity in a bidirectional
     * association.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Station))
            return false;
        return id != null && id.equals(((Station) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
