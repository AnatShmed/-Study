package hw;

public class SecondFunction {
	public static char firstNonRepeatingLetter(String str) {
		for(int i=0;i<str.length();i++) {
			if(!Character.isLetter(str.charAt(i))) continue;
			boolean isRepeat=false;
			for(int j=0;j<str.length()&&!isRepeat;j++) {
				if(i==j) continue;
				if(Character.toUpperCase(str.charAt(i))==Character.toUpperCase(str.charAt(j))) isRepeat=true;
			}
			if(!isRepeat) return str.charAt(i);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(firstNonRepeatingLetter("TTSS"));//output:null
		System.out.println(firstNonRepeatingLetter("1123  sTreSS"));//output:T
		System.out.println(firstNonRepeatingLetter("sTreS test"));//output:r
	}
}
