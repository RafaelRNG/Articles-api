package com.rng.articles.services.email;

import com.rng.articles.entities.Article;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendConfirmationEmail(Article article);

    void sendEmail(SimpleMailMessage simpleMailMessage);
}