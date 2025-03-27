package com.mit.project.service;

import com.mit.project.model.UserDetails;
import com.mit.project.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private NotificationsService notifications;

    public List<UserDetails> getAllDetails(){
        return userDetailsRepository.findAll();
    }

    public UserDetails getUserDetails(long id){
        return userDetailsRepository.findById(id).get();
    }

    public void addUserDetails(MultipartFile file, UserDetails userDetails) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        userDetails.setDocumentName(fileName);
        userDetails.setDocumentType(file.getContentType());
        userDetails.setData(file.getBytes());
        userDetailsRepository.save(userDetails);
        userDetailsRepository.flush();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        notifications.addNotification(String.valueOf(userDetails.getUserId()),"SYSTEM","Private","Welcome","New Account created sucessfully.", String.valueOf(timestamp));
    }

    public void updateUserDetails(long id,UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    public void deleteUserDetails(long id) {
        userDetailsRepository.deleteById(id);
    }

    public UserDetails login(String username,String password){
        return userDetailsRepository.findByUsernameAndPassword(username,password);
    }

    public String getName(long id){
        return userDetailsRepository.findById(id).get().getName();
    }
}
