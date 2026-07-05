package com.telecomtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Punto de entrada principal de la aplicación TelecomTrack.
@SpringBootApplication
public class TelecomtrackApplication {

    public static void main(String[] args) {
        // Inicia Spring Boot y detecta los componentes ubicados dentro de com.telecomtrack.
        SpringApplication.run(TelecomtrackApplication.class, args);
    }
}