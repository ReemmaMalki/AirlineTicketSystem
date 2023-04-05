package AirlineTickets;

public class Airport {
    
//--------------------------    
      //data field
//--------------------------
    
    private String threeDigitCode;
    private String city;
    private String name;
    
//--------------------------    
      //constructur
//--------------------------
        
public Airport(String threeDigitCode,String city, String name){
    this.threeDigitCode=threeDigitCode;
    this.city=city;
    this.name=name;
    }   

//--------------------------    
    //setters and getters
//--------------------------

public String getThreeDigitCode(){
    return threeDigitCode;
    }
public void setThreeDigitCode(String ThreeDigitCode){
    this.threeDigitCode=ThreeDigitCode;
    }


public String getcity(){
    return city;
    }
public void setCity(String city){
    this.city=city;
    }


public String getName(){
    return name;
    }
public void setName(String name){
    this.name=name;
    }

//--------------------------    
      //method
//--------------------------

public String toString(){
    return "Airport Code: "+threeDigitCode+"     City: "+city+"     Name: "+name;
    }
}
