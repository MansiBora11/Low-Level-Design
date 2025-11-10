public class InternalRequest {
    private final int destinationFloor;

    public InternalRequest(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    @Override
    public String toString() {
        return "InternalRequest{" +
                "destinationFloor=" + destinationFloor +
                '}';
    }
}
