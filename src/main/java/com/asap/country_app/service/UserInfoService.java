package com.asap.country_app.service;

import com.asap.country_app.database.repository.UserInfoRepository;
import com.asap.country_app.database.repository.UserRepository;
import com.asap.country_app.database.model.AppUser;
import com.asap.country_app.database.model.UserInfo;
import com.asap.country_app.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoDTOToUserInfo;
import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoToUserInfoDTO;

@Service
@Slf4j
public class UserInfoService {
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;

    public UserInfoService(UserRepository userRepository, UserInfoRepository userInfoRepository) {
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Transactional
    public UserInfoDto editUserInfo(UserInfoDto userInfoDto, UUID userId){
        AppUser appUser = userRepository.findById(userId).orElseThrow();
        UserInfo old = appUser.getUserInfo();
        appUser.setUserInfo(userInfoDTOToUserInfo.apply(userInfoDto));
        userInfoRepository.delete(old);
        log.info("UserInfo for " + appUser.getEmail() + " " + appUser.getId() + " is changed: " + appUser.getUserInfo());
        return userInfoToUserInfoDTO.apply(userRepository.save(appUser).getUserInfo());
    }

    @Transactional
    public UserInfoDto getUserInfo(UUID userId){
        AppUser appUser = userRepository.findById(userId).orElseThrow();
        return userInfoToUserInfoDTO.apply(appUser.getUserInfo());
    }
}
