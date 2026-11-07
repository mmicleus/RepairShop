/*
Marian Micleusanu
07/11/2026
*/
public class RepairShop {
   //variables
    // User Input
    private String name;
    private int serviceId;
    private boolean isStudent;
    private boolean expressServRequired;
    //computed values
    private double basePrice;
    private double discountAmount;
    // the double array storing the 5 quotations
    private double[] quotations;
    private double quotation;
    // the variable storing the number of quotations issued so far
    private int counter;
    // discount percentage
    private final int DISCOUNT = 10;
    private final double EXPRESS_SERVICE_CHARGE = 20;

    // constructor
    public RepairShop(){
        this.name = "";
        this.serviceId = 0;
        this.isStudent = false;
        this.expressServRequired = false;
        this.basePrice = 0.0;
        this.quotation = 0.0;
        this.discountAmount = 0.0;
        this.counter = 0;
        quotations = new double[5];
    }

    //set
    public void setName(String name){
        this.name = name;
    }

    public void setServiceId(int serviceId){
        this.serviceId = serviceId;
    }

    public void setIsStudent(boolean isStudent){
        this.isStudent = isStudent;
    }

    public void setExpressServiceRequired(boolean required){
        this.expressServRequired = required;
    }

    // get service name from service id
    private String getServiceName(){
        switch(serviceId){
            case 1:
                return "Diagnostic check";
            case 2:
                return "Software installation";
            case 3:
                return "Virus removal";
            case 4:
                return "Screen replacement";
            default:
                return "";
        }
    }
    // compute service price
    private void computeBasePrice(){
        switch(serviceId){
            case 1:
                basePrice =  30;
            break;
            case 2:
                basePrice =  45;
            break;
            case 3:
                basePrice = 60;
            break;
            case 4:
                basePrice =  120;
            break;
            default:
                basePrice =  0;
            break;
        }
    }
// compute student discount based on base price computed earlier
    private void computeDiscountAmount(){
        if(isStudent){
            discountAmount = basePrice / DISCOUNT;
        }else{
            discountAmount = 0;
        }
    }

    //compute single quotation 
    public void computeQuotation(){
        computeBasePrice();
        computeDiscountAmount();
        quotation = basePrice - discountAmount + (expressServRequired ? EXPRESS_SERVICE_CHARGE : 0);
        // record quotation in the 'quotations' array and increment the counter
        quotations[counter] = quotation;
        counter += 1;
    }
    // returns the sum of all quotations in the array
    private double getTotal(){
        double sum = 0;
        for(int i = 0;i < counter;i++){
            sum += quotations[i];
        }
        return sum;
    }
    //returns the highest quotation in the array
    private double getHighestQuotation(){
        double max = quotations[0];
        for(int i = 1;i < counter;i++){
            max = Math.max(max,quotations[i]);
        }
        return max;
    }
    // get
    public int getCounter(){
        return counter;
    }
     // get summary of single quotation (menu option #1)
    public String getSummary(){   
        String result = "Customer: " + name + 
        "; Service: " + getServiceName() + 
        "; Base price: " + "€" + String.format("%.2f",basePrice) + 
        "; Discount: " + "€" + String.format("%.2f",discountAmount) + 
        "; Express charge: "+"€" + (expressServRequired ? String.format("%.2f",EXPRESS_SERVICE_CHARGE) : String.format("%.2f",0.0)) + 
        "; Final total: " + "€" + String.format("%.2f",quotation);
        return result;
    }
    //get summary of all quotations issued so far (menu option #2)
    public String getQuotationTotals(){
        if (counter == 0){
            return "No quotations have been issued yet!";
        }
        double total = getTotal();
        double highest = getHighestQuotation();
        double averageQuotation = total / counter;
        String result = "";
        for(int i = 0;i < counter;i++){
            result += "Quotation " + (i+1) + ":" + "€" + String.format("%.2f",quotations[i]) + ";";
        }
        return result + "Number Of Quotations: " + counter + ";Combined value: " + "€" + String.format("%.2f", total) + 
                ";Highest: " + "€" + String.format("%.2f", highest) + 
                ";Average:" + "€" + String.format("%.2f", averageQuotation);
    }



   

    

}
