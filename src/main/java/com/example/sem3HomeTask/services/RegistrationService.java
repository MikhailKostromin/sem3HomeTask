package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

/**
 * Сервис регистрации новых пользователей.
 */

@Service
public class RegistrationService {
    /**
     * Поле сервиса работы с хранилищем пользователей.
     */

    private DataProcessingService dataProcessingService;

    /**
     * Поле сервиса создания пользователей.
     */

    private UserService userService;

    /**
     * Поле сервиса консольных уведомлений.
     */

    private NotificationService notiificationService;

    /**
     * Конструктор класса.
     * @param dataProcessingService сервис работы с хранилищем пользователей.
     * @param userService сервис создания пользователей.
     * @param notiificationService сервис консольных уведомлений.
     */
    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notiificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notiificationService = notiificationService;
    }


    /**
     * Получение сервиса работы с хранилищем пользователей.
     * @return
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Сохранение пользователя в БД.
     * @param name имя пользователя.
     * @param age возраст пользователя.
     * @param email email пользователя.
     */
    public void processRegistration(String name, int age, String email){
        User createUser = userService.createUser(name,age,email);
        dataProcessingService.addUserToList(createUser);
        notiificationService.sendNotification("Пользователь сохранен в БД");
    }
}
