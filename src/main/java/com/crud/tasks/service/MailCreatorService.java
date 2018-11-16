package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyDetailsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    private final AdminConfig adminConfig;
    private final TemplateEngine templateEngine;
    private final CompanyDetailsConfig detailsConfig;

    @Autowired
    public MailCreatorService(AdminConfig adminConfig,
                              @Qualifier("templateEngine") TemplateEngine templateEngine, CompanyDetailsConfig detailsConfig) {
        this.adminConfig = adminConfig;
        this.templateEngine = templateEngine;
        this.detailsConfig = detailsConfig;
    }

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8080/crud");
        context.setVariable("button", "Visit Website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("good_bye", "See you next time");
        context.setVariable("company_name", detailsConfig.getName() );
        context.setVariable("company_goal", detailsConfig.getGoal() );
        context.setVariable("company_email", detailsConfig.getEmail() );
        context.setVariable("company_phone", detailsConfig.getPhone() );

        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
