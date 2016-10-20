package com.sample.coupons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupons")
public class CouponsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponsController.class);

    @GetMapping(produces = {MediaType.TEXT_PLAIN_VALUE})
    public String get() {
        LOGGER.debug("Received GET request");

        return "Service coming soon...";
    }
}
