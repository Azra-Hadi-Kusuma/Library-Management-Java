import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegistrationForm extends javax.swing.JFrame {

   
    private Connection con; 

public RegistrationForm() {
    initComponents();
    Connect();
}

public void Connect() {
    try {
        con = DatabaseConnection.connect();
        if (con != null) {
            System.out.println("Database connected successfully!");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Optional: Shows the full error trace in console
        JOptionPane.showMessageDialog(
            null, // changed from `this` in case this is not a JFrame
            "Database connection failed: " + e.getMessage(),
            "Connection Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
}

public void clearTextFields() {
    txtStudentID.setText("");
    txtFirstName.setText("");
    txtLastName.setText("");
    cbSex.setSelectedIndex(0);
    txtDateOfBirth.setText("");
    cbCivilStatus.setSelectedIndex(0);
    txtContactNumber.setText("");
    txtPermanentAddress.setText("");
    txtEmail.setText("");
    txtGuardian.setText("");
    cbProgramEnrolled.setSelectedIndex(0);
    txtYearLevel.setText("");
}

private void loadStudentRecords() {
    DefaultTableModel model = (DefaultTableModel) studentrecords.getModel();
    model.setRowCount(0);

    String query = "SELECT * FROM tbl_form";

    try {
        // Get a fresh connection using your DatabaseConnection class
        Connection con = DatabaseConnection.connect();

        // Prepare and execute query
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("sid"),
                rs.getString("fname"),
                rs.getString("lname"),
                rs.getString("sex"),
                rs.getDate("dob").toString(),  // Use getDate + toString() to prevent type mismatch
                rs.getString("cstatus"),
                rs.getString("cnumber"),
                rs.getString("paddress"),
                rs.getString("email"),
                rs.getString("guardian"),
                rs.getString("penrolled"),
                rs.getInt("ylevel")  // ylevel is INT, so getInt is fine
            });
        }

        rs.close();
        pst.close();
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();  // Make sure to always check this during dev!
        JOptionPane.showMessageDialog(null,
            "Error loading student records: " + ex.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
}







    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        txtDateOfBirth = new javax.swing.JTextField();
        lblCivilStatus = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        lblContactNumber = new javax.swing.JLabel();
        lblPEnrolled = new javax.swing.JLabel();
        txtYearLevel = new javax.swing.JTextField();
        lblYearLevel = new javax.swing.JLabel();
        lblGuardian = new javax.swing.JLabel();
        txtGuardian = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPermanentAddress = new javax.swing.JTextField();
        lblPAddress = new javax.swing.JLabel();
        cbSex = new javax.swing.JComboBox<>();
        cbCivilStatus = new javax.swing.JComboBox<>();
        cbProgramEnrolled = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentrecords = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(660, 46));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRATION FORM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        lblStudentID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStudentID.setText("Student ID");

        lblFirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFirstName.setText("First Name");

        lblLastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLastName.setText("Last Name");

        lblSex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSex.setText("Sex");

        lblDateOfBirth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDateOfBirth.setText("Date of Birth");

        lblCivilStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCivilStatus.setText("Civil Status");

        lblContactNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblContactNumber.setText("Contact Number");

        lblPEnrolled.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPEnrolled.setText("Program Enrolled");

        txtYearLevel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblYearLevel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblYearLevel.setText("Year Level");

        lblGuardian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGuardian.setText("Guardian");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        lblPAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPAddress.setText("Permanent Address");

        cbSex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        cbCivilStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCivilStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Menikah", "Sudah Menikah" }));

        cbProgramEnrolled.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbProgramEnrolled.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "program", "course", "membership", "service" }));

        studentrecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "First Name", "Last Name", "Sex", "Date of Birth", "Civil Status", "Contact Number", "Permanent Address", "Email", "Guardian", "Program Enrolled", "Year Level"
            }
        ));
        jScrollPane2.setViewportView(studentrecords);

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Update");

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStudentID)
                                .addGap(18, 18, 18)
                                .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFirstName)
                                .addGap(18, 18, 18)
                                .addComponent(txtFirstName))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCivilStatus)
                            .addGap(18, 18, 18)
                            .addComponent(cbCivilStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblDateOfBirth)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLastName)
                                .addComponent(lblSex))
                            .addGap(19, 19, 19)
                            .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPAddress)
                            .addComponent(lblContactNumber)
                            .addComponent(lblEmail)
                            .addComponent(lblGuardian)
                            .addComponent(lblYearLevel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPermanentAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGuardian, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtYearLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPEnrolled, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbProgramEnrolled, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudentID)
                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactNumber)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPAddress)
                    .addComponent(txtPermanentAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSex)
                    .addComponent(lblGuardian)
                    .addComponent(txtGuardian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateOfBirth)
                    .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPEnrolled)
                    .addComponent(cbProgramEnrolled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCivilStatus)
                    .addComponent(lblYearLevel)
                    .addComponent(txtYearLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    String studentId = txtStudentID.getText().trim();
    String firstName = txtFirstName.getText().trim();
    String lastName = txtLastName.getText().trim();
    String sex = cbSex.getSelectedItem().toString();
    String dateOfBirth = txtDateOfBirth.getText().trim();
    String civilStatus = cbCivilStatus.getSelectedItem().toString();
    String contactNumber = txtContactNumber.getText().trim();
    String permanentAddress = txtPermanentAddress.getText().trim();
    String email = txtEmail.getText().trim();
    String guardian = txtGuardian.getText().trim();
    String penrolled = cbProgramEnrolled.getSelectedItem().toString();
    String ylevel = txtYearLevel.getText().trim();

   
    if (studentId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || sex.isEmpty() || dateOfBirth.isEmpty() || civilStatus.isEmpty() ||
            contactNumber.isEmpty() || permanentAddress.isEmpty() || email.isEmpty() || guardian.isEmpty() || penrolled.isEmpty() || ylevel.isEmpty() ) {
        JOptionPane.showMessageDialog(this, "All fields must be filled.", "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

    if (!contactNumber.matches("^[0-9]*$")) {
        JOptionPane.showMessageDialog(this, "Contact number must be numeric.", "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

    if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        JOptionPane.showMessageDialog(this, "Invalid email format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

   
    try{
    String sql = "INSERT INTO tbl_form (sid, fname, lname, sex, dob, cstatus, cnumber, paddress, email, guardian, penrolled, ylevel ...) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ...)";
       
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, studentId);
    pst.setString(2, firstName);
    pst.setString(3, lastName);
    pst.setString(4, sex);
    pst.setDate(5, java.sql.Date.valueOf(dateOfBirth));
    pst.setString(6, civilStatus);
    pst.setString(7, contactNumber);
    pst.setString(8, permanentAddress);
    pst.setString(9, email);
    pst.setString(10, guardian);
    pst.setString(11, penrolled);
    pst.setInt(12, Integer.parseInt(ylevel));
    
    


    
        int affectedRows = pst.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearTextFields();
            loadStudentRecords();
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Invalid Date Format! Use 'YYYY-MM-DD'", "Validation Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
            try {
                LoginForm login = new LoginForm();
                login.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal membuka LoginForm: " + ex.getMessage(),
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btnCancelActionPerformed

   
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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCivilStatus;
    private javax.swing.JComboBox<String> cbProgramEnrolled;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCivilStatus;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGuardian;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPAddress;
    private javax.swing.JLabel lblPEnrolled;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblYearLevel;
    private javax.swing.JTable studentrecords;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGuardian;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPermanentAddress;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtYearLevel;
    // End of variables declaration//GEN-END:variables
}
