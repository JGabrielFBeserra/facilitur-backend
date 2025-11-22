package com.facilitur.api.controller;

import com.facilitur.api.service.NewsLetterSemanalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class EmailTestController {
        @Autowired
        private NewsLetterSemanalService newsletterSemanalService;

        @GetMapping("/newsletter")
        public String testarEnvio() {
            newsletterSemanalService.enviarNewsletterSemanal();
            return "Newsletter enviada manualmente!";

    }
}
