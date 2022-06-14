
import java.util.Scanner;
import java.text.DecimalFormat;
/***************************************************************
 Filename: Rocket2
 Created by: Melat Semereab
 Created on: 10/20/2021
 Comment: This program should read in 3 integers representing the blast-off time of a rocket expressed in hours,
 minutes and seconds on the 24-hour clock, Then read another integer giving the rocket's flight time in
 seconds. Using the data to calculate the time of day at which the rocket will return to earth
 ***************************************************************/

public class Main 
{
    static Scanner keyboard = new Scanner(System.in);
    static int hour, minute, second, givenTotalSecond;

    //to read data from end user
    public static void readData()
    {
        System.out.println("What is the take-off time (24-hour clock)");
        System.out.println("Hour: ");
        hour = keyboard.nextShort();

        System.out.println("Minute: ");
        minute = keyboard.nextInt();

        System.out.println("Second: ");
        second = keyboard.nextInt();

        System.out.println("Enter the rocket's flight time in seconds ");
        givenTotalSecond = keyboard.nextInt();

        //printing the take off time
        System.out.println("Take-off Time: " + hour +":" + minute + ":" + second);
        //printing given total second it would stay in space
        System.out.println("Flight time: " + givenTotalSecond);
        //calling our other method
        calculateArrivalTime(hour, minute, second, givenTotalSecond);
    }

    //calculating the arrival time
    public static void calculateArrivalTime(int    pHour, int pMinute, int pSecond, int   pGivenTotalSecond) 
    {
        DecimalFormat df = new DecimalFormat("00");
        pHour = pGivenTotalSecond / 3600;
        pMinute = (pGivenTotalSecond % 3600) / 60;
        pSecond = (pGivenTotalSecond % 3600) % 60;
        hour = hour + pHour;
        minute = minute + pMinute;
        second = second + pSecond;

        if (second > 60)
        {
            minute += 1;
            second = second - 60;
        }//if
        if (minute > 60)
        {
            hour += 1;
            minute = minute - 60;
        }//if
        if (hour > 24)
        {
            hour = hour - 24;
        }//if
        System.out.println("Expected Arrival Time " + df.format(hour) + ":" + df.format(minute) + ":" + df.format(second));
    }//method

    public static void main(String args[]) {
        readData();
    }//main
}//class