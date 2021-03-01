package com.asap.country_app.dto;

import com.asap.country_app.database.model.Location;
import com.asap.country_app.database.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private UUID id;
    private LocalDateTime created;
    private String text;

    private AppUser appUser;
    private Location location;

    public CommentDto(LocalDateTime created, String text, AppUser appUser, Location location) {
        this.created = created;
        this.text = text;
        this.appUser = appUser;
        this.location = location;
    }
}
