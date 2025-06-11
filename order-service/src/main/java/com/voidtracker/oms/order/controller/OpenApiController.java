package com.voidtracker.oms.order.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class OpenApiController {
    @GetMapping(value = "/api/openapi.yaml", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getOpenApi() throws IOException {
        return Files.readString(new ClassPathResource("openapi_order_epod.yaml").getFile().toPath());
    }
}
