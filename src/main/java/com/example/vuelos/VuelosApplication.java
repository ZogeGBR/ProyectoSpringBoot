package com.example.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import java.net.InetAddress;

@SpringBootApplication
public class VuelosApplication {
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
