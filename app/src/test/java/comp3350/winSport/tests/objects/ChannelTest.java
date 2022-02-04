package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.Channel;

import static org.junit.Assert.assertNotNull;

public class ChannelTest {
    private Channel channel;

    @Before
    public void setUp(){
        channel = new Channel(20, 25);
        assertNotNull(channel);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Channel Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validating Channel Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        channel.validateObject();
    }
}
