package introductory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class AccountHandling extends javax.swing.JFrame {

    Connection con = null;  // Initializing a connection variable as null (connection helps in the connection of mysql database)
    Statement st = null;    //Initializing a statement variable as null. (statement helps us to execute mysql queries)
    PreparedStatement pst = null; //Initializing a prepared statement variable as null. (prepared statements is to hold values for place holders)
    ResultSet rs = null;  // Initializing a result set variable as null (null means no value). (result set helps to retrieve values from the database)

    
    /**
     * Creates new form AccountHandling
     */
    public AccountHandling() {
        initComponents();
        jTextArea1.setEditable(false); // Setting the text area as non-editable
        connecttodatabase(); //Connecting to the database
        loaddatatotextarea();// Loading data to the text area from the database

    }

    private void connecttodatabase() {   // Method to establish a connection with the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Loading the JDBC driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/investify", "root", "CHIR2502004|"); //stablishing the connection to the MySQL database
            System.out.println("Database connection successful!"); // Printing a success message upon successful connection
        } catch (ClassNotFoundException | SQLException e) { // Printing the stack trace if an exception occurs
            e.printStackTrace();
        }
    }
    
    
    private void loaddatatotextarea() {  // Method to load data from the database to the text area
        try { // it is a query to select all data from the accounthanlding table
            String query = "SELECT * FROM accounthandling"; //Creating a prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query); 
            ResultSet rs = preparedStatement.executeQuery();
            StringBuilder sb = new StringBuilder(); // Creating a stringbuilder object what is string builder ? helps build and modify text easily. 
            
            //sb is object name sb.append adds text to the container i mean its like putting pieces of text together to create a longer piece of text
            while (rs.next()) { // we use while (rs.next()) to go through each row of the database 
                sb.append("Account Name: ").append(rs.getString("accountname")).append("\n");  //append("\n") --> starting a new line on a next sentence   
                sb.append("Account Balance: ").append(rs.getDouble("accountbalance")).append("\n");
                sb.append("Last Transaction: ").append(rs.getString("lasttransaction")).append("\n\n");
                //get string gets the value from the current row database 
            }

            jTextArea1.setText(sb.toString()); // displays the complete text we created earlier in the StringBuilder on the screen in the jTextArea1 box.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        accountname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        accountbalance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lasttransaction = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addaccount = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        clear = new javax.swing.JButton();
        back = new javax.swing.JButton();
        transactionhistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 50, 139));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Adobe Clean ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Account Handling");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Adobe Clean ExtraBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVESTIFY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(208, 208, 208)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Account Name :");

        accountname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountnameActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Account Balance :");

        accountbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountbalanceActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Last transaction :");

        lasttransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lasttransactionActionPerformed(evt);
            }
        });

        addaccount.setText("Add account");
        addaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addaccountActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        transactionhistory.setText("Clear Transaction history");
        transactionhistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionhistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addaccount)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountname)
                            .addComponent(accountbalance)
                            .addComponent(lasttransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transactionhistory))
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(back)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(accountbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lasttransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addaccount))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(transactionhistory)
                .addGap(31, 31, 31)
                .addComponent(back)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountnameActionPerformed

    private void lasttransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lasttransactionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lasttransactionActionPerformed

    private void accountbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountbalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountbalanceActionPerformed

    private void addaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addaccountActionPerformed
        // TODO add your handling code here:
        
        String accountName = accountname.getText(); // Extract the account name from the accountname text field
        double accountBalance = Double.parseDouble(accountbalance.getText()); // Extract the account balance from the accountbalance text field and convert it to a double
        String lastTransaction = lasttransaction.getText(); 

        addNoteToDatabase(accountName, accountBalance, lastTransaction); //helps adding the provided info to the database
        displayNoteInPanel(accountName, accountBalance, lastTransaction); //helps to display everything on the panel in this case textarea
    }//GEN-LAST:event_addaccountActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        accountname.setText("");
        accountbalance.setText("");
        lasttransaction.setText(""); //clear the fields sets the text field to blank
    }//GEN-LAST:event_clearActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        homepage homepageFrame = new homepage();

        // Set the login frame to be visible
        homepageFrame.setVisible(true);

        // Close the current introductory frame
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void transactionhistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionhistoryActionPerformed
        jTextArea1.setText(""); //sets the text area to blank without deleteing the data from the database just clears the field
    }//GEN-LAST:event_transactionhistoryActionPerformed

    private void addNoteToDatabase(String accountName, double accountBalance, String lastTransaction) {
        try {
            String query = "INSERT INTO accounthandling (accountname, accountbalance, lasttransaction) VALUES (?, ?, ?)"; //SQL query to insert the account details into the 'accounthandling' table
            PreparedStatement preparedStatement = con.prepareStatement(query); //Creating a prepared statement for the SQL query
            preparedStatement.setString(1, accountName);  // Setting the first '?' in the query as the provided account name
            preparedStatement.setDouble(2, accountBalance);  // Executing the SQL update statement to add the new account to the database
            preparedStatement.setString(3, lastTransaction);
            preparedStatement.executeUpdate(); // Executing the sql update statement to add the new account to the database
            System.out.println("Note added to the database!"); //Printing a message to indicate that the note has been successfully added to the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountHandling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountHandling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountHandling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountHandling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountHandling().setVisible(true);
            }
        });
    }

    private void displayNoteInPanel(String accountName, double accountBalance, String lastTransaction) {
        String note = "Account Name: " + accountName + "\n" //Creates a string containing the account details with appropriate labels and line breaks
                + "Account Balance: " + accountBalance + "\n" 
                + "Last Transaction: " + lastTransaction + "\n\n";

        jTextArea1.append(note);  //Add the formatted account details to the 'jTextArea1' component
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountbalance;
    private javax.swing.JTextField accountname;
    private javax.swing.JButton addaccount;
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField lasttransaction;
    private javax.swing.JButton transactionhistory;
    // End of variables declaration//GEN-END:variables
}
