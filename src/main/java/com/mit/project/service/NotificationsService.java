package com.mit.project.service;

import com.mit.project.model.Notification;
import com.mit.project.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    public List<Notification> getAllNotifications(){
        List<Notification> data=notificationsRepository.findAll();
        Collections.reverse(data);
        return data;
    }

    public Notification getNotification(long id){
        return notificationsRepository.findById(id).get();
    }

    public void addNotifications(Notification notification){
        notificationsRepository.save(notification);
    }

    public void addNotification(String toId, String fromId, String category, String heading, String details,String timestamp){
        Notification notification =new Notification();
        notification.setToId(toId);
        notification.setFromId(fromId);
        notification.setCategory(category);
        notification.setHeading(heading);
        notification.setDetails(details);
        notification.setTimestamp(timestamp);
        notificationsRepository.save(notification);
    }

    public void addNotificationsWithFile(MultipartFile file, Notification notification) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        notification.setDocumentName(fileName);
        notification.setDocumentType(file.getContentType());
        notification.setData(file.getBytes());
        notificationsRepository.save(notification);
    }

    public void updateNotifications(long id, Notification notification) {
        notificationsRepository.save(notification);
    }

    public void deleteNotifications(long id) {
        notificationsRepository.deleteById(id);
    }

    public List<Notification> getNotificationsByToId(String ownerId){
        return notificationsRepository.findByToIdOrderByIdDesc(ownerId);
    }

    public List<Notification> getAllGeneralNotifications(){
        return notificationsRepository.findGeneral();
    }
}
