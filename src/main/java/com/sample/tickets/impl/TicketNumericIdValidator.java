package com.sample.tickets.impl;

import com.sample.tickets.TicketValidator;
import org.springframework.stereotype.Component;

@Component
public class TicketNumericIdValidator implements TicketValidator {
    @Override
    public boolean validate(final String ticketId) {
        return ticketId != null && ticketId.matches("\\d+");
    }
}
