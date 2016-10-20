package com.sample.tickets.impl;

import org.junit.Test;

import static org.junit.Assert.*;


public class TicketNumericIdValidatorTest {

    private TicketNumericIdValidator validator = new TicketNumericIdValidator();

    @Test
    public void validateNumericValue() throws Exception {
        final boolean validationResult = validator.validate("123");

        assertEquals(true, validationResult);
    }

    @Test
    public void validateNullValue() throws Exception {
        final boolean validationResult = validator.validate(null);

        assertEquals(false, validationResult);
    }

    @Test
    public void validateEmptyValue() throws Exception {
        final boolean validationResult = validator.validate("");

        assertEquals(false, validationResult);
    }

    @Test
    public void validateNonNumericValue() throws Exception {
        final boolean validationResult = validator.validate("dasfwe");

        assertEquals(false, validationResult);
    }

}