package com.asap.country_app.controller;

import com.asap.country_app.dto.AppUserDto;
import com.asap.country_app.dto.LocationDto;
import com.asap.country_app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    @GetMapping
    public AppUserDto getUser(@RequestParam UUID userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //TODO Ivan ustawic status zeby byl inny gdy blad
    public AppUserDto saveUser(@RequestBody AppUserDto appUserDto) {
        appUserDto.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword()));
        return userService.saveUser(appUserDto);
    }

    //TODO change the implementation
    @PutMapping ("/like")
    @ResponseStatus(HttpStatus.OK)
    public String addLikedLocation(@RequestBody LocationDto locationDto, @RequestParam(name = "id") UUID userId) {
        if(userService.addLikedLocation(locationDto, userId)){
            return "liked";
        }else {
            return "remove like";
        }
    }

    //TODO change the implementation
    @PutMapping ("/visited")
    @ResponseStatus(HttpStatus.OK)
    public String addVisitedLocation(@RequestBody LocationDto locationDto, @RequestParam(name = "id") UUID userId) {
        if(userService.addVisitedLocation(locationDto, userId)){
            return "visited";
        }else {
            return "remove like";
        }
    }

    //TODO change the implementation
    @PutMapping ("/wantToVisit")
    @ResponseStatus(HttpStatus.OK)
    public String addWantedToVisitLocation(@RequestBody LocationDto locationDto, @RequestParam(name = "id") UUID userId) {
        if(userService.addWantToVisitLocation(locationDto, userId)){
            return "visited";
        }else {
            return "remove like";
        }
    }



//    @GetMapping("/orders")
//    public String getOrders(Model model, @AuthenticationPrincipal OrderUser user) {
//        var orders = orderFindService.findAll(user);
//        model.addAttribute("orders", orders);
//
//        return "orders";
//    }


    //TODO for future cleanup
//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    public UserInfoDto addVisitedLocation(@RequestBody UserDto userDto) {
//        return userService.addLikedLocation(userDto);
//    }
//
//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    public UserInfoDto addLocationWantedToVisit(@RequestBody UserDto userDto) {
//        return userService.addLikedLocation(userDto);
//    }


//    @CrossOrigin
//    @PutMapping("/register")
//    public String addUser(@RequestBody User user) {
//        log.info("Register user email={} password={}", user.getEmail(), user.getPassword());
//        if (userService.createUser(user)) {
//            return "Success register for " + user.getEmail();
//        } else {
//            return "Failed register for " + user.getEmail();
//        }
//    }
//
//    @GetMapping("/users")
//    public List<User> getUsers() {
//        log.info("Requested all users");
//        return userService.getUsers();
//    }
//
//    @PutMapping("/location/{email}")
//    public String addLocation(@RequestBody Location location, @PathVariable String email) {
//        if (userService.addLocation(email, location)) {
//            return "Success";
//        } else {
//            return "Failed";
//        }
//    }
//
//    @PutMapping("/info/{email}")
//    public String addInfo(@RequestBody UserInfo userInfo, @PathVariable String email) {
//        if (userService.addUserInfo(email, userInfo)) {
//            return "Success";
//        } else {
//            return "Failed";
//        }
//    }
//
//    @DeleteMapping("/delete/{email}")
//    public String deleteUser(@PathVariable String email) {
//        if (userService.removeUser(email)) {
//            return "Success";
//        } else {
//            return "Failed";
//        }
//    }
}
