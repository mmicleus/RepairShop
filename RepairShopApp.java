/*
Marian Micleusanu
07/11/2026
*/
import javax.swing.JOptionPane;

public class RepairShopApp {
    public static void main(String[] args) {
        // variables
        String name;
        boolean stop = false;
        final int MAX_QUOTE_COUNT = 5;
        String response;

        // objects
        RepairShop rs;
        rs = new RepairShop();

        do {
            // show main menu
            // if limit of 5 quotations not exceeded
            if (rs.getCounter() < MAX_QUOTE_COUNT) {

                // show first menu option

                do {
                    response = JOptionPane.showInputDialog(null, """
                            Option    Function
                            1    Create a quotation
                            2    View quotation totals and summary
                            3    Exit

                            Enter your option:""");
                } while (response == null || !(response.equals("1") || response.equals("2") || response.equals("3")));

            }
            else{
                // when user reached the limit of 5 quotations
                JOptionPane.showMessageDialog(null,
                        "You have reached the limit of 5 quotations. No more quotations allowed!");
                // show second menu option
                do {
                    response = JOptionPane.showInputDialog(null, """
                            Option    Function

                            2    View quotation totals and summary
                            3    Exit

                            Enter your option:""");
                } 
                while(response == null || !(response.equals("2") || response.equals("3")));
            }

            if (response.equals("1")) {
                // option #1 - create a quotation
                // get user's name
                //keep iterating until user provides valid input
                do{
                    name = JOptionPane.showInputDialog(null, "Enter your name:");
                }
                while(name == null || name.equals(""));
                rs.setName(name);

                // get repair service choice
                do {
                    // show menu
                    response = JOptionPane.showInputDialog(null, """
                            Service number    Repair service        Base price
                            1    Diagnostic check          €30
                            2    Software installation     €45
                            3    Virus removal             €60
                            4    Screen replacement        €120

                            Enter the service number:""");
                } while (!(response.equals("1") || response.equals("2") || response.equals("3")
                        || response.equals("4")));
                rs.setServiceId(Integer.parseInt(response));

                // ask if customer is a student
                int resp;
                do {
                    resp = JOptionPane.showConfirmDialog(null, "Are you a student?");
                }
                while(!(resp == JOptionPane.YES_OPTION || resp == JOptionPane.NO_OPTION));
                rs.setIsStudent(resp == 0 ? true : false);

                // ask if express service is required
                do {
                    resp = JOptionPane.showConfirmDialog(null, "Is express service required?");
                } while (!(resp == JOptionPane.YES_OPTION || resp == JOptionPane.NO_OPTION));
                rs.setExpressServiceRequired(resp == 0 ? true : false);
                // compute the quotation
                rs.computeQuotation();
                // display the quotation calculation result
                JOptionPane.showMessageDialog(null, rs.getSummary());
            }
            else if(response.equals("2")) {
                JOptionPane.showMessageDialog(null, rs.getQuotationTotals());
            }
            else{
                JOptionPane.showMessageDialog(null, "Goodbye!");
                stop = true;
            }

        }
        while(!stop);

        // closing the program
        System.exit(0);

    }

}
