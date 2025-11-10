import java.util.PriorityQueue;

public class ElevatorCar {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private final PriorityQueue<Integer>upStops;
    private final PriorityQueue<Integer>downStops;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.upStops = new PriorityQueue<>();
        this.downStops = new PriorityQueue<>((a,b)-> b-a);
    }

    /**
     * Floors the elevator has to serve.
     */
    public synchronized void addNewRequest(int floor){
        if(floor == currentFloor){
            System.out.println("Elevator " + id + " already at " + currentFloor + " - opening doors.");
            openDoors();
            return;
        }
        if(floor > currentFloor){
            upStops.add(floor);
            if(direction == Direction.IDLE){
                direction=Direction.UP;
            }
        }else{
            downStops.add(floor);
            if(direction == Direction.DOWN){
                direction=Direction.DOWN;
            }
        }
    }

    /**
     * Process next move for this elevator (one stop per call).
     */
    public synchronized void move(){
        if(direction==Direction.UP && !upStops.isEmpty()){
            int next=upStops.poll();
            moveTo(next);
            if(upStops.isEmpty()){
                direction = downStops.isEmpty() ? Direction.IDLE : Direction.DOWN;
            }
        } else if(direction==Direction.DOWN && !downStops.isEmpty()){
            int next= downStops.poll();
            moveTo(next);
            if(downStops.isEmpty()){
                direction = upStops.isEmpty() ? Direction.IDLE : Direction.UP;
            }
        } else{
            if(!upStops.isEmpty()){
                direction=Direction.UP;
                move();
            }else if(!downStops.isEmpty()){
                direction=Direction.DOWN;
                move();
            }else{
                direction=Direction.IDLE;
                state = ElevatorState.IDLE;
            }
        }
    }

    public void moveTo(int floor){
        System.out.println("Elevator "+ id +" moving from "+currentFloor+" to "+ floor);
        state=ElevatorState.MOVING;
        currentFloor=floor;

        state=ElevatorState.DOOR_OPENED;
        System.out.println("Elevator " + id + " doors opened at floor " + currentFloor);
        closeDoors();
    }
    private void openDoors() {
        state = ElevatorState.DOOR_OPENED;
        System.out.println("Elevator " + id + " doors opened at floor " + currentFloor);
    }

    private void closeDoors() {
        state = ElevatorState.DOOR_CLOSED;
        System.out.println("Elevator " + id + " doors closed at floor " + currentFloor);
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public PriorityQueue<Integer> getUpStops() {
        return upStops;
    }

    public PriorityQueue<Integer> getDownStops() {
        return downStops;
    }
}

