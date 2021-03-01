package com.asap.country_app.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @GeneratedValue
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private LocalDateTime created;
    private String text;

    //TODO check if CascadeType.ALL will remove all comments and locations from database if user is deleted
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private AppUser appUser;
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "location_id")
    private Location location;

    public Comment(LocalDateTime created, String text, AppUser appUser, Location location) {
        this.created = created;
        this.text = text;
        this.appUser = appUser;
        this.location = location;
    }
}
