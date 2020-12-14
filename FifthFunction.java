import java.util.ArrayList;
import java.util.Collections;

public class FifthFunction {
	public static ArrayList<String> meating(String str) {
		String strUp=str.toUpperCase();
		ArrayList<String> meat = new ArrayList<String>();
		for (String retval : strUp.split(";")) {
			String[] fullname=retval.split(":");
			meat.add("("+fullname[1]+", "+ fullname[0]+")");
		}
		Collections.sort(meat);
		return meat;
	}
	public static void main(String[] args) {
		System.out.println(meating("Fred:Cornwill;Fred:Cornwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Cornwill;Alfred:Cornwill"));
	}
}
