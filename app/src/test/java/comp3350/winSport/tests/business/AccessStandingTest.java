package comp3350.winSport.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.business.AccessStanding;
import comp3350.winSport.objects.Standing;
import comp3350.winSport.persistence.IStanding;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccessStandingTest {
    private IStanding iStanding;
    private AccessStanding accessStanding;

    @Before
    public void setUp(){
        iStanding = mock(IStanding.class);
        accessStanding = new AccessStanding(iStanding);
    }

    @Test
    public void testGetStandingsInOrder(){
        System.out.print("\n------------------AccessStanding Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Standings in Order");
        System.out.print("\n---------------------------------------");
        final List<Standing> dummyList;
        final List<Standing> sampleStandings = new ArrayList<>();

        when(iStanding.getStandingsInOrder()).thenReturn(sampleStandings);

        dummyList = accessStanding.getStandingInOrder();
        assertNotNull(dummyList);

        verify(iStanding).getStandingsInOrder();

        System.out.print("\nFinished test.");
    }
}
