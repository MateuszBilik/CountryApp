package com.asap.country_app.database.repository;

import com.asap.country_app.database.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {
}
