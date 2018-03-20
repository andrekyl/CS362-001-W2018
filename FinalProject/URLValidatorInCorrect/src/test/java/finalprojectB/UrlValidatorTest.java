
package finalprojectB;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Random;


//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {

   private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
   private static final int NUM_TESTS=100;

//Even values are acceptable, odd values are not

   private static final String[] SCHEMES = {"http://", "foo://"}; // Must be lower-case
   private static final String[] AUTHORITIES = {"google.com", "1.2.3.4.5", "256.256.256.256", "255.255.255.255"};
   private static final String[] PORTS = {":80", ":90000000"};
   private static final String[] PATH = {"/test", "/..", "/gimmeA", "/../"};
   private static final String[] QUERY = {"?grade=A", "!?password=1234"};

   public UrlValidatorTest(String testName) {
      super(testName);
   }





   public void testManualTest()
   {
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      //UrlValidator urlVal = new UrlValidator();

      // testing URL Schemes
      System.out.println(urlVal.isValid("http://www.google.com")); //true
      //System.out.println(urlVal.isValid("HTTP://GOOGLE.COM") + " CAPS"); //true

      System.out.println(urlVal.isValid("3ht://www.google.com")); //false

      // testing URL Authority
      System.out.println(urlVal.isValid("http://go.com")); // True
      System.out.println(urlVal.isValid("http://1.2.3.4.5")); // False
      System.out.println(urlVal.isValid("http://1.2.3.4") + " SHORT"); // False

      System.out.println(urlVal.isValid("http://255.255.255.255")); //True
      System.out.println(urlVal.isValid("http://256.256.256.256")); //False

      // testing URL Port
      System.out.println(urlVal.isValid("http://www.google.com:65535")); //True
      System.out.println(urlVal.isValid("http://www.google.com:65536")); //False
      System.out.println(urlVal.isValid("http://www.google.com:80") + " hi"); //True

      // testing test Path
      System.out.println(urlVal.isValid("http://www.google.com/foobar")); //True
      System.out.println(urlVal.isValid("http://www.google.com/test1//file")); //False
      System.out.println(urlVal.isValid("http://www.google.com/t123")); //True
      System.out.println(urlVal.isValid("http://www.google.com/../")); //False

      //testUrlQuery
      System.out.println(urlVal.isValid("http://www.google.com?action=view")); //True

      //System.out.println(urlVal.isValid("h3t://www.google.com")); //true






//You can use this function to implement your manual testing

   }


   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing

      //Test Valid Scheme

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      assertTrue(urlVal.isValid("http://")); // valid
      assertTrue(urlVal.isValid("ftp://")); // This test should be valid but it is not
      assertTrue(urlVal.isValid("h3t://")); // This test should be valid but it is not
      assertFalse(urlVal.isValid("foo://")); // This test should not be valid
      assertFalse(urlVal.isValid("bar://")); // This test should not be valid
   }

   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      assertTrue(urlVal.isValid("http://amazon.com")); // valid
      assertTrue(urlVal.isValid("http://google.com")); // valid
      assertTrue(urlVal.isValid("h3t://google.com")); // This test should be valid but it is not
      assertFalse(urlVal.isValid("foo://1.2.3.4.5")); // This test should not be valid
      assertFalse(urlVal.isValid("http://255.255.255.255")); // valid
   }
   public void testYourThirdPartition(){
      //You can use this function to implement your Third Partition testing

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      assertTrue(urlVal.isValid("http://amazon.com:80")); // valid
      assertFalse(urlVal.isValid("http://google.com:9000000000")); //invalid out of bounds
      assertFalse(urlVal.isValid("h3t://google.com:-1")); // This test should not be valid
      assertFalse(urlVal.isValid("foo://1.2.3.4.5:1337")); // This test should not be valid
      assertTrue(urlVal.isValid("http://255.255.255.255:42069")); // valid
   }
   public void testYourFourthPartition(){
      //You can use this function to implement your Fourth Partition testing

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      assertTrue(urlVal.isValid("http://amazon.com/Calvin")); // valid
      assertFalse(urlVal.isValid("http://calvin.com/..")); //invalid path
      assertFalse(urlVal.isValid("h3t://google.com/../")); // invalid path
      assertFalse(urlVal.isValid("foo://1.2.3.4.5//itslit")); // This test should not be valid
      assertTrue(urlVal.isValid("http://255.255.255.255/123")); // valid
   }
   public void testYourFifthPartition(){
      //You can use this function to implement your Fifth Partition testing

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      assertTrue(urlVal.isValid("http://amazon.com/Calvin?action=view")); // valid
      assertTrue(urlVal.isValid("http://calvin.com/slimshady?action=edit&mode=up")); //invalid path
      assertFalse(urlVal.isValid("h3t://google.com/../a?ourgrade=A")); // invalid path
   }
   //You need to create more test cases for your Partitions if you need to

   public void testIsValid()
   {
	   //You can use this function for programming based testing

//You can use this function to implement your Second Partition testing
      long startTime = Calendar.getInstance().getTimeInMillis();
      long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

      long seed = 4;
      Random randGenerator = new Random(seed);

      System.out.println("Start testing...");

      UrlValidator validString = new UrlValidator(null,null, UrlValidator.ALLOW_2_SLASHES + UrlValidator.ALLOW_ALL_SCHEMES);

      try {
         for (int iteration = 0; elapsed < TestTimeout; iteration++) {
            boolean isFalse = false;
            int randResult = 0;

            randResult = randIndex(randGenerator, SCHEMES);
            String scheme = SCHEMES[randResult];
            if (randResult % 2 != 0) {
               isFalse = true;
            }
            randResult = randIndex(randGenerator, AUTHORITIES);
            String authority = AUTHORITIES[randResult];
            if (randResult % 2 != 0) {
               isFalse = true;
            }
            randResult = randIndex(randGenerator, PORTS);
            String port = PORTS[randResult];
            if (randResult % 2 != 0) {
               isFalse = true;
            }
            randResult = randIndex(randGenerator, PATH);
            String path = PATH[randResult];
            if (randResult % 2 != 0) {
               isFalse = true;
            }
            randResult = randIndex(randGenerator, QUERY);
            String query = QUERY[randResult];

            if (isFalse == true) {
               assertFalse(validString.isValid(scheme + authority + port + path + query));
            }
            else {
               assertTrue(validString.isValid(scheme + authority + port + path + query));
            }

            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
            if ((iteration % 10000) == 0 && iteration != 0) {
               System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
            }
         }
      } catch(NullPointerException e) {

      }
      System.out.println("Done testing...");
   }


      public static int randIndex(Random random, String[] array) {
      int randNum = random.nextInt(array.length);
      return randNum;
   }



}




