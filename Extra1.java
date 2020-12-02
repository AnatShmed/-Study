import java.util.ArrayList;
import java.util.Collections;

public class Extra1 {
	public static int nextBigger(int n) {
		if(n<12) return -1;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		int num=0;
		while(n>0){
			num=n%10;
			n=n/10;
			arr.add(num);
		}
		for(int i=0;i<arr.size()-1;i++) {
			if(arr.get(i)>arr.get(i+1)) {
				Collections.swap(arr, i, i+1);
				int sum=0;
				int pow=1;
				for(int j=0;j<arr.size();j++) {
					sum+=arr.get(j)*pow;
					pow*=10;
				}
				return sum;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(nextBigger(16));//output:61
		System.out.println(nextBigger(942));//output:-1
		System.out.println(nextBigger(132189));//output:132198
		System.out.println(nextBigger(493193));//output:493913
	}
}
