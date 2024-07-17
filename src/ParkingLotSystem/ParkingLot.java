package ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<LargeSpot>largeSpotList=new ArrayList<>();
    List<CompactSpot>compactSpotList=new ArrayList<>();
    List<BikeSpot>bikeSpotList=new ArrayList<>();

    int freeLargeSpots;
    int freeCompactSpots;
    int freeBikeSpots;

    public ParkingLot(int freeLargeSpots, int freeCompactSpots, int freeBikeSpots) {
        this.freeLargeSpots = freeLargeSpots;
        this.freeCompactSpots = freeCompactSpots;
        this.freeBikeSpots = freeBikeSpots;
    }

    //parkingVehicle
    public void parkVehicle(Vehicle vehicle){
        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(freeLargeSpots>0)
                parkYourLargeVehicle(vehicle);
            else
                System.out.println("Sorry, all large spots are full.");
        }
        else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(freeCompactSpots>0)
                parkYourCompactVehicle(vehicle);
            else
                System.out.println("Sorry, all compact spots are full.");
        }
        else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(freeBikeSpots>0)
                parkYourBikeVehicle(vehicle);
            else
                System.out.println("Sorry, all bike spots are full.");
        }

    }

    void parkYourLargeVehicle(Vehicle vehicle){
        LargeSpot largeSpot=new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);
        largeSpotList.add(largeSpot);
        System.out.println("We have successfully parked your "+vehicle.getVehicleType()+" vehicle.");
        freeLargeSpots--;
    }
    void parkYourCompactVehicle(Vehicle vehicle){
       CompactSpot compactSpot=new CompactSpot(ParkingSpotType.COMPACT);
       compactSpot.setFree(false);
       compactSpot.setVehicle(vehicle);
       vehicle.setParkingSpot(compactSpot);
       compactSpotList.add(compactSpot);
       System.out.println("We have successfully parked your "+vehicle.getVehicleType()+" vehicle.");
       freeCompactSpots--;
    }
    void parkYourBikeVehicle(Vehicle vehicle){
        BikeSpot bikeSpot=new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setFree(false);
        bikeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeSpot);
        bikeSpotList.add(bikeSpot);
        System.out.println("We have successfully parked your "+vehicle.getVehicleType()+" vehicle.");
        freeBikeSpots--;
    }

    //unparkingvehicle
    public void unparkVehicle(Vehicle vehicle){
        System.out.println("We are about to unpark your vehicle "+vehicle.getVehicleType());
        ParkingSpot parkingSpot=vehicle.getParkingSpot();
//        parkingSpot.setFree(true);

        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(largeSpotList.remove(parkingSpot)){
               System.out.println("We have successfully removed your vehicle.");
               freeLargeSpots++;
           }
           else
               System.out.println("You don't have your vehicle parked at this parking lot.");
        }
        else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(compactSpotList.remove(parkingSpot)){
                System.out.println("We have successfully removed your vehicle.");
                freeCompactSpots++;
            }
            else
                System.out.println("You don't have your vehicle parked at this parking lot.");
        }
        else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(bikeSpotList.remove(parkingSpot)){
                System.out.println("We have successfully removed your vehicle.");
                freeBikeSpots++;
            }
            else
                System.out.println("You don't have your vehicle parked at this parking lot.");
        }
    }
}
