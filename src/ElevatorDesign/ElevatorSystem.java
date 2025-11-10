import java.util.List;

public class ElevatorSystem {
    private final List<ElevatorCar> elevators;

    public ElevatorSystem(List<ElevatorCar> elevators) {
        this.elevators = elevators;
    }

    public synchronized void handleExternalRequest(ExternalRequest request){
        ElevatorCar chosen = elevators.stream()
                .filter(e -> e.getDirection() == Direction.IDLE)
                .findFirst()
                .orElseGet(()->findClosestElevator(request.getFloor()));
        System.out.println("Assigning Elevator " + chosen.getId() + " to request at floor " + request.getFloor() + " (" + request.getDirection() + ")");
        chosen.addNewRequest(request.getFloor());
    }

    /**
     * Handle an external request. Either choose the first IDLE elevator,
     * or choose the elevator with the minimum distance to the requested floor.
     */
    private ElevatorCar findClosestElevator(int floor){
        ElevatorCar best = null;
        int bestDist = Integer.MAX_VALUE;
        for(ElevatorCar e: elevators){
            int dist = Math.abs(e.getCurrentFloor() - floor);
            if(dist < bestDist){
                bestDist = dist;
                best = e;
            }
        }
        return best != null ? best : elevators.get(0);
    }

    /**
     * Advance all elevators by one step.
     */
    public void step() {
        for (ElevatorCar e : elevators) {
            e.move();
        }
    }


}
