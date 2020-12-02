public class Extra2 {
	public static String IPv4(int unsigned) {
		String[] uns_str = {Integer.toUnsignedString(unsigned, 2)};
		while(uns_str[0].length()<32) {
			uns_str[0] ="0".concat(uns_str[0]); 
		}
		uns_str[0]=Integer.toString(Integer.parseInt(uns_str[0].substring(0, 8), 2))
				.concat("."+Integer.toString(Integer.parseInt(uns_str[0].substring(8, 16), 2))
				+"."+Integer.toString(Integer.parseInt(uns_str[0].substring(16, 24), 2))
				+"."+Integer.toString(Integer.parseInt(uns_str[0].substring(24, 32), 2)));
		return uns_str[0];
	}
	public static void main(String[] args) {
		System.out.println(IPv4(Integer.parseUnsignedInt("2149583361")));//output:"128.32.10.1"
		System.out.println(IPv4(Integer.parseUnsignedInt("32")));//output:"0.0.0.32"
		System.out.println(IPv4(Integer.parseUnsignedInt("0")));//output:"0.0.0.0"
		System.out.println(IPv4(Integer.parseUnsignedInt("4294967295")));//output:"255.255.255.255"
	}
}
