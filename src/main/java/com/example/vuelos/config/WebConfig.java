package com.example.vuelos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración CORS (Cross-Origin Resource Sharing) de la aplicación.
 *
 * <p>Permite que el frontend React y otras aplicaciones en la red local
 * puedan hacer peticiones HTTP a la API REST sin ser bloqueadas por
 * la política de mismo origen del navegador.</p>
 *
 * <p>Habilita todos los métodos HTTP ({@code GET}, {@code POST},
 * {@code PUT}, {@code DELETE}, {@code OPTIONS}) para todos los
 * endpoints bajo {@code /api/**}.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Registra las reglas CORS para los endpoints de la API.
     *
     * <p>Permite solicitudes desde cualquier origen ({@code *}),
     * lo que posibilita el acceso desde el frontend en cualquier puerto
     * y desde otras máquinas en la red local.</p>
     *
     * @param registry el registro donde se añaden las reglas CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
