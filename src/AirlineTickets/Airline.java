package AirlineTickets;

public class Airline {
    
//--------------------------    
      //data field
//--------------------------
    private String towDigitsCode;
    private String name;
    private String originCounrty;
    private String website;
    
//--------------------------    
      //constructur
//--------------------------    
    
public Airline(String towDigitsCode,String name,String originCounrty,String website){
        this.towDigitsCode=towDigitsCode;
        this.name=name;
        this.originCounrty=originCounrty;
        this.website=website;
    }
 
//--------------------------    
    //setters and getters
//--------------------------
    
public String getTowDigitsCode(){
       return towDigitsCode;
    } 
public void setTowDigitsCode(String towDigitsCode){
    this.towDigitsCode=towDigitsCode;
    }


 public String getName(){
     return name;
    } 
 public void setName(String name){
     this.name=name;
    }
 
 
 public String getOriginCounrty(){
     return originCounrty;
    }
public void setOriginCounrty(String originCounrty){
    this.originCounrty=originCounrty;
    }  


public String getWebsite(){
    return website;
    }
public void setWebsite(String website){
    this.website=website;
    }

//--------------------------    
      //metod
//--------------------------

public String toString(){
    return "  Airline No.: "+towDigitsCode+"     Airline: "+name
            +"     Hub: "+originCounrty+"     URL: "+website;
    }

}
    


