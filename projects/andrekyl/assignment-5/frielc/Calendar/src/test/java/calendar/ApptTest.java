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
	 	 int a = appt.getRecurNumber();
	 	 assertEquals(a,0);
		 
	 }

	@Test
	public void test03()  throws Throwable  {
		int startHour= -1;
		int startMinute= 0;
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
		//Testing the start hour mutation
		assertEquals(false, appt.getValid());
		appt.setStartHour(0);
		assertEquals(true, appt.getValid());
		appt.setStartHour(24);
		assertEquals(false, appt.getValid());
		appt.setStartHour(23);
		assertEquals(true, appt.getValid());

		appt.setStartMinute(-1);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(0);
		assertEquals(true, appt.getValid());
		appt.setStartMinute(60);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(59);
		assertEquals(true, appt.getValid());

		appt.setStartDay(0);
		assertEquals(false, appt.getValid());
		appt.setStartDay(1);
		assertEquals(true, appt.getValid());
		appt.setStartDay(31);
		assertEquals(false, appt.getValid());
		appt.setStartDay(28);
		assertEquals(true, appt.getValid());

//		appt.setStartMonth(12);
//		assertEquals(false, appt.getValid());
		appt.setStartMonth(11);
		assertEquals(true, appt.getValid());




	}

	@Test
	public void test04()  throws Throwable  {

	 	//Test the mutation for isRecurring
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

		appt.setRecurrence(null,0,0,0);
		assertEquals(false, appt.isRecurring());
		appt.setRecurrence(null,1,0,0);
		assertEquals(false, appt.isRecurring());

		//check getRecurBy()
		appt.setRecurrence(null,0,0,0);
		assertEquals(0, appt.getRecurBy());
		appt.setRecurrence(null,1,0,0);
		assertEquals(1, appt.getRecurBy());

		//check getRecurIncrement()
		appt.setRecurrence(null,0,0,0);
		assertEquals(0, appt.getRecurIncrement());
		appt.setRecurrence(null,1,1,0);
		assertEquals(1, appt.getRecurIncrement());

		//setRecurDays
		appt.setRecurrence(null,0,0,0);
		assertEquals(0, appt.getRecurIncrement());
		int[] a = {1,2,3};
		appt.setRecurrence(a,1,1,0);
//		assertEquals(a, appt.getRecurIncrement());

		appt.setRecurrence(null,0,0,-1);
		assertEquals(-1, appt.getRecurNumber());
		appt.setRecurrence(null,1,1,0);
		assertEquals(0, appt.getRecurNumber());

	}

	@Test
	public void test05()  throws Throwable {

		//Test the mutation for isRecurring
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);


		appt.setStartHour(10);
		assertEquals("\t" + "1/15/2018 at 10:30am ,Birthday Party, This is my birthday party." + "\n", appt.toString());
		appt.setStartHour(11);
		assertEquals("\t" + "1/15/2018 at -1:30am ,Birthday Party, This is my birthday party." + "\n", appt.toString());
		appt.setStartHour(0);
		assertEquals("\t" + "1/15/2018 at 12:30am ,Birthday Party, This is my birthday party." + "\n", appt.toString());
	}

	@Test
	public void test06()  throws Throwable {

		//Test the mutation for isRecurring
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);


		Appt appt2 = new Appt(-1,1,1,1,1,"hello","there");


		assertEquals(2082, appt.compareTo(appt2));

	}


//add more unit tests as you needed
	
}
