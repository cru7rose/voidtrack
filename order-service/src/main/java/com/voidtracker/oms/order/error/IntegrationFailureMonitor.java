package com.voidtracker.oms.order.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Monitors and alerts on integration failures (e.g., external API/Kafka).
 * In production, this could send alerts to Kafka, APM, or email.
 */
@Component
public class IntegrationFailureMonitor {
    private static final Logger log = LoggerFactory.getLogger(IntegrationFailureMonitor.class);

    public void alert(String correlationId, String message, Throwable ex) {
        // Log error with correlationId
        log.error("[ALERT] Integration failure [correlationId={}]: {}", correlationId, message, ex);
        // TODO: Send to Kafka, APM, or other alerting system
    }
}
