package com.asap.country_app.service;

import com.asap.country_app.database.model.Comment;
import com.asap.country_app.database.repository.CommentRepository;
import com.asap.country_app.dto.CommentDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Transactional
    public CommentDto addComment(CommentDto commentDto){
        Comment comment = new Comment(commentDto.getCreated(),commentDto.getText(),commentDto.getAppUser(),commentDto.getLocation());
        Comment savedComment = commentRepository.save(comment);
        return new CommentDto(savedComment.getId(),savedComment.getCreated(),savedComment.getText(),
                savedComment.getAppUser(),savedComment.getLocation());
    }

    @Transactional
    public List<CommentDto> findCommentsAboutLocation(UUID locationId){

        return commentRepository.findCommentsByLocation_Id(locationId).stream().map(comment ->
                new CommentDto(comment.getId(),comment.getCreated(),
                        comment.getText(),comment.getAppUser(),comment.getLocation())).collect(Collectors.toList());
    }

//    @Transactional
//    public UserDto saveUser(UserDto userDto) {
////TODO sprawdzenie wielkosci liter w mailu?
//        if (userRepository.findByEmail(userDto.getEmail()).isEmpty()) {
//            User user = userDTOToUserCreate.apply(userDto);
//            user.setUserInfo(new UserInfo());
//            log.info("User created: " + userDto.getEmail());
//            return userToUserDTOCreate.apply(userRepository.save(user));
//        } else {
//            log.info("This mail existed: " + userDto.getEmail());
//            return null;
//        }
//    }

//    private final LocationRepository locationRepository;
//
//    public LocationService(LocationRepository locationRepository) {
//        this.locationRepository = locationRepository;
//    }
//
//    @Transactional
//    public LocationDto saveLocation(LocationDto locationDto) {
//
//        Location location = locationRepository.findLocationByCountryAndCity(locationDto.getCountry(), locationDto.getCity());
//        if(location == null){
//            location = locationDTOToLocation.apply(locationDto);
//            log.info("Save Location");
//            return locationToLocationDTO.apply(locationRepository.save(location));
//        }else {
//            log.warn("Location existed early");
//            return locationDto;
//        }
//    }
//
//    @Transactional
//    public Location findByCountryAndCity(String country, String city){
//        return locationRepository.findLocationByCountryAndCity(country, city);
//    }

}
