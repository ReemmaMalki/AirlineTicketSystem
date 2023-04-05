package AirlineTickets;

public class Booking {
    
//--------------------------    
      //data field
//--------------------------
    
    private long bookingNo;
    private Flight flight;
    private Airline airline;
    private Airport airport;
    java.util.Date flightDate;
    private String name;
    java.util.Date dob;
    private boolean isBuisnessClass;
    private int baggageWeight;
 
//--------------------------    
      //constructur
//--------------------------
    
public Booking(long bookingNo,Flight flight,Airline airline,Airport airport,java.util.Date flightDate,
     String name, java.util.Date dob,boolean isBuisnessClass,int baggageWeight){
    this.bookingNo=bookingNo;
    this.flight=flight;
    this.airline=airline;
    this.airport=airport;
    this.flightDate=flightDate;
    this.name=name;
    this.dob=dob;
    this.isBuisnessClass=isBuisnessClass;
    this.baggageWeight=baggageWeight;
    }  

//--------------------------    
    //setters and getters
//--------------------------

public long getBookingNo(){
    return bookingNo;
    }
public void setBookingNo(long bookingNo){
    this.bookingNo=bookingNo ;
    }


public Flight getFlight(){
    return flight;
    }
public void setFlight(Flight flight){
    this.flight=flight;
    }


public Airline getAirline(){
    return airline;
    }
public void setAirline(Airline airline){
    this.airline=airline;
    }   


public Airport getAirport(){
    return airport;
    }
public void setAirport(Airport airport){
    this.airport=airport;
    }


public java.util.Date getFlightDate(){
    return flightDate;
    }
public void setFlightDate(java.util.Date flightDate){
    this.flightDate=flightDate;
    }


public String getName(){
    return name;
    }
public void setName(String name){
    this.name=name;
    }


public java.util.Date getDob(){
    return dob;
    }
public void setDob(java.util.Date dob){
    this.dob=dob;
    }


public boolean getIsBuisnessClass(){
    return isBuisnessClass;
    }
public void setIsBuisnessClass(boolean isBuisnessClass){
    this.isBuisnessClass=isBuisnessClass;
    }


public int getBaggageWeight(){
    return baggageWeight;
    }
public void setBaggageWeight(int baggageWeight){
    this.baggageWeight=baggageWeight;
    }

//--------------------------    
      //methods
//--------------------------

public double CalculateFare(){
    double regfare=getFlight().getFare();
    double age;
    java.util.Date date=new java.util.Date();
    
    age=date.getTime()-dob.getTime();
    double years=0;
    double cal=age/1000;
    if (cal > 60 * 60 * 24 * 365){
     years = cal / (60 * 60 * 24 * 365);}
    cal %= (60 * 60 * 24 * 365);
    
    if(years<=2){
        regfare=0.1*regfare;
        }
    else if(years<=12){
        regfare=0.7*regfare;
        }
    else 
        regfare=regfare;
    
    
 //-------------
    
        double price=0;
        if(isBuisnessClass){
            regfare=1.4*regfare;
            
            if(baggageWeight>50){
                price=(baggageWeight-50)*30;
            }
        }
        else {
            if(baggageWeight>30){
                price=(baggageWeight-30)*30;
            }
        }
        
   //-----------------------
    
    regfare=(double)Math.round(regfare * 1d) / 1d;
            
    return price+regfare;
    }
}
