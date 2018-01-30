package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());

		 Appt appt2 = new Appt(-1,0,0,0,0,"hello","there");

		 appt.setStartHour(25);
		 appt.setStartHour(-1);
		 appt.setStartMinute(60);
		 appt.setStartMinute(-1);
		 appt.setStartDay(32);
		 appt.setStartDay(0);
		 //appt.setStartMonth(12);
		 appt.setStartHour(4);
		 appt.setStartMinute(5);
		 appt.setStartDay(6);
		 appt.setStartMonth(7);
		 appt.setStartYear(2001);
		 appt.setTitle(null);
		 appt.setDescription(null);
		 appt.getRecurNumber();
		 appt.getRecurBy();
		 appt.getRecurDays();
		 appt.isRecurring();
		 appt.getRecurIncrement();
		 appt.toString();
		 appt.setStartHour(12);
		 appt.setStartHour(0);
		 appt.setRecurrence(null, 0, 0, 0);

		 appt2.toString();
		 appt.setRecurrence(null,0,0,1);

		 appt.compareTo(appt);


	 }

	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed
	
}
