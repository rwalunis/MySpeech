package com.promineotech.speech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.promineotech.speech"})

public class SpeechSpringApp {

  public static void main(String[] args) {
    SpringApplication.run(SpeechSpringApp.class, args);

  }

}
