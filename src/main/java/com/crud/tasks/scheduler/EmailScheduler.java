package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: ones a day email";
    private static final String TASK = " task";
    private static final String TASKS = " tasks";


    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    @Autowired
    public EmailScheduler(SimpleEmailService simpleEmailService,
                          TaskRepository taskRepository,
                          AdminConfig adminConfig) {
        this.simpleEmailService = simpleEmailService;
        this.taskRepository = taskRepository;
        this.adminConfig = adminConfig;
    }

    @Scheduled(cron = "0 0 10 ? * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String task = "Currently in your database you have got " + size + " task";
        String tasks = "Currently in your database you have got " + size + " tasks";

        if (size == 1) {
            simpleEmailService.send(new Mail(
                    adminConfig.getAdminMail(),
                    null,
                    SUBJECT,
                    task
            ));
        } else {
            simpleEmailService.send(new Mail(
                    adminConfig.getAdminMail(),
                    null,
                    SUBJECT,
                    tasks
            ));
        }
    }

}
