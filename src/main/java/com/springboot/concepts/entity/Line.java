package com.springboot.concepts.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_line")
public class Line {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
     * The parent entity, Post, features two utility methods (e.g. addComment and
     * removeComment) which are used to synchronize both sides of the bidirectional
     * association. You should always provide these methods whenever you are working
     * with a bidirectional association as, otherwise, you risk very subtle state
     * propagation issues.
     */

    @OneToMany(
        mappedBy = "line",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Station> stations = new ArrayList<>();

    private String lineName;

    @CreationTimestamp
    private Date dateCreated;

    @UpdateTimestamp
    private Date dateModified;
    private int status;

    /**                                                                                                                                                 
     * The parent entity, Post, features two utility methods (e.g. addComment and
     * removeComment) which are used to synchronize both sides of the bidirectional
     * association. You should always provide these methods whenever you are working
     * with a bidirectional association as, otherwise, you risk very subtle state
     * propagation issues.
     */
    public void addStation(Station station) {
        stations.add(station);
        station.setLine(this);
    }

    public void removeStation(Station station) {
        stations.remove(station);
        station.setLine(null);
    }
    
}
