import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ElevatorCar e1 = new ElevatorCar(1);
        ElevatorCar e2 = new ElevatorCar(2);
        ElevatorSystem system = new ElevatorSystem(Arrays.asList(e1, e2));


      // External requests
        system.handleExternalRequest(new ExternalRequest(5, Direction.UP));
        system.handleExternalRequest(new ExternalRequest(2, Direction.DOWN));


        // Internal requests (user pressed inside elevator panel)
        e1.addNewRequest(8);
        e2.addNewRequest(0);


        // Simulate steps - call step until all elevators are idle
        for (int i = 0; i < 6; i++) {
            System.out.println("-- Step " + (i+1) + " --");
            system.step();
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        }


        System.out.println("Simulation finished.");
    }

}
