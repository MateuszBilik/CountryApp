package com.asap.country_app.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    //    @Email //TODO zrobic mail lower
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany (mappedBy = "appUser")
    private List<Comment> userComments;

    @OneToOne (cascade = CascadeType.ALL)
    private UserInfo userInfo;

    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "visited_Locations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> visitedLocations;

    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "liked_Locations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> likedLocations;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "location_Wanted_To_Visit",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> locationsWantedToVisit;

    public AppUser(String email, String password, UserInfo userInfo, List<Location> visitedLocations, List<Location> likedLocations, List<Location> locationsWantedToVisit) {
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
        this.visitedLocations = visitedLocations;
        this.likedLocations = likedLocations;
        this.locationsWantedToVisit = locationsWantedToVisit;
    }

    public AppUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
