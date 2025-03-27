package com.mit.project.controllers;


import com.mit.project.model.Notification;
import com.mit.project.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @GetMapping("/Notifications")
    public List<Notification> getAllNotifications(){
        return notificationsService.getAllNotifications();
    }

    @GetMapping("/Notifications/{id}")
    public Notification getNotification(@PathVariable long id){
        return notificationsService.getNotification(id);
    }

    @PostMapping("/Notifications")
    public ResponseEntity<?> addNotifications(@RequestParam("toId") String toId, @RequestParam("fromId") String fromId, @RequestParam("category") String category, @RequestParam("heading") String heading, @RequestParam("details") String details, @RequestParam("timestamp") String timestamp) {
            Notification notification =new Notification();
            notification.setToId(toId);
            notification.setFromId(fromId);
            notification.setCategory(category);
            notification.setHeading(heading);
            notification.setDetails(details);
            notification.setTimestamp(timestamp);
            notificationsService.addNotifications(notification);
            return new ResponseEntity<>("Notifications Added Successfully", HttpStatus.OK);
    }

    @PostMapping("/NotificationsFile")
    public ResponseEntity<?> addNotificationsWithFile(@RequestParam("file") MultipartFile file, @RequestParam("toId") String toId, @RequestParam("fromId") String fromId, @RequestParam("category") String category, @RequestParam("heading") String heading, @RequestParam("details") String details, @RequestParam("timestamp") String timestamp) {
        try {
            Notification notification =new Notification();
            notification.setToId(toId);
            notification.setFromId(fromId);
            notification.setCategory(category);
            notification.setHeading(heading);
            notification.setDetails(details);
            notification.setTimestamp(timestamp);
            notificationsService.addNotificationsWithFile(file, notification);
            return new ResponseEntity<>("Notifications Added Successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Notifications Failed!!", HttpStatus.OK);
        }
    }

    @PutMapping("/Notifications/{id}")
    public ResponseEntity<?> updateNotifications(@RequestBody Notification notification, @PathVariable long id) {
        notificationsService.updateNotifications(id, notification);
        return new ResponseEntity<>("Notifications Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/Notifications/{id}")
    public ResponseEntity<?> deleteNotifications(@PathVariable long id){
        notificationsService.deleteNotifications(id);
        return new ResponseEntity<>("Notifications Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/Notifications/file/{id}")
    public ResponseEntity<byte[]> getFileByLandId(@PathVariable long id) {
        Notification notification = notificationsService.getNotification(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(notification.getDocumentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + notification.getDocumentName() + "\"")
                .body(notification.getData());
    }

    @GetMapping("/NotificationsForUser")
    public List<Notification> getByToId(@RequestParam("toId") String toId){
        return notificationsService.getNotificationsByToId(toId);
    }
}
