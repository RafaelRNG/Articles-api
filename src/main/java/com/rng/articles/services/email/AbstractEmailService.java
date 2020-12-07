package com.rng.articles.services.email;

import com.rng.articles.entities.Article;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendConfirmationEmail(Article article) {
        sendEmail(prepareSimpleEmailMessageFromArticle(article));
    }

    protected SimpleMailMessage prepareSimpleEmailMessageFromArticle(Article article){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(article.getUser().getEmail());
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setSubject("confirming the creation of your article");
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
        simpleMailMessage.setText(article.toString());
        return simpleMailMessage;
    }
}