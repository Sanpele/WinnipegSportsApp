package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.Period;
import comp3350.winSport.objects.Player;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.fail;

public class PeriodTest {

    private Period period;
    private Player player;

    @Before
    public void setUp(){
        period = new Period(1,5);
        assertNotNull(period);
        player = new Player("Sherlock Holmes",221,"center","Baker Street",1);
        assertNotNull(player);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Period Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validate Period Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        period.viewPeriodObject();
    }

    @Test
    public void testAddGoalSuccessful(){
       try{
           System.out.print("\n---------------------------------------");
           System.out.print("\nTest 2: Successfully Adding a Goal with Correct Goal Time");
           System.out.print("\n---------------------------------------");
           System.out.print("\nUsing addGoa() with correct time string format 00:00.");
           period.addGoal(player,"13:21");
           assertNotNull(period.getTimeGoals());
           System.out.print("Input successful.");
       }
       catch (Exception InvalidTimeException){
           System.out.print("\nMethod threw an exception\n");
       }
    }

    @Test
    public void testAddGoalFail(){

        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 3: Failing to Add a Goal with Incorrect Goal Time");
        System.out.print("\n---------------------------------------");
        System.out.print("\nUsing addGoa() with incorrect strings");

        int counter = 0;
        String input1 = "";
        String input2 = "1321";
        String input3 = ":";
        String input4 = "::";
        String input5 = "1321:";
        String input6 = ":1321";
        String input7 = " ";
        String input8 = " 13:21 ";
        String input9 = "13 : 21";


        try{
            System.out.print("\nInput: " + input1 + " (empty)");
            period.addGoal(player,input1);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input2);
            period.addGoal(player,input2);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input3);
            period.addGoal(player,input3);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input4);
            period.addGoal(player,input4);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input5);
            period.addGoal(player,input5);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input6);
            period.addGoal(player,input6);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }


        try{
            System.out.print("\nInput: " + input7 + " (whitespace)");
            period.addGoal(player,input7);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input8);
            period.addGoal(player,input8);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input9);
            period.addGoal(player,input9);
            fail("\nMethod did not throw an exception.");
        }
        catch (Exception InvalidTimeException){
            System.out.print("\nMethod threw an exception\n");
            counter++;
        }

        System.out.print("\n---------------------------------------");
        System.out.print("\nExpected: 9");
        System.out.print("\nExceptions thrown: " + counter);
        System.out.print("\n---------------------------------------");
    }

}
