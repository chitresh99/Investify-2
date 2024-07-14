package introductory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class AsssetManagement extends javax.swing.JFrame {

    private final String url = "jdbc:mysql://localhost:3306/investify";
    private final String username = "root";
    private final String password = "CHIR2502004|";

    private Connection connection = null;

    public AsssetManagement() {
        initComponents();
        establishconnection();
        
         // Set the options for the propertycombobox to "Profit" and "Loss"
        propertycombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Profit", "Loss"}));
        stockcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Profit", "Loss"}));
        cashcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Positive", "Negative", "Neutral"}));
        otherassetscombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Profit ", "Loss", "Neutral"}));
    }

    private void establishconnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to make connection to the database.");
            e.printStackTrace();
        }
    }

    private void savetodatabase() {
        
        //mysql query for inserting data into the database
        String insertQuery = "INSERT INTO assetmanagment (assetid, property_state, stock_state, cash_state, other_asset_state, property_bought_at, current_valuation, stock_bought_at, current_price, current_amount, flow_at_this_date, sum_invested, expected_return, stock_name, date_of_return, name_of_investment, amount_invested) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery); // Creating a prepared statement for the my sql query to insert data into the database
            preparedStatement.setString(1, assetid.getText()); //// Set the first parameter (basically a input )my sql statement as the text obtained from the 'assetid' field
            preparedStatement.setString(2, (String) propertycombobox.getSelectedItem());
            preparedStatement.setString(3, (String) stockcombobox.getSelectedItem());
            preparedStatement.setString(4, (String) cashcombobox.getSelectedItem());
            preparedStatement.setString(5, (String) otherassetscombobox.getSelectedItem());
            preparedStatement.setString(6, boughtat.getText());
            preparedStatement.setString(7, currentvaluation.getText());
            preparedStatement.setString(8, boughtat2.getText());
            preparedStatement.setString(9, currentprice.getText());
            preparedStatement.setString(10, currentamt.getText());
            preparedStatement.setString(11, flowatthisdate.getText());
            preparedStatement.setString(12, suminvested.getText());
            preparedStatement.setString(13, expectedreturn.getText());
            preparedStatement.setString(14, stockname.getText());
            preparedStatement.setString(15, dateofreturn.getText());
            preparedStatement.setString(16, nameofinvestment.getText());
            preparedStatement.setString(17, amountinvested.getText());
            
            
            // Check if the database operation was successful and provide appropriate feedback to the user the block of code below
     
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) { //checks the number of rows affected is greater than 0 like when we insterted even if for one row if it was succesful or not 
                System.out.println("Data saved to database successfully.");
                JOptionPane.showMessageDialog(this, "Asset data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to save data to the database."); //if we fail to insert it

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        boughtat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        currentvaluation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        propertycombobox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        boughtat2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        currentprice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        stockcombobox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        currentamt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        flowatthisdate = new javax.swing.JTextField();
        cashcombobox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        suminvested = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        expectedreturn = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        stockname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        dateofreturn = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        nameofinvestment = new javax.swing.JTextField();
        amountinvested = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        otherassetscombobox = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        print = new javax.swing.JButton();
        back = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        assetid = new javax.swing.JTextField();
        searchbar = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setLocation(new java.awt.Point(550, 50));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 50, 139));

        jLabel1.setFont(new java.awt.Font("Adobe Clean ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ASSET MANAGMENT ");

        jLabel2.setFont(new java.awt.Font("Adobe Clean ExtraBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVESTIFY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Adobe Clean ExtraBold", 0, 18)); // NOI18N
        jLabel3.setText("Properties");

        boughtat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boughtatActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel4.setText("Bought at");

        jLabel5.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel5.setText("Current Valuation");

        currentvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentvaluationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel6.setText("Current State");

        propertycombobox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        propertycombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Profit", "Loss", " ", " " }));

        jLabel7.setFont(new java.awt.Font("Adobe Clean Black", 0, 18)); // NOI18N
        jLabel7.setText("Stocks / Equity");

        jLabel8.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel8.setText("Bought At");

        jLabel9.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel9.setText("Current Price ");

        currentprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentpriceActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel10.setText("Current State");

        stockcombobox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        stockcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Profit", "Loss" }));

        jLabel11.setFont(new java.awt.Font("Adobe Clean ExtraBold", 0, 18)); // NOI18N
        jLabel11.setText("CASH AND CASH EQUIVALENTS");

        jLabel12.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel12.setText("Current Amt");

        currentamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentamtActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel13.setText("Flow at this date");

        cashcombobox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cashcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Positive", "Negative", "Neutral" }));

        jLabel14.setFont(new java.awt.Font("Adobe Clean ExtraBold", 0, 18)); // NOI18N
        jLabel14.setText("Bonds and Equivalent ");

        jLabel15.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel15.setText("Sum Invested ");

        jLabel16.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel16.setText("Expected Return ");

        jLabel17.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel17.setText("Stock Name");

        stockname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocknameActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel18.setText("Date of return");

        dateofreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateofreturnActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Adobe Clean Black", 0, 18)); // NOI18N
        jLabel19.setText("Other assets ");

        jLabel20.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel20.setText("Name of investment");

        nameofinvestment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameofinvestmentActionPerformed(evt);
            }
        });

        amountinvested.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        amountinvested.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountinvestedActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel21.setText("Amount Invested ");

        otherassetscombobox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        otherassetscombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Profit ", "Loss", "Neutral" }));

        jLabel22.setFont(new java.awt.Font("Zuume", 0, 18)); // NOI18N
        jLabel22.setText("Current State");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        print.setText("Print ");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Asset Id");

        assetid.setText(" ");

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setText("Amount transferred");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boughtat)
                                        .addComponent(jLabel4))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(currentvaluation)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stockname))
                                    .addGap(46, 46, 46)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(boughtat2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(currentamt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(flowatthisdate)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(nameofinvestment, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(save))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(update)
                                    .addComponent(jLabel21)
                                    .addComponent(amountinvested, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(suminvested, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(expectedreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(otherassetscombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(delete)
                                        .addGap(60, 60, 60)
                                        .addComponent(print)
                                        .addGap(68, 68, 68)))
                                .addComponent(back))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(54, 54, 54))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(dateofreturn, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(propertycombobox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addComponent(currentprice, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(24, 24, 24)))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(24, 24, 24)
                                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(cashcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(stockcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assetid, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(assetid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boughtat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentvaluation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(propertycombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boughtat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flowatthisdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cashcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suminvested, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expectedreturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateofreturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameofinvestment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(otherassetscombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(amountinvested, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(delete)
                    .addComponent(print)
                    .addComponent(back)
                    .addComponent(update))
                .addContainerGap())
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boughtatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boughtatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boughtatActionPerformed

    private void currentvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentvaluationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentvaluationActionPerformed

    private void stocknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stocknameActionPerformed

    private void nameofinvestmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameofinvestmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameofinvestmentActionPerformed

    private void amountinvestedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountinvestedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountinvestedActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        homepage homepageFrame = new homepage();

        // Set the login frame to be visible
        homepageFrame.setVisible(true);

        // Close the current introductory frame
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void currentpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentpriceActionPerformed

    private void currentamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentamtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentamtActionPerformed

    private void dateofreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateofreturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateofreturnActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        String selectedPropertyState = (String) propertycombobox.getSelectedItem(); //Get selected values from the combo boxes and text fields
        String selectedStockState = (String) stockcombobox.getSelectedItem();
        String selectedCashState = (String) cashcombobox.getSelectedItem();
        String selectedOtherAssetState = (String) otherassetscombobox.getSelectedItem();

        String propertyBoughtAt = boughtat.getText();
        String currentValuation = currentvaluation.getText();
        String stockBoughtAt = boughtat2.getText();
        String currentPrice = currentprice.getText();
        String currentAmount = currentamt.getText();
        String flowAtThisDate = flowatthisdate.getText();
        String sumInvested = suminvested.getText();
        String expectedReturn = expectedreturn.getText();
        String stockName = stockname.getText();
        String dateOfReturn = dateofreturn.getText();
        String nameOfInvestment = nameofinvestment.getText();
        String amountInvested = amountinvested.getText();

        // Creating PDF document
        Document document = new Document();

        String desktopPath = System.getProperty("user.home") + "/Desktop/"; //the file path for the pdf document
        String filePath = desktopPath + "assets.pdf"; //name of the pdf

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            
            document.add(new Paragraph("Selected Property State: " + selectedPropertyState)); // Add the selected values to the PDF
            document.add(new Paragraph("Selected Stock State: " + selectedStockState));
            document.add(new Paragraph("Selected Cash State: " + selectedCashState));
            document.add(new Paragraph("Selected Other Asset State: " + selectedOtherAssetState));

            
            document.add(new Paragraph("Property Bought At: " + propertyBoughtAt)); // Add the text field values to the PDF
            document.add(new Paragraph("Current Valuation: " + currentValuation));
            document.add(new Paragraph("Stock Bought At: " + stockBoughtAt));
            document.add(new Paragraph("Current Price: " + currentPrice));
            document.add(new Paragraph("Current Amount: " + currentAmount));
            document.add(new Paragraph("Flow At This Date: " + flowAtThisDate));
            document.add(new Paragraph("Sum Invested: " + sumInvested));
            document.add(new Paragraph("Expected Return: " + expectedReturn));
            document.add(new Paragraph("Stock Name: " + stockName));
            document.add(new Paragraph("Date Of Return: " + dateOfReturn));
            document.add(new Paragraph("Name Of Investment: " + nameOfInvestment));
            document.add(new Paragraph("Amount Invested: " + amountInvested));

            document.close();

            // Show a success message
            JOptionPane.showMessageDialog(this, "PDF generated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_printActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String deleteQuery = "DELETE FROM assetmanagment WHERE assetid = ?"; //my sql queery for deleting a row or data in our featues case
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery); //Creating a prepared statement for the delete query
            preparedStatement.setString(1, searchbar.getText()); // Setting the asset id to be deleted as a parameter in the prepared statement

            int rowsAffected = preparedStatement.executeUpdate(); //Executing the delete operation and getting the number of rows affected
            if (rowsAffected > 0) { //Checking if the data was deleted successfully 
                System.out.println("Data deleted from the database successfully."); //message 
                JOptionPane.showMessageDialog(this, "Asset data deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearfields(); //clear field function getting called here which will clear the fields once the data is deleted
            } else {
                System.out.println("Failed to delete data from the database.");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        savetodatabase(); //call the function to save the data
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String updateQuery = "UPDATE assetmanagment SET property_state = ?, stock_state = ?, cash_state = ?, other_asset_state = ?, property_bought_at = ?, current_valuation = ?, stock_bought_at = ?, current_price = ?, current_amount = ?, flow_at_this_date = ?, sum_invested = ?, expected_return = ?, stock_name = ?, date_of_return = ?, name_of_investment = ?, amount_invested = ? WHERE assetid = ?";
        //update query above
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, (String) propertycombobox.getSelectedItem()); //setstring helps us to place right data into the right spot
            preparedStatement.setString(2, (String) stockcombobox.getSelectedItem());
            preparedStatement.setString(3, (String) cashcombobox.getSelectedItem());
            preparedStatement.setString(4, (String) otherassetscombobox.getSelectedItem());
            preparedStatement.setString(5, boughtat.getText());
            preparedStatement.setString(6, currentvaluation.getText());
            preparedStatement.setString(7, boughtat2.getText());
            preparedStatement.setString(8, currentprice.getText());
            preparedStatement.setString(9, currentamt.getText());
            preparedStatement.setString(10, flowatthisdate.getText());
            preparedStatement.setString(11, suminvested.getText());
            preparedStatement.setString(12, expectedreturn.getText());
            preparedStatement.setString(13, stockname.getText());
            preparedStatement.setString(14, dateofreturn.getText());
            preparedStatement.setString(15, nameofinvestment.getText());
            preparedStatement.setString(16, amountinvested.getText());
            preparedStatement.setString(17, searchbar.getText());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data updated in the database successfully.");
                JOptionPane.showMessageDialog(this, "Asset data updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to update data in the database.");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String searchAssetId = searchbar.getText(); //Retrieve the asset id from the search bar

        String selectQuery = "SELECT * FROM assetmanagment WHERE assetid = ?"; //it is a select query from the database which helps us search it will look for a particular column like its name here
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, searchAssetId); 
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { // check if any results were found

                assetid.setText(resultSet.getString("assetid")); 
                propertycombobox.setSelectedItem(resultSet.getString("property_state"));
                stockcombobox.setSelectedItem(resultSet.getString("stock_state"));
                cashcombobox.setSelectedItem(resultSet.getString("cash_state"));
                otherassetscombobox.setSelectedItem(resultSet.getString("other_asset_state"));
                boughtat.setText(resultSet.getString("property_bought_at"));
                currentvaluation.setText(resultSet.getString("current_valuation"));
                boughtat2.setText(resultSet.getString("stock_bought_at"));
                currentprice.setText(resultSet.getString("current_price"));
                currentamt.setText(resultSet.getString("current_amount"));
                flowatthisdate.setText(resultSet.getString("flow_at_this_date"));
                suminvested.setText(resultSet.getString("sum_invested"));
                expectedreturn.setText(resultSet.getString("expected_return"));
                stockname.setText(resultSet.getString("stock_name"));
                dateofreturn.setText(resultSet.getString("date_of_return"));
                nameofinvestment.setText(resultSet.getString("name_of_investment"));
                amountinvested.setText(resultSet.getString("amount_invested"));
            } else {
                JOptionPane.showMessageDialog(this, "Asset not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(AsssetManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsssetManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsssetManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsssetManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsssetManagement().setVisible(true);
            }
        });
    }

    private void clearfields() {

        assetid.setText(""); //sets all the fields to blank
        boughtat.setText("");
        currentvaluation.setText("");
        boughtat2.setText("");
        currentprice.setText("");
        currentamt.setText("");
        flowatthisdate.setText("");
        suminvested.setText("");
        expectedreturn.setText("");
        stockname.setText("");
        dateofreturn.setText("");
        nameofinvestment.setText("");
        amountinvested.setText("");

        propertycombobox.setSelectedIndex(0);
        stockcombobox.setSelectedIndex(0);
        cashcombobox.setSelectedIndex(0);
        otherassetscombobox.setSelectedIndex(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountinvested;
    private javax.swing.JTextField assetid;
    private javax.swing.JButton back;
    private javax.swing.JTextField boughtat;
    private javax.swing.JTextField boughtat2;
    private javax.swing.JComboBox<String> cashcombobox;
    private javax.swing.JTextField currentamt;
    private javax.swing.JTextField currentprice;
    private javax.swing.JTextField currentvaluation;
    private javax.swing.JTextField dateofreturn;
    private javax.swing.JButton delete;
    private javax.swing.JTextField expectedreturn;
    private javax.swing.JTextField flowatthisdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameofinvestment;
    private javax.swing.JComboBox<String> otherassetscombobox;
    private javax.swing.JButton print;
    private javax.swing.JComboBox<String> propertycombobox;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchbar;
    private javax.swing.JComboBox<String> stockcombobox;
    private javax.swing.JTextField stockname;
    private javax.swing.JTextField suminvested;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
