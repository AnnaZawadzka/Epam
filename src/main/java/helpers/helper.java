package helpers;

import java.util.Random;





public class helper {
	
	 public static String generateRandomString ()
	 {
		 Random rand = new Random();
		 int n = rand.nextInt(9999) +1;
		 String name = Integer.toString(n) + "AZ";
		 return name;
		 
	 }

	 public static String generateRandomName ()
	 {

		 char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 for (int i = 0; i < 8; i++) {
		     char c = chars[random.nextInt(chars.length)];
		     sb.append(c);
		 }
		 
		 String name = sb.toString();
		 return name;

	 }
	 

}
