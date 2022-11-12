import java.util.*;
public class onlinejudge_11942 {
	public static void main(String[] args) {
		
		// Setting up input storing number of groups, and String array for final analysis output.
		Scanner input = new Scanner(System.in);
		int numGroups = input.nextInt();
		String[] analysis = new String[numGroups];
		
		// Declaring variables for following iteration so that they can just be overwritten instead of re-created. 
		int prev, curr;
		String initialDir;
		
		// Running through all input groups to determine its order/unordered status.
		for (int i = 0; i < numGroups; i++) {
			// Assume ordered until contrary proves otherwise.
			analysis[i] = "Ordered";
			initialDir = "nullz";
			
			// Collecting input and skipping first line (for input groups).
			String line = input.nextLine();
			if (i == 0) {line = input.nextLine();}
			Scanner line_input = new Scanner(line);
			
			if (line_input.hasNext()) {
				// Previous and current values (starting at index 1) shows movement up or down.
				prev = line_input.nextInt();
				for (int j = 1; j < 10; j++) {
					curr = line_input.nextInt();
					if (initialDir.equals("nullz")){
						if (prev < curr) {
							initialDir = "up";
						} else if (prev > curr) {
							initialDir = "down";
						}
					// Discovering conflict in direction/movement.
					}else {
						if (prev < curr && initialDir.equals("down")) {
							analysis[i] = "Unordered";
							break;
						} else if (prev > curr && initialDir.equals("up")) {
							analysis[i] = "Unordered";
							break;
						}
					}
					// Updating previous to be current for next iteration.
					prev = curr;
				}
			}
			// Closing scanner for input.
			line_input.close();
		}
		input.close();
		// Printing results of all analysis.
		for (int i = 0; i < analysis.length; i++) {
			System.out.println(analysis[i]);
		}
	}
}
