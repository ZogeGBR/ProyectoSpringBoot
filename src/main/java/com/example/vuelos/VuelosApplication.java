package com.example.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import java.net.InetAddress;

/**
 * Clase principal de la aplicación AeroSystem — Gestión de Vuelos.
 *
 * <p>Inicia el servidor embebido Spring Boot (Tomcat) en el puerto 8080
 * y muestra en consola las URLs de acceso local, en red y la consola H2.</p>
 *
 * <p>Al arrancar, la base de datos H2 en memoria se crea automáticamente
 * y se pobla con los datos de prueba definidos en {@code data.sql}.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 */
@SpringBootApplication
public class VuelosApplication {

    /**
     * Punto de entrada de la aplicación.
     *
     * <p>Inicia el contexto de Spring Boot y luego imprime en consola
     * la URL local, la IP de red y el acceso a la consola H2,
     * facilitando el acceso desde otras computadoras en la misma red.</p>
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     * @throws Exception si no puede obtener la dirección IP del host
     */
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(VuelosApplication.class, args);
        Environment env = ctx.getEnvironment();
        String port = env.getProperty("server.port", "8080");
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println("\n========================================");
        System.out.println("  AEROSYSTEM - Gestión de Vuelos");
        System.out.println("========================================");
        System.out.println("  Local:    http://localhost:" + port);
        System.out.println("  Red:      http://" + ip + ":" + port);
        System.out.println("  H2:       http://localhost:" + port + "/h2-console");
        System.out.println("  API:      http://localhost:" + port + "/api/vuelos");
        System.out.println("========================================\n");
    }
}
