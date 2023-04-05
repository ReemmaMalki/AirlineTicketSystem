package AirlineTickets;

public class Flight {
    
//--------------------------    
      //data field
//--------------------------
    
    private String flightNo;
    private String departure;
    private String destnation;
    private double fare;

//--------------------------    
      //constructur
//--------------------------
    
public Flight(String flightNo,String departure,String destnation,double fare){
    this.flightNo=flightNo;
    this.departure=departure;
    this.destnation=destnation;
    this.fare=fare;
    }  

//--------------------------    
    //setters and getters
//--------------------------

public String getFlightNo(){
    return flightNo;
    }
public void setFlightNo(String flightNo){
    this.flightNo=flightNo;
    }  


public String getDeparture(){
    return departure;
    }
public void setDeparture(String Departure){
    this.departure=Departure;
    }


public String getDestnation(){
    return destnation;
    }
public void setDestnation(String Destnation){
    this.destnation=Destnation;
    }


public double getFare(){
    return fare;
    }
public void setFare(String Fare){
    this.fare=fare;
    }

//--------------------------    
       //method
//--------------------------

public String toString(){
    return "Flight No: "+flightNo+"     Departure: "+departure+"     Destination: "+destnation+"     Fare: "+fare;
    }
}
