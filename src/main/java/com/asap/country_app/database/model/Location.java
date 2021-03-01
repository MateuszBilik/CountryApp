package com.asap.country_app.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String country;
    private String city;

    @OneToMany (mappedBy = "location")
    private List<Comment> locationComments;

    @ManyToMany(mappedBy = "visitedLocations")
    private List<AppUser> visitors;
    @ManyToMany(mappedBy = "likedLocations")
    private List<AppUser> likes;
    @ManyToMany(mappedBy = "locationsWantedToVisit")
    private List<AppUser> whoWantsToVisit;

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
