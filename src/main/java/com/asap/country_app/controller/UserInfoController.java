package com.asap.country_app.controller;

import com.asap.country_app.dto.UserInfoDto;
import com.asap.country_app.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/user/info")
public class UserInfoController {
    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserInfoDto editUserInfo(@RequestBody UserInfoDto userInfoDto, @RequestParam UUID userId) {
        return userInfoService.editUserInfo(userInfoDto, userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserInfoDto getUserInfo(@RequestParam UUID userId){
        return userInfoService.getUserInfo(userId);
    }
}
