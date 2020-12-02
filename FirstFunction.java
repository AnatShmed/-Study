package hw;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FirstFunction{
	public static List<Object> getIntegersFromList(List<Object> l) {
		List<Object> result=l.stream().filter(num -> num instanceof Integer && (int) num >= 0).collect(Collectors.toList());
		return result;
	}
	public static void main(String[] Args) {
		System.out.println(getIntegersFromList(Arrays.asList(1,2,"a","b")));//output:[1,2]
		System.out.println(getIntegersFromList(Arrays.asList(1,2,"a","b",0,15)));//output:[1,2,0,15]
		System.out.println(getIntegersFromList(Arrays.asList(1,2,"a","b","aasf","1","123",231)));//output:[1,2,231]
	}
}