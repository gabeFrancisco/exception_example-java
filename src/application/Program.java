package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after the Check-in date");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation.toString());

            System.out.println("Enter data do update the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null){
                System.out.println(error);
            }
            else{
                System.out.println(reservation.toString());
            }
        }
        sc.close();
    }
}
