public class Conpany {

    private String companyName;
    private String startDate;
    private String bulstat;
    
    public Conpany(){
        this.companyName="";
        this.startDate="";
        this.bulstat="";
    }

    public Conpany(String companyName, String startDate, String bulstat){
        this.companyName = companyName;
        this.startDate = startDate;
        this.bulstat=bulstat;
    }

    

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStartDate(){
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getBulstat() {
        return bulstat;
    }

    public void setBulstat(String bulstat) {
        if(bulstat.length()==10 && bulstat != null){
            this.bulstat=bulstat;
        }
        else{
            System.err.println("It has to be 10 simbols.");
        }
    }
}

class Firm extends Conpany {
    private String owner;
    private double startSum;
    private double SumNow;

    public Firm(){
        this.owner="";
        this.startSum=0.0;
        this.SumNow=0.0;
    }

    public Firm(String companyName, String startDate, String bulstat, String owner, double startSum, double SumNow){
        super(companyName, startDate, bulstat);
        this.owner=owner;
        this.startSum=startSum;
        this.SumNow=SumNow;
    }

    public String getOwner(){
        return owner;
    }

    public void setOwner(String owner){
        this.owner=owner;
    }

    public double getStartSum(){
        return startSum;
    }

    public void setStartSum(double startSum){
        this.startSum=startSum;
    }

    public double getSumNow(){
        return SumNow;
    }

    public void setSumNow(double SumNow){
        this.SumNow=SumNow;
        }

    public double Profit(){
        return this.SumNow - this.startSum; 
    }
}
