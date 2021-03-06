package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        //CALL REST API
        //CALL DB

        Health.Builder builder = new Health.Builder(Status.DOWN);
        return builder.withDetail("test","test").build();
    }
}
