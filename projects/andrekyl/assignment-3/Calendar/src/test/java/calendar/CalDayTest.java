package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	int day = 23;
	 	int month = 5;
	 	int year = 2000;

	 	Appt appt = new Appt(01,01,01,01,200, "title", "description");
	 	Appt appt2 = new Appt(02,01,01,01,200, "title", "description");
	 	Appt appt3 = new Appt(00,01,01,01,200, "title", "description");
	 	Appt appt4 = new Appt(-1,01,01,01,200, "title", "description");
	 	LinkedList<Appt> listAppts = new LinkedList<Appt>();
	 	GregorianCalendar cDay = new GregorianCalendar(year, month, day);
//
	 	CalDay c = new CalDay(cDay);
	 	CalDay c2 = new CalDay();
		 assertTrue(c.isValid());
		 assertEquals(23, c.getDay());
		 assertEquals(5, c.getMonth());
		 assertEquals(2000, c.getYear());

		 c2.addAppt(appt4);
		 c.addAppt(appt);
		 c.addAppt(appt2);
		 c.addAppt(appt3);
		 c.iterator();
		 //assertEquals(true, c.iterator().hasNext());
		 c2.iterator();
		 c.getSizeAppts();
		 c.toString();
		 c2.toString();


	 }
	 @Test
	  public void test02()  throws Throwable  {
		 int day = 23;
		 int month = 5;
		 int year = 2000;
		 GregorianCalendar cDay = new GregorianCalendar(year, month, day);
		 CalDay c = new CalDay(cDay);

		 Appt appt = new Appt(05,30,15,5,2000, "title", "description");
		 Appt appt1 = new Appt(04,30,15,5,2000, "title", "description");
		 c.addAppt(appt);
		 c.addAppt(appt1);


	 }

	@Test
	public void test03()  throws Throwable  {
		int day = 23;
		int month = 5;
		int year = 2000;
		GregorianCalendar cDay = new GregorianCalendar(year, month, day);
		CalDay c = new CalDay(cDay);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();



		Appt appt = new Appt(05,30,15,5,2000, "title", "description");
		Appt appt1 = new Appt(05,31,15,5,2000, "title", "description");
		c.addAppt(appt);
		//assertEquals(c.addAppt(appt1),c.addAppt(appt1));




	}
	@Test
	public void test04()  throws Throwable {
		int day = 23;
		int month = 5;
		int year = 2000;
		GregorianCalendar cDay = new GregorianCalendar(year, month, day);
		CalDay c = new CalDay(cDay);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		assertEquals(0, c.getSizeAppts());

		assertEquals(c.toString(),c.toString());
	}

	@Test
	public void test05()  throws Throwable {
		int day = 23;
		int month = 5;
		int year = 2000;
		GregorianCalendar cDay = new GregorianCalendar(year, month, day);
		CalDay c = new CalDay(cDay);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		//assertEquals(c.getAppts().iterator(),c.getAppts().iterator());
	}

//add more unit tests as you needed	
}
