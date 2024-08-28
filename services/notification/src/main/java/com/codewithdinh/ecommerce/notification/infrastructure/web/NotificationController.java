package com.codewithdinh.ecommerce.notification.infrastructure.web;

import com.codewithdinh.ecommerce.notification.application.dto.NotificationResponse;
import com.codewithdinh.ecommerce.notification.application.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/notifications")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getAllNotifications() {
        return service.getAllNotifications();
    }
}
