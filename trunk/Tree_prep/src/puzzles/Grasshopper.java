package puzzles;

public class Grasshopper {

	static boolean doRiver(boolean river[], int len) {
		if (len == 0) {
			return true; // Nothing to cross.
		}
		if (river[0]) {
			return doSubRiver(river, 0, 1, len); // Got to first stone.
		}
		return false; // First stone is too far away.
	}

	static boolean doSubRiver(boolean river[], int pos, int speed, int len) {
		// Calculate target position.
		int target = pos + speed;

		if (target + 1 >= len) {
			return true; // Could accelerate to far bank. // Landed on or overshot far bank.
		}
		
		if (river[target + 1]) {
			// Could accelerate to next stone, so increase speed
			// and set position to new target.
			return doSubRiver(river,  target + 1, speed + 1, len);
		}

		if (river[target]) {
			// Current speed is ok, so move to target.
			return doSubRiver(river,  target, speed, len);
		}
		
		if (river[target - 1] == true && speed - 1 > 0) {
			// Can decelerate to next stone, so decrease speed and
			// set position of new target.
			//also make sure u cant decrease the speed to 0.
			return doSubRiver(river,  target - 1, speed - 1,len);
		}

		// No stone is within reach.
		return false;
	}

	public static void main(String[] args) {
	
		
		boolean[] okcrossing1 = {true, true, false,true,false};		
		boolean[] nocrossing = {true,true,false,false,false};
		
		System.out.println("OK : " + doRiver(okcrossing1, 5));
		System.out.println("NO Crossing : " + doRiver(nocrossing, 5));

	}

}
