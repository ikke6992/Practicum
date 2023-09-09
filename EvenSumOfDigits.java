public class EvenSumOfDigits {
	
	public static void main(String[] args) {
		
		for (int i = 100; i < 150; i++) {
			
			if ((i + i/10 + i/100) % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}