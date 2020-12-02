public class ThirdFunction {
	public static int digitalRoot(int n) {
		if(n<10) return n;
		while(n>9) {
			int num=0;
			while(n>0){
				num+=n%10;
				n=n/10;
			}
			n=num;
		}
		return n;
	}
	public static void main(String[] args) {
		System.out.println(digitalRoot(16));//output:7
		System.out.println(digitalRoot(942));//output:6
		System.out.println(digitalRoot(132189));//output:6
		System.out.println(digitalRoot(493193));//output:2
	}
}
