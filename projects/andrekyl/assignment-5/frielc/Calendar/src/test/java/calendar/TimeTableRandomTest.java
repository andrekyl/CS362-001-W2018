package calendar;

import java.util.Calendar;
import java.util.Random;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 int TestTimeout = 10000;

		 System.out.println("Start testing...");
		 try{
		 for (int iteration = 0; iteration < TestTimeout; iteration++) {
			 long randomseed = System.currentTimeMillis();
			 Random random = new Random(randomseed);
//			 int day = ValuesGenerator.RandInt(random);
//			 int month = ValuesGenerator.RandInt(random);
//			 int year = ValuesGenerator.RandInt(random);
	 int day2 = ValuesGenerator.RandInt(random);
//			 int month2 = ValuesGenerator.RandInt(random);
//			 int year2 = ValuesGenerator.RandInt(random);
			 int day = 1;
			 int month = 01;
			 int year = 2000;
			 //int day2 = 30;
			 int month2 = 01;
			 int year2 = 2000;
			 //int[] pv = {0, 1, 2};
			 int[] recur = new int[]{3};
			 int[] recur2 = new int[]{3};
			 int[] recur3 = new int[]{3};


			 TimeTable t = new TimeTable();

			 int startHour = ValuesGenerator.RandInt(random);
			 int startDay = ValuesGenerator.RandInt(random);
			 int startDay2 = ValuesGenerator.RandInt(random);
			 int startDay3 = ValuesGenerator.RandInt(random);
			 int startDay4 = ValuesGenerator.RandInt(random);
			 Appt appt = new Appt(startHour, 01, startDay, 01, 2000, "thing", "description");
			 Appt appt2 = new Appt(startHour, 01, startDay2, 01, 2000, "thing", "description");
			 Appt appt3 = new Appt(startHour, 01, startDay3, 01, 2000, "thing", "description");
			 Appt appt4 = new Appt(startHour, 01, startDay4, 01, 2000, "thing", "description");


			 appt.setRecurrence(recur, 2, 2, appt.RECUR_NUMBER_FOREVER);
			 appt2.setRecurrence(recur2, 3, 1, appt2.RECUR_NUMBER_FOREVER);
			 appt3.setRecurrence(recur3, 4, 1, 0);

			 LinkedList<Appt> listAppts = new LinkedList<Appt>();
			 LinkedList<Appt> listAppts2 = null;

			 GregorianCalendar cDay = new GregorianCalendar(year, month, day);
			 GregorianCalendar cDay2 = new GregorianCalendar(year2, month2, day2);

			 listAppts.add(appt);
			 listAppts.add(appt2);
			 listAppts.add(appt3);

			try{
			 t.getApptRange(listAppts, cDay, cDay2);

		 	}catch(DateOutOfRangeException e){
				continue;
			 }

			 //t.permute(listAppts, pv);

			 t.deleteAppt(listAppts, appt);
			 t.deleteAppt(listAppts, null);
			 t.deleteAppt(listAppts2, appt);
			 t.deleteAppt(listAppts, appt4);
		 }


		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");

	 }


	
}
