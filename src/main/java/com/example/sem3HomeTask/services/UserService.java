package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    @Autowired
    private NotificationService notiificationService;

    /**
     * Внедрение зависимости через конструктор
     * @param notiificationService
     */
    public UserService(NotificationService notiificationService) {
        this.notiificationService = notiificationService;
    }

    public User createUser(String name, int age, String email){
        User user= new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notiificationService.notifyUser(user);

        return user;
    }
}
