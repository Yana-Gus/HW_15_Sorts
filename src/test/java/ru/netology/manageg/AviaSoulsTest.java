package ru.netology.manageg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Санкт-Петерург", 10_000, 7, 10); //3
    Ticket ticket2 = new Ticket("Москва", "Севастополь", 5_000, 7, 9); //6
    Ticket ticket3 = new Ticket("Москва", "Санкт-Петерург", 15_000, 13, 15); //2
    Ticket ticket4 = new Ticket("Москва", "Санкт-Петерург", 19_000, 15, 16); //1
    Ticket ticket5 = new Ticket("Москва", "Санкт-Петерург", 13_000, 11, 15); //4
    Ticket ticket6 = new Ticket("Москва", "Санкт-Петерург", 16_000, 11, 16); //5


    @Test
    public void shouldComparePricesTickets() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = {ticket1, ticket5, ticket3, ticket6, ticket4};
        Ticket[] actual = souls.search("Москва", "Санкт-Петерург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldComparePricesOneTicket() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = {ticket2};
        Ticket[] actual = souls.search("Москва", "Севастополь");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldComparePricesZeroTicket() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = souls.search("Москва", "Самара");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightTimeTickets() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = {ticket4, ticket3, ticket1, ticket5, ticket6};
        Ticket[] actual = souls.searchAndSortBy("Москва", "Санкт-Петерург", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightTimeOneTicket() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = {ticket2};
        Ticket[] actual = souls.searchAndSortBy("Москва", "Севастополь", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightTimeZeroTickets() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = souls.searchAndSortBy("Москва", "Самара", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}

