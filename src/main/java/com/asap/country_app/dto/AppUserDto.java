package com.asap.country_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
//TODO do we need no args constructor
@NoArgsConstructor
public class AppUserDto {

        private UUID id;

        private String email;
        private String password;

        private UserInfoDto userInfoDto;

        private List<LocationDto> visitedLocations;

        private List<LocationDto> likedLocations;

        private List<LocationDto> locationsWantedToVisit;

        public AppUserDto(UUID id, String email, String password) {
                this.id = id;
                this.email = email;
                this.password = password;
        }
}


