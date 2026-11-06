/*
Marian Micleusanu
10/10/2026
*/

import java.sql.JDBCType;

import javax.swing.JOptionPane;

public class RepairShopApp {
    

    public static void main(String[] args){
        //variables
         // user input data
         String name;
        int serviceId;
        boolean isStudent;
        boolean expressServRequired;




        //objects
        RepairShop rs;
        rs = new RepairShop();



        do{
            // -------------------------- option #1 - create a quotation --------------------------------

            //get user's name
            do{
                name = JOptionPane.showInputDialog(null,"Enter your name:");

            }
            while(name == null || name.equals(""));

            rs.setName(name);





            //get repair service choice

            String response;

            do{
                response = JOptionPane.showInputDialog(null,"""
                Service number    Repair service        Base price
                1    Diagnostic check          €30
                2    Software installation     €45
                3    Virus removal             €60
                4    Screen replacement        €120

                Enter the service number:""");

                System.out.print(response);

            }
            while(!(response.equals("1") || response.equals("2") || response.equals("3") || response.equals("4")));

            rs.setServiceId(Integer.parseInt(response));



            //ask if customer is a student
            int resp;

            
            do{
                resp = JOptionPane.showConfirmDialog(null, "Are you a student?");

            }
            while(!( resp == JOptionPane.YES_OPTION || resp == JOptionPane.NO_OPTION ));

            rs.setIsStudent(resp == 0 ? true : false);



            //ask if express service is required            
            do{
                resp = JOptionPane.showConfirmDialog(null, "Is express service required?");

            }
            while(!( resp == JOptionPane.YES_OPTION || resp == JOptionPane.NO_OPTION ));

            rs.setExpressServiceRequired(resp == 0 ? true : false);

            // compute the quotation
            rs.computeQuotation();


            // display the quotation calculation result

            JOptionPane.showMessageDialog(null, rs.getSummary());

        }while(true);


    }





}
