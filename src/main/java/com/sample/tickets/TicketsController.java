package com.sample.tickets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketsController.class);

    private final TicketsService service;

    @Autowired
    public TicketsController(final TicketsService service) {
        this.service = service;
    }

    @GetMapping(value = "/{ticketId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public boolean get(@PathVariable("ticketId") final String ticketId) {
        LOGGER.debug("Received GET request with parameter '{}'", ticketId);

        return service.isTicketAvailable(ticketId);
    }


}
