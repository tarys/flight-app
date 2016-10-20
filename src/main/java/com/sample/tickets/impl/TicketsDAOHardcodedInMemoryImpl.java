package com.sample.tickets.impl;

import com.sample.tickets.TicketsDAO;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Repository
public class TicketsDAOHardcodedInMemoryImpl implements TicketsDAO {
    private final Set<Integer> ticketIds;

    public TicketsDAOHardcodedInMemoryImpl() {
        ticketIds = new HashSet<>();
        ticketIds.add(1);
        ticketIds.add(2);
        ticketIds.add(3);
    }

    @Override
    public boolean isTicketAvailable(final int ticketId) {
        return ticketIds.contains(ticketId);
    }
}
