package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	 int day = 10;
	 	 int month = 3;
	 	 int year = 2001;
		 int day2 = 25;
		 int month2 = 3;
		 int year2 = 2001;
		 int[] pv = {0,1,2};
		 int[] recur = new int[]{};
		 int[] recur2 = new int[]{3};
		 int[] recur3 = new int[]{3};


		 TimeTable t = new TimeTable();
		 Appt appt = new Appt(01,01,01,01,2000, "thing", "description");
		 Appt appt2 = new Appt(02,01,02,01,2000, "thing2", "description");
		 Appt appt3 = new Appt(02,01,03,01,2000, "thing2", "description");
		 Appt appt4 = new Appt(-1,01,03,01,2000, "thing2", "description");


		 appt.setRecurrence(recur,1,1, appt.RECUR_NUMBER_FOREVER);
		 appt2.setRecurrence(recur2,2,1, appt2.RECUR_NUMBER_FOREVER);
		 appt3.setRecurrence(recur3,3,1, 0);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList<Appt> listAppts2 = null;

		 GregorianCalendar cDay = new GregorianCalendar(year, month, day);
		 GregorianCalendar cDay2 = new GregorianCalendar(year2, month2, day2);

		 listAppts.add(appt);
		 listAppts.add(appt2);
		 listAppts.add(appt3);




		 t.getApptRange(listAppts, cDay, cDay2);

		 t.permute(listAppts, pv);

		 t.deleteAppt(listAppts, appt);
		 t.deleteAppt(listAppts, null);
		 t.deleteAppt(listAppts2, appt);
		 t.deleteAppt(listAppts, appt4);



	 }
	 @Test
	  public void test02()  throws Throwable  {

		 int day = 10;
		 int month = 3;
		 int year = 2001;
		 int day2 = 25;
		 int month2 = 3;
		 int year2 = 2001;
		 int[] pv = {0,1,2};
		 int[] recur = new int[]{};
		 int[] recur2 = new int[]{3};
		 int[] recur3 = new int[]{3};

		 TimeTable t = new TimeTable();
		 Appt appt = new Appt(01,01,01,01,2000, "thing", "description");

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList<Appt> listAppts2 = new LinkedList<Appt>();

		 listAppts.add(appt);

		 assertEquals(null, t.deleteAppt(listAppts, appt));
		 assertEquals(null,t.deleteAppt(listAppts2,appt));
//		 int day = 1;
//		 int month = 3;
//		 int year = 2001;
//		 int day2 = 25;
//		 int month2 = 3;
//		 int year2 = 2001;
//		 int[] pv = {0,1,2};
//		 int[] recur = new int[]{};
//		 int[] recur2 = new int[]{3};
//		 int[] recur3 = new int[]{3};
//
//
//		 TimeTable t = new TimeTable();
//		 Appt appt = new Appt(01,01,01,01,2000, "thing", "description");
//		 Appt appt2 = new Appt(02,01,02,01,2000, "thing2", "description");
//		 Appt appt3 = new Appt(02,01,03,01,2000, "thing2", "description");
//		 Appt appt4 = new Appt(-1,01,03,01,2000, "thing2", "description");
//
//
//		 appt.setRecurrence(recur,1,1, appt.RECUR_NUMBER_FOREVER);
//		 appt2.setRecurrence(recur2,2,1, appt2.RECUR_NUMBER_FOREVER);
//		 appt3.setRecurrence(recur3,3,1, 0);
//
//		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
//		 LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
//		 LinkedList<Appt> listAppts3 = new LinkedList<Appt>();
//		 LinkedList<Appt> listAppts4 = new LinkedList<Appt>();
//
//		 GregorianCalendar cDay = new GregorianCalendar(year, month, day);
//		 GregorianCalendar cDay2 = new GregorianCalendar(year2, month2, day2);
//
//		 listAppts.add(appt);
//		 listAppts.add(appt2);
//		 //listAppts.add(appt3);
//		 listAppts2.add(appt);
//		 listAppts2.add(appt2);
//
//
//
//		 t.getApptRange(listAppts, cDay, cDay2);
//
//		 assertEquals(t.getApptRange(listAppts3, cDay, cDay2), t.getApptRange(listAppts4, cDay, cDay2));

	 }
//add more unit tests as you needed
}
