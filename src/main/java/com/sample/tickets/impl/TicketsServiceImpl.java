package com.sample.tickets.impl;

import com.sample.tickets.TicketValidator;
import com.sample.tickets.TicketsDAO;
import com.sample.tickets.TicketsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsServiceImpl implements TicketsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketsServiceImpl.class);

    private final TicketsDAO dao;

    private final TicketValidator validator;

    @Autowired
    public TicketsServiceImpl(final TicketsDAO dao, final TicketValidator validator) {
        this.dao = dao;
        this.validator = validator;
    }

    @Override
    public boolean isTicketAvailable(final String ticketId) {

        LOGGER.debug("Validating ticket ID");
        boolean ticketAvailabilityCheck = false;
        if (validator.validate(ticketId)) {
            LOGGER.debug("Validation passed successfully!");
            ticketAvailabilityCheck = dao.isTicketAvailable(Integer.valueOf(ticketId));
        } else {
            LOGGER.debug("Ticket ID validation failed for ticket ID: {}", ticketId);
        }

        LOGGER.info("Ticket {} check result: {}", ticketId, ticketAvailabilityCheck);
        return ticketAvailabilityCheck;
    }
}
