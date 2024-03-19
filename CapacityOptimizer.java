public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {
		
		int capacity = 1;
		long start, end;
		boolean endOfSim = false;

		while (!endOfSim) {
			System.out.println("=== Setting lot capacity to: " + capacity + "===");
			int qSizes = 0;
			
			for (int i = 0; i < NUM_RUNS; i++) {
				ParkingLot lot = new ParkingLot(capacity);
				Simulator sim = new Simulator(lot, hourlyRate, 24 * 3600);

				start = System.currentTimeMillis();
				sim.simulate();
				end = System.currentTimeMillis();
				
				int incomingQSize = sim.getIncomingQueueSize();
				qSizes += incomingQSize;
				
				System.out.println("Simulation run " + i + " (" + (end - start) + "ms); Queue length at the end of simulation run: " + incomingQSize);
			}
			float average = qSizes/NUM_RUNS;

			if (average <= THRESHOLD) {
				endOfSim = true;
			} else {
				System.out.println();
				capacity++;
			} 
		}

		return capacity;

	}

	public static void main(String args[]) {
	
		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}