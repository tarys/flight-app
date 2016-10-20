package com.sample.baggages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baggage")
public class BaggageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaggageController.class);

    @GetMapping(produces = {MediaType.TEXT_PLAIN_VALUE})
    public String get() {
        LOGGER.debug("Received GET request");

        return "Service coming soon...";
    }
}
