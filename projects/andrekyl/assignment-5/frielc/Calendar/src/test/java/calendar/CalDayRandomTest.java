package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 int TestTimeout = 1000;

		 System.out.println("Start testing...");
		 try{
			 for (int iteration = 0; iteration < TestTimeout; iteration++){
				 long randomseed =System.currentTimeMillis();
				 Random random = new Random(randomseed);
				 int day = 23;
				 int month = 5;
				 int year = 2000;
				 GregorianCalendar cDay = new GregorianCalendar(year, month, day);
				 CalDay c = new CalDay(cDay);

				 int startHour = ValuesGenerator.RandInt(random);
				 //System.out.println("startHour:" + startHour);
				 Appt appt = new Appt(startHour,01,24,5,2000, "title", "description");
				 Appt appt2 = new Appt(startHour,02,24,5,2000, "title 2", "description 2");
				 Appt appt3 = new Appt(0,02,24,5,2000, "title 2", "description 2");
				 c.addAppt(appt);
				 c.addAppt(appt2);
				 c.addAppt(appt3);
			 }

		 	}catch(NullPointerException e){

			}

		 System.out.println("Done testing...");





	 }


	
}
