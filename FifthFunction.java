package hw;

import java.util.ArrayList;
import java.util.Collections;

public class FifthFunction {
	public static String meating(String str) {
		String strUp=str.toUpperCase();
		ArrayList<String> arr=new ArrayList<String>();
		for (String retval : strUp.split(";")) {
			arr.add(retval);
        }
		for(int i=0; i<arr.size(); i++) {
			ArrayList<String> tmp_arr=new ArrayList<String>();
			for (String retval : arr.get(i).split(":")) {
				tmp_arr.add(retval);
			}	
			arr.set(i, "(".concat(tmp_arr.get(1).concat(", "+tmp_arr.get(0)+")")));
		}
		Collections.sort(arr);
		String[] result= {""};
		for(int i=0; i<arr.size(); i++) {
			result[0]= result[0].concat(arr.get(i));
		}
		return result[0];
	}
	public static void main(String[] args) {
		System.out.println(meating("Fred:Cornwill;Fred:Cornwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Cornwill;Alfred:Cornwill"));//output:7
	}
}
