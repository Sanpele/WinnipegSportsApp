package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.Ticket;
import static org.junit.Assert.assertNotNull;

public class TicketTest {
    private Ticket ticket;

    @Before
    public void setUp(){
        ticket = new Ticket("Hockey Game Ticket", 2, 1);
        assertNotNull(ticket);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Ticket Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validating League Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        ticket.viewTicketObject();
    }
}
