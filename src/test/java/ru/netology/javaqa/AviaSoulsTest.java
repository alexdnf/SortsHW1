package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Иваново", 100, 15, 18);
    Ticket ticket2 = new Ticket("Санкт-Петербург", "Нижний Новгород", 120, 15, 17);
    Ticket ticket3 = new Ticket("Москва", "Иваново", 1000, 17, 23);
    Ticket ticket4 = new Ticket("Новосибирск", "Якутск", 400, 9, 16);
    Ticket ticket5 = new Ticket("Москва", "Иваново", 800, 10, 11);

    @Test
    public void compareTest() {

        Ticket[] tickets = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5, ticket3};
        Assertions.assertArrayEquals(expected, tickets);

    }

    @Test
    public void searchTest() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket1, ticket5, ticket3};
        Ticket[] actual = souls.search("Москва", "Иваново");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparatorTest() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket5, ticket2, ticket1, ticket3, ticket4};
        Assertions.assertArrayEquals(expected, tickets);

    }

    @Test
    public void searchAndSortByTest() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket5, ticket1, ticket3};
        Ticket[] actual = souls.searchAndSortBy("Москва", "Иваново", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
