package hw;

import java.util.stream.IntStream;

public class FourthFunction {
	public static int countPairs(int[] arr, int target) {
		int n=0;
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr.length;j++){
				if(i==j) continue;
				if(arr[i]+arr[j]==target) n++;
			}
		return n/2;
	}
	public static int countPairsStream(int[] arr, int target) {
		int[] count= {0};
		IntStream.range(0,  arr.length)
	    .forEach(i -> IntStream.range(0,  arr.length)
	        .filter(j -> i != j && arr[i]+ arr[j]== target)
	        .forEach(j -> count[0]+=1));
		return count[0]/2;
	}
	
	public static void main(String[] args) {
		int[] arr={1, 3, 6, 2, 2, 0, 4, 5,0,-1};
		System.out.println(countPairs(arr, 5));//output:6
		System.out.println(countPairsStream(arr, 5));//output:6
	}
}


