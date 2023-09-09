import java.util.Collections;
import java.util.Map;

public class FakeAmericanGradesWithLambdas {
	
	public static String ifElseGrading(int[] percentages) {
		
		String grades = "";
		
		for (int percentage : percentages) {
			
			grades += percentage + " results in a grade of ";
			
			if (percentage > 100 || percentage < 0) {
				throw new IllegalArgumentException(percentage + " is not in range 0..100");
			} else if (percentage > 80) {
				grades += 'A';
			} else if (percentage > 60) {
				grades += 'B';
			} else if (percentage > 50) {
				grades += 'C';
			} else if (percentage > 45) {
				grades += 'D';
			} else if (percentage > 25) {
				grades += 'E';
			} else {
				grades += 'F';
			}
			grades += '\n';
		}
		
		return grades;
	}
	
	public static String switchGrading(int[] percentages) {
		
		String grades = "";
		
		for (int percentage : percentages) {
			
			grades += percentage + " results in a grade of ";
			
			if (percentage > 100 || percentage < 0) {
				throw new IllegalArgumentException(percentage + " is not in range 0..100");
			}
			
			//is there an easier way to do this with a switch-case?
			switch (percentage) {
				case 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 
					91, 92, 93, 94, 95, 96, 97, 98, 99, 100:
					grades += 'A';
					break;
				case 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 
					71, 72, 73, 74, 75, 76, 77, 78, 79, 80:
					grades += 'B';
					break;
				case 51, 52, 53, 54, 55, 56, 57, 58, 59, 60:
					grades += 'C';
					break;
				case 46, 47, 48, 49, 50:
					grades += 'D';
					break;
				case 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 
					36, 37, 38, 39, 40, 41, 42, 43, 44, 45:
					grades += 'E';
					break;
				default:
					grades += 'F';
					break;
			}	
			grades += '\n';
		}
		return grades;
	}
	
	public static String mapGrading(int[] percentages) {
		
		String grades = "";
		
		Map<Integer, Character> gradeSystem = Map.of(80, 'A', 60, 'B', 50, 'C', 45, 'D', 25, 'E');
		
		for (int percentage : percentages) {
			
			if (percentage > 100 || percentage < 0) {
				throw new IllegalArgumentException(percentage + " is not in range 0..100");
			}
			
			/*
				What does stream do? sorted sorts the keys in reverse order so that the highest value
				comes first, filter takes just the keys that are smaller than percentage and then 
				findFirst takes the first element of that set, which because it is sorted is the 
				greatest remaining key. Then map(gradeSystem::get) uses the get-function of Map to
				return the value corresponding to that key, and if it does not exist orElse returns 'F'
			*/
			grades += percentage + " results in a grade of " + gradeSystem.keySet().stream()
				.sorted(Collections.reverseOrder()).filter(limit -> limit < percentage)
				.findFirst().map(gradeSystem::get).orElse('F') + '\n';
		}
		
		return grades;
	}
	
	public static void main(String[] args) {
		if (args.length != 0) {
			int[] percentages = new int[args.length];
			for (int i = 0; i < args.length; i++) {
				percentages[i] = Integer.parseInt(args[i]);
			}
			System.out.println(mapGrading(percentages));
		} else {
			int[] percentages = {40, 12, 90, 80};
			System.out.println(mapGrading(percentages));
		}
	}
}