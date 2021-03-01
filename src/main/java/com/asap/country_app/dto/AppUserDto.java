package com.asap.country_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
//TODO do we need no args constructor
@NoArgsConstructor
public class AppUserDto{

        private UUID id;

        private String email;
        private String password;
        private String role = "ROLE_USER";

        private UserInfoDto userInfoDto;

        private List<LocationDto> visitedLocations;

        private List<LocationDto> likedLocations;

        private List<LocationDto> locationsWantedToVisit;

        public AppUserDto(UUID id, String email, String password) {
                this.id = id;
                this.email = email;
                this.password = password;
        }

        public AppUserDto(UUID id, String email, String password, UserInfoDto userInfoDto, List<LocationDto> visitedLocations, List<LocationDto> likedLocations, List<LocationDto> locationsWantedToVisit) {
                this.id = id;
                this.email = email;
                this.password = password;
                this.userInfoDto = userInfoDto;
                this.visitedLocations = visitedLocations;
                this.likedLocations = likedLocations;
                this.locationsWantedToVisit = locationsWantedToVisit;
        }
}
