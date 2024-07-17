package ParkingLotSystem;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot=new ParkingLot(4,4,4);
        Vehicle car=new Vehicle(VehicleType.CAR);
        parkingLot.parkVehicle(car);
        parkingLot.unparkVehicle(car);
    }
}