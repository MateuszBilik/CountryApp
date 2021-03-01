package com.asap.country_app.controller;

import com.asap.country_app.dto.AppUserDto;
import com.asap.country_app.dto.LocationDto;
import com.asap.country_app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@Controller
public class NavigatePageController {

   private final UserService userService;

    public NavigatePageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String page() {
        return "main_page";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/userl")
    public String userl() {
        return "user_location";
    }

    @GetMapping ("/mylocation/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String myLocation(Model model, @AuthenticationPrincipal AppUserDto userDto, @PathVariable UUID id) {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setId(id);
        List<List<LocationDto>> lists = userService.getMyLocation(appUserDto);

        List<LocationDto> visitedLocations = lists.get(0);
        List<LocationDto> likedLocations = lists.get(1);
        List<LocationDto> locationsWantedToVisit = lists.get(2);
        model.addAttribute("visitedLocations", visitedLocations);
        model.addAttribute("likedLocations", likedLocations);
        model.addAttribute("locationsWantedToVisit", locationsWantedToVisit);
        return "user_location";
    }
}
