package com.asap.country_app.database.Functions;

import com.asap.country_app.database.model.AppUser;
import com.asap.country_app.dto.AppUserDto;

import java.util.function.Function;
import java.util.stream.Collectors;

import static com.asap.country_app.database.Functions.LocationFunctions.locationDTOToLocation;
import static com.asap.country_app.database.Functions.LocationFunctions.locationToLocationDTO;
import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoDTOToUserInfo;
import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoToUserInfoDTO;

public class UserFunctions {

    public static final Function<AppUser, AppUserDto> userToUserDTOCreate = user ->  new AppUserDto(
            user.getId(),
            user.getEmail(),
            user.getPassword()
    );

    public static final Function<AppUserDto, AppUser> userDTOToUserCreate = appUserDto -> new AppUser(
            appUserDto.getEmail(),
            appUserDto.getPassword()
    );

    public static final Function<AppUser, AppUserDto> userToUserDTO = user ->  new AppUserDto(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            userInfoToUserInfoDTO.apply(user.getUserInfo()),
            user.getLocationsWantedToVisit().stream().map(locationToLocationDTO).collect(Collectors.toList()),
            user.getLikedLocations().stream().map(locationToLocationDTO).collect(Collectors.toList()),
            user.getVisitedLocations().stream().map(locationToLocationDTO).collect(Collectors.toList())
    );

    public static final Function<AppUserDto, AppUser> userDTOToUser = appUserDto -> new AppUser(
            appUserDto.getEmail(),
            appUserDto.getPassword(),
            userInfoDTOToUserInfo.apply(appUserDto.getUserInfoDto()),
            appUserDto.getLocationsWantedToVisit().stream().map(locationDTOToLocation).collect(Collectors.toList()),
            appUserDto.getLikedLocations().stream().map(locationDTOToLocation).collect(Collectors.toList()),
            appUserDto.getVisitedLocations().stream().map(locationDTOToLocation).collect(Collectors.toList())
    );
}