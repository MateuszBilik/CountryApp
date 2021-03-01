package com.asap.country_app.service;

import com.asap.country_app.database.errors.UserNotFoundException;
import com.asap.country_app.database.repository.UserInfoRepository;
import com.asap.country_app.database.repository.UserRepository;
import com.asap.country_app.database.model.Location;
import com.asap.country_app.database.model.AppUser;
import com.asap.country_app.database.model.UserInfo;
import com.asap.country_app.dto.LocationDto;
import com.asap.country_app.dto.AppUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static com.asap.country_app.database.Functions.LocationFunctions.locationDTOToLocation;
import static com.asap.country_app.database.Functions.UserFunctions.userDTOToUserCreate;
import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTO;
import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTOCreate;


@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoR;
    private final LocationService locationService;

    public UserService(UserRepository userRepository, UserInfoRepository userInfoR, LocationService locationService) {
        this.userRepository = userRepository;
        this.userInfoR = userInfoR;
        this.locationService = locationService;
    }

    @Transactional
    public AppUserDto saveUser(AppUserDto appUserDto) {
//TODO sprawdzenie wielkosci liter w mailu?
        if (userRepository.findByEmail(appUserDto.getEmail()).isEmpty()) {
            AppUser appUser = userDTOToUserCreate.apply(appUserDto);
            appUser.setUserInfo(new UserInfo());
            log.info("User created: " + appUserDto.getEmail());
            return userToUserDTOCreate.apply(userRepository.save(appUser));
        } else {
            log.info("This mail exists: " + appUserDto.getEmail());
            //TODO if there will be time refactor to throw exepction, if not - leave as is
            return null;
        }
    }

    @Transactional
    public void deleteUser(UUID id) throws UserNotFoundException {
        AppUser appUser = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(appUser);
    }

    @Transactional
    public boolean addLikedLocation(LocationDto locationDto, UUID userId) {
        Location location = locationService.findByCountryAndCity(locationDto.getCountry(), locationDto.getCity());
        AppUser appUser = userRepository.findById(userId).orElseGet(null);

        List<Location> list = appUser.getLikedLocations();
        log.info("User {} change status liked for location {} to", userId, locationDto.getCity());
        changeLocationStatus(locationDto, location, list);

        appUser.setLikedLocations(list);
        userRepository.save(appUser);

        return true;
    }

    @Transactional
    public boolean addVisitedLocation(LocationDto locationDto, UUID userId) {
        Location location = locationService.findByCountryAndCity(locationDto.getCountry(), locationDto.getCity());
        AppUser appUser = userRepository.findById(userId).orElseGet(null);

        List<Location> list = appUser.getVisitedLocations();
        log.info("User {} change status visited for location {} to", userId, locationDto.getCity());
        changeLocationStatus(locationDto, location, list);

        appUser.setVisitedLocations(list);
        userRepository.save(appUser);
        log.info("User {} remove {}");
        return true;
    }

    private void changeLocationStatus(LocationDto locationDto, Location location, List<Location> list) {
        if(location == null){
            location = locationDTOToLocation.apply(locationDto);
        }
        if (list.contains(location)){
            list.remove(location);
            log.info("remove");
        } else {
            list.add(location);
            log.info("add");
        }
    }

    @Transactional
    public boolean addWantToVisitLocation(LocationDto locationDto, UUID userId) {
        Location location = locationService.findByCountryAndCity(locationDto.getCountry(), locationDto.getCity());
        AppUser appUser = userRepository.findById(userId).orElseGet(null);

        List<Location> list = appUser.getLocationsWantedToVisit();
        log.info("User {} change status WantToVisit for location {} to", userId, locationDto.getCity());
        changeLocationStatus(locationDto, location, list);

        appUser.setLocationsWantedToVisit(list);
        userRepository.save(appUser);
        return true;
    }


    public AppUserDto getUser(UUID userId) {
        return userToUserDTO.apply(userRepository.findById(userId).orElseThrow());
    }
}
