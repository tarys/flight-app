package com.sample.tickets.impl;

import com.sample.tickets.TicketValidator;
import com.sample.tickets.TicketsDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TicketsServiceImplTest {

    @Mock
    private TicketsDAO dao;
    @Mock
    private TicketValidator ticketValidator;
    @InjectMocks
    private TicketsServiceImpl service;

    @Test
    public void serviceLookupSuccessfulForExistingValidTicketId() throws Exception {
        when(dao.isTicketAvailable(anyInt())).thenReturn(true);
        when(ticketValidator.validate(anyString())).thenReturn(true);

        boolean ticketAvailable = service.isTicketAvailable("123");

        assertTrue(ticketAvailable);
    }

    @Test
    public void serviceLookupFailForNonExistingValidTicketId() throws Exception {
        when(dao.isTicketAvailable(anyInt())).thenReturn(false);
        when(ticketValidator.validate(anyString())).thenReturn(true);

        boolean ticketAvailable = service.isTicketAvailable("123");

        assertFalse(ticketAvailable);
    }
    @Test
    public void serviceLookupFailForInvalidTicketId() throws Exception {
        when(dao.isTicketAvailable(anyInt())).thenReturn(false);
        when(ticketValidator.validate(anyString())).thenReturn(false);

        boolean ticketAvailable = service.isTicketAvailable("123");

        assertFalse(ticketAvailable);
    }
}