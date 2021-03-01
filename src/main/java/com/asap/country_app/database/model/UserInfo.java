package com.asap.country_app.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String nickName;
    private String name;
    private String lastName;
    private String dateOfBirth;
    private String codeOfCountry;
    private String currency;

    public UserInfo(String nickName, String name, String lastName, String dateOfBirth, String codeOfCountry, String currency) {
        this.nickName = nickName;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.codeOfCountry = codeOfCountry;
        this.currency = currency;
    }
}
