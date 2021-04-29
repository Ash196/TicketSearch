package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    private Ticket ticket1 = new Ticket(1, 6500, "LED", "VKO", 200);
    private Ticket ticket2 = new Ticket(2, 9200, "MMK", "KJA", 100);
    private Ticket ticket3 = new Ticket(3, 12300, "LED", "KLF", 50);
    private Ticket ticket4 = new Ticket(4, 17000, "LED", "VKO", 150);
    private Ticket ticket5 = new Ticket(5, 15000, "AER", "ARH", 120);
    private Ticket ticket6 = new Ticket(6, 20000, "LED", "VKO", 60);
    private Ticket ticket7 = new Ticket(7, 13000, "AER", "ARH", 110);
    private Ticket ticket8 = new Ticket(8, 10900, "MMK", "KJA", 130);
    private Ticket ticket9 = new Ticket(9, 10700, "LED", "VKO", 140);
    private Ticket ticket10 = new Ticket(10, 12000, "LED", "VKO", 70);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket9);
        manager.add(ticket8);
        manager.add(ticket10);
        manager.add(ticket3);
        manager.add(ticket7);
        manager.add(ticket2);
        manager.add(ticket5);
        manager.add(ticket4);
        manager.add(ticket6);

    }

    @Test
    public void shouldTicketsSearchMoreOne() {
        Ticket[] expected = new Ticket[]{ticket1, ticket9, ticket10, ticket4, ticket6,};
        Ticket[] actual = manager.finAll("LED", "VKO");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketsSearchNoSearch() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.finAll("MMK", "ARH");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketSearchOne() {
        Ticket[] expected = new Ticket[]{ticket3};
        Ticket[] actual = manager.finAll("LED", "KLF");
        assertArrayEquals(expected, actual);
    }

}
