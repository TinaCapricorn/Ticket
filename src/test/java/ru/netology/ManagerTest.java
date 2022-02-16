package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Ticket[] tickets = {
            new Ticket(1, 100500, "ABA", "BZK", 150),
            new Ticket(2, 400, "NOZ", "VVO", 52),
            new Ticket(3, 10600, "KMW", "KYZ", 235),
            new Ticket(4, 3501, "MQF", "NYM", 628),
            new Ticket(5, 15901, "GOJ", "ABA", 43),
            new Ticket(6, 12589, "KGD", "GOJ", 648),
            new Ticket(7, 110, "ODS", "PEE", 245),
            new Ticket(8, 666, "LED", "SLY", 344),
            new Ticket(9, 985, "BZK", "MQF", 578),
            new Ticket(10, 10, "NOZ", "VVO", 247),
    };

    Repository repository = new Repository(tickets);
    Manager manager = new Manager(repository);

    @Test
    void searchTickets() {
        Ticket[] expected = {
                new Ticket(10, 10, "NOZ", "VVO", 247),
                new Ticket(2, 400, "NOZ", "VVO", 52),
        };
        Ticket[] actual = manager.searchTickets("NOZ", "VVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNoDepartureTickets() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchTickets("EEE", "MQF");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNoArrivalTickets() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchTickets("GOJ", "EEE");
        assertArrayEquals(expected, actual);
    }

    @Test
    void saveTicket() {
        manager.addTicket(new Ticket(11, 448, "PEE", "LED", 48));
        Ticket[] expected = {
                new Ticket(1, 100500, "ABA", "BZK", 150),
                new Ticket(2, 400, "NOZ", "VVO", 52),
                new Ticket(3, 10600, "KMW", "KYZ", 235),
                new Ticket(4, 3501, "MQF", "NYM", 628),
                new Ticket(5, 15901, "GOJ", "ABA", 43),
                new Ticket(6, 12589, "KGD", "GOJ", 648),
                new Ticket(7, 110, "ODS", "PEE", 245),
                new Ticket(8, 666, "LED", "SLY", 344),
                new Ticket(9, 985, "BZK", "MQF", 578),
                new Ticket(10, 10, "NOZ", "VVO", 247),
                new Ticket(11, 448, "PEE", "LED", 48)
        };
        Ticket[] actual = manager.getTickets();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeId() {
        int expected = manager.getTickets().length - 1;
        manager.deleteTicket(8);
        int actual = manager.getTickets().length;
        assertEquals(expected, actual);
    }

}