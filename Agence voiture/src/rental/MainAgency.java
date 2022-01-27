package rental;

import java.util.*;

public class MainAgency {
    public static void main(String[] args){
        Vehicle voiture1 = new Vehicle("ford", "1999", 2019, 10000);
        Vehicle voiture2 = new Vehicle("nissand", "xray", 2000, 20000);
        Vehicle voiture3 = new Vehicle("mercedes", "benz", 1980, 30000);
        Vehicle car1 = new Car("xy", "ww-Z", 1970, 15000, 5);
        Vehicle car2 = new Car("zer", "ww-Y", 1990, 12000, 5);
        Vehicle Moto = new Motorbike("moto", "benl", 2000, 5000, 12);
        RentalAgency Agence = new RentalAgency();
        RentalAgency susAgence = new SuspiciousRentalAgency();
        Agence.addVehicle(voiture1);
        Agence.addVehicle(voiture2);
        Agence.addVehicle(voiture3);
        Agence.addVehicle(car1);
        Agence.addVehicle(car2);
        Agence.addVehicle(Moto);
        susAgence.addVehicle(voiture1);
        susAgence.addVehicle(voiture2);
        susAgence.addVehicle(voiture3);
        susAgence.addVehicle(car1);
        susAgence.addVehicle(car2);
        susAgence.addVehicle(Moto);
        VehicleFilter filtre1 = new MaxPriceFilter(30000);
        VehicleFilter filtre2 = new BrandFilter("mercedes");
        VehicleFilter filtre3 = new BrandFilter("nissand");
        AndFilter filtre = new AndFilter();
        filtre.addFilter(filtre1);
        filtre.addFilter(filtre3);
        List<Vehicle> listedevehicle = Agence.getAllVehicles();
        System.out.println("la liste des vehicles dans l'agence : " + listedevehicle);
        Agence.displaySelection(filtre2);
        Agence.displaySelection(filtre);
        Client client1 =new Client("diallo", 20);
        Client client2 =new Client("sam", 30);
        Client client3 =new Client("jack",40);
        try{
            float prix1 = susAgence.rentVehicle(client1, voiture1);
            float prix2 = susAgence.rentVehicle(client2, car1);
            float prix3 = Agence.rentVehicle(client3, Moto);
            System.out.println("les vehicules loués sont: "+ Agence.allRentedVehicles());
            System.out.println("le jeune " +client1.getName() +" a loué avec un prix: "+ prix1);
            System.out.println("l'adulte " +client2.getName() +" a loué avec un prix: "+ prix2);
            susAgence.returnVehicle(client1);
            Agence.returnVehicle(client2);
            System.out.println("les vehicules loués sont: "+ Agence.allRentedVehicles());

        }catch(Exception e){
            System.out.println("il y a un problème");
        }



    }

    
}
