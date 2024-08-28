package com.codewithdinh.ecommerce.notification.infrastructure.mongo;

import com.codewithdinh.ecommerce.notification.domain.model.notification.Notification;
import com.codewithdinh.ecommerce.notification.domain.repository.NotificationRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationMongoRepository extends NotificationRepository, MongoRepository<Notification, String> {
    default Notification saveNotificationIntoDatabase(Notification notification) {
        return save(notification);
    }

    default List<Notification> getAllNotifications() {
        return findAll();
    }
}
