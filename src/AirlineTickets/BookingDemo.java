package AirlineTickets;


//--------------------------    
      //imports
//--------------------------
import java.io.File;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class BookingDemo {
    
//--------------------------      
//the main class method
//-------------------------- 
    
public static void main(String[] args) throws Exception{
    
//--------------------------      
//creating scanners and file objects for reading input files 1 & 2
//--------------------------    

       File file1=new File("inputDB.txt");
       Scanner input1=new Scanner(file1);
       
       
       File file2=new File("inputBookings.txt");
       Scanner input2=new Scanner(file2);
       
//--------------------------      
//Check whether or not input files exists
//-------------------------- 

       if(!file1.exists()){
           System.out.println("File 1 doesn't exixts");
           System.exit(0);
       }
       if(!file2.exists()){
           System.out.println("File 2 doesn't exixts");
           System.exit(0);
       }
       
//--------------------------      
//creating printwriters and file objects for writing output files 1 & 2
//-------------------------- 

       File outputf1=new File("printLog.txt");
       PrintWriter output1=new PrintWriter(outputf1);
       
       File outputf2=new File("printBookings.txt");
       PrintWriter output2=new PrintWriter(outputf2);
       
//-------------------------   
//creat arrays and taking size as input   
//-------------------------

        Airline[]airline=new Airline[input1.nextInt()];
        Airport[]airport=new Airport[input1.nextInt()];
        Flight[]flight=new Flight[input1.nextInt()];
        
//--------------------------          
//reading input 1 file 
//--------------------------    

      int aln=0,fn=0,apn=0;
      String command;
      
       do{ command= input1.next();
           
           if(command.equalsIgnoreCase("ADD_Airline")){
                   
                   airline[aln]=getAirline(input1);
                   aln++;
               }
           
           if(command.equalsIgnoreCase("ADD_Flight")){
               
               flight[fn]=getFlight(input1);
               fn++;
               }
           
            if(command.equalsIgnoreCase("ADD_Airport")){
               
               airport[apn]=getAirport(input1);
              apn++;
           }
            
            if(command.equalsIgnoreCase("Quit")){
               input1.close();
               break;
           }
        } while(input1.hasNext());
      
      
//--------------------------      
//printing the information in printLog file
//--------------------------    
      
       output1.println("--------------- Air Ticket Reservation System Log ---------------");
       output1.flush();
       for(int i=0;i<airline.length;i++){
           output1.println("\n(New Airline Added)\t"+airline[i].toString()+"\n-------------------------"); }
       output1.flush();
       for(int i=0;i<flight.length;i++){
           output1.println("\n(New Flight Added)\t"+flight[i].toString()+"\n-------------------------");}
       output1.flush();
       for(int i=0;i<airport.length;i++){
           output1.println("\n(New Airport Added)\t"+airport[i].toString()+"\n-------------------------");}

//-------------------------   
//Close the objects after writing to the output files   
//-------------------------

       output1.flush();
       output1.close();
       
//--------------------------      
//reading from input2
//-------------------------- 

    Booking[]booking=new Booking[input2.nextInt()];
    int b=0; String monthOft=null,dayOft,monthOfb,dayOfb;


    do{command=input2.next();
        if(command.equalsIgnoreCase("NewBooking")){
        
             booking[b]=GenerateBooking(input2,flight,airline,airport,output2);
             b++;
        }
        
         if (command.equalsIgnoreCase("Quit")){
             input1.close();
             break;
    }
         
} while(input2.hasNext());


//--------------------------      
//printing in printBookings.txt file
//-------------------------- 

         output2.println("--------------- Welcome to Air Ticket Reservation System ---------------\n\n");
         for(int i=0;i<booking.length;i++){
             
            Booking bookingm=booking[i];
            printbooking(bookingm,output2);
   }
         
//-------------------------   
//Close the objects after writing to the output files   
//-------------------------
   output2.close();
   input1.close();
   input2.close();
   
    }
//-------------------------   
//end of main class
//-------------------------

//-------------------------------------------------------------------------------------------------------------

//-------------------------   
//method to read arguments and creat airline object
//-------------------------

private static Airline getAirline(Scanner input1){
    
                   String tod=input1.next();
                   String name=input1.next();
                   String oc=input1.next();
                   String ws=input1.next();
                   Airline al=new Airline(tod,name,oc,ws);
                   return al;
}

//-------------------------------------------------------------------------------------------------------------

//-------------------------   
//method to read arguments and creat airport object
//-------------------------

private static Airport getAirport(Scanner input1){
    
               String tdc=input1.next();
               String c=input1.next();
               String n=input1.next();
               Airport ap=new Airport(tdc,c,n);
               return ap;
}

//-------------------------------------------------------------------------------------------------------------

//-------------------------   
//method to read arguments and creat flight object
//-------------------------

private static  Flight getFlight(Scanner input1){
   
               String flightno=input1.next();
               String dep=input1.next();
               String des=input1.next();
               double fare=input1.nextDouble();
               Flight f=new Flight(flightno,dep,des,fare);
               return f;
}

//-------------------------------------------------------------------------------------------------------------

//-------------------------   
//method to read arguments and creat booking object
//-------------------------
private static Booking GenerateBooking(Scanner input2,Flight[]flight,Airline[]airline
,Airport[]airport,PrintWriter output2) throws ParseException{
    
        int b=0; String monthOft=null,dayOft,monthOfb,dayOfb;
        SimpleDateFormat formatterF = new SimpleDateFormat("yyyy d M");
        
        //creat a boooking no.
        long bookingNo=System.currentTimeMillis();
        
        //read argument and search to compare it with the the commad saved in the flight array
        String threeFlightNo=input2.next();
        Flight flightB=null;
        for(int i=0;i<flight.length;i++){
            if(flight[i].getFlightNo().equalsIgnoreCase(threeFlightNo)){
                flightB=flight[i];
            }
        }
       
        //read argument and search to compare it with the the commad saved in the airline array
        String AirlineCode=input2.next();
        Airline airlineB=null;
        for(int i=0;i<airline.length;i++){
            if(airline[i].getTowDigitsCode().equalsIgnoreCase(AirlineCode)){
                airlineB=airline[i];
            }
        }
        
        //read argument and search to compare it with the the commad saved in the airport array
        String cityCode=input2.next();
        Airport airportB=null;
        for(int i=0;i<airport.length;i++){
            if(airport[i].getThreeDigitCode().equalsIgnoreCase(cityCode)){
                airportB=airport[i];
            }
        }
        
        //take the date as a string input
        String yearOft=input2.next();
        monthOft=input2.next();
        dayOft=input2.next();
        String thedatet=yearOft+" "+dayOft+" "+monthOft;
        
        //parse and convert the string date to a date object
        Date dateOfT= formatterF.parse(thedatet);
        
        String nameOfC=input2.next();
        
        String yearOfb=input2.next();
        monthOfb=input2.next();
        dayOfb=input2.next();
        String thedateb=yearOfb+" "+dayOfb+" "+monthOfb;
        
        //parse and convert the string date to a date object
        Date dateOfB= formatterF.parse(thedateb);
        
        boolean isB=input2.nextBoolean();
        
        int BW=input2.nextInt();
        
        //pass the argument for the booking object
        Booking bookingP=new Booking(bookingNo,flightB,airlineB,airportB,dateOfT,nameOfC,dateOfB,isB,BW);
        return bookingP;
}

//-------------------------------------------------------------------------------------------------------------

//-------------------------   
//print the tickets from the booking class to output2 printBooking
//-------------------------

public static void printbooking(Booking booking,PrintWriter output2){
    
    //creat a date format to format the date display in the ticket
    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-d-M");
    
    
    output2.println(
            "Booking No. "+booking.getBookingNo()+
            
            "\n\nPassenger Details\tPassenger Name: "+booking.getName()+
            "\t\tDate of Birth: "+formatter2.format(booking.getDob())+
            
            "\n\nFlight Details"+ 
            "\tFlight Code: "+booking.getAirline().getTowDigitsCode()+"-"+booking.getFlight().getFlightNo()+"\t\t\t\t"+
                    formatter2.format(booking.getFlightDate())+
            "\n\t\t\tDeparture: "+booking.getFlight().getDeparture()+
            "\t\tDestination: "+booking.getFlight().getDestnation()+
            
            "\n\nAirport Details    Airport Name: "+booking.getAirport().getName()+" ("+booking.getAirport().getThreeDigitCode()+"), "+booking.getAirport().getcity()
    
           +"\n\nAirline Details	Name: "+booking.getAirline().getName()+" based in "+booking.getAirline().getWebsite()+
            
            "\n\nFare Details\tRegular Fare: SAR "+booking.getFlight().getFare()+
            "\n\t\t\tTotal Fare: SAR "+booking.CalculateFare()+
            "\n\n---------------------------------------------------------------------------------------------------------------------------\n");
    //close the output
    output2.flush();
    }


//-------------------------   
//end of the entire program
//-------------------------
}

