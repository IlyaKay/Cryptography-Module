
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author Ilya
 */
public class CreditCardAndBCH extends javax.swing.JFrame {

    public CreditCardAndBCH() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("verify isbn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("verify credit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("BCH(10,6) encode");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("BCH(10,6) decode");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("BCH(16,12) encode");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("BCH(16,12) decode");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // isbn code (unmarked)
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int[] d = new int[10];
            String s = jTextField1.getText();

            for (int i = 0; i < d.length; i++) {
                if ("-".equals(String.valueOf(s.charAt(i)))) {
                    d[i] = 0;
                } else {
                    d[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
                }
            }

            if ((d[0]+2*d[1]+3*d[2]+4*d[3]+5*d[4]+6*d[5]+7*d[6]+8*d[7]+9*d[8]+10*d[9]) % 11 == 0){
                jTextArea1.setText("This is a valid ISBN number.");
            } else {
                jTextArea1.setText("This is not a valid ISBN number.");
            }
        } catch(NumberFormatException e) { //if input not a number return invalid
            jTextArea1.setText("This is an invalid ISBN number.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    // clear text fields
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextArea1.setText("");                              
        jTextField1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    // credit card code
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int[] d = new int[16];
            int sum = 0;
            String in = jTextField1.getText();
            // remove accidental white space
            in = in.replaceAll(" ","");
            
            // iterate through input
            for (int i = 0; i < in.length(); i++) {
                d[i] = Integer.parseInt(String.valueOf(in.charAt(i)));
                // double every other number
                if ((i % 2) == 0){
                    d[i] = d[i]*2;
                    if (d[i]>9){
                        d[i] = d[i]-9;
                    }
                }
            }
            
            // total numbers
            for (int i = 0; i < in.length(); i++) {
                sum += d[i];
            }

            // if divisible by 10 then valid
            if ((sum % 10) == 0){
                jTextArea1.setText("This is a valid credit card number.");
            } else {
                jTextArea1.setText("This is not a valid credit card number.\nSum:" + sum);
            }
        } catch(NumberFormatException e) { //if input not a number return invalid
            jTextArea1.setText("This is an invalid credit card number.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // BCH(10,6) encoder
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int[] d = new int[10];
            String in = jTextField1.getText();
            // remove accidental white space
            in = in.replaceAll(" ","");
            
            // pull every character into an array
            for (int i=0; i < 6; i++) 
                d[i] = Integer.parseInt(String.valueOf(in.charAt(i)));

            // encode last 4 digits using given generator matrix
            d[6]=(4*d[0]+10*d[1]+9*d[2]+2*d[3]+d[4]+7*d[5]) %11;
            d[7]=(7*d[0]+8*d[1]+7*d[2]+d[3]+9*d[4]+6*d[5]) %11;
            d[8]=(9*d[0]+d[1]+7*d[2]+8*d[3]+7*d[4]+7*d[5]) %11;
            d[9]=(d[0]+2*d[1]+9*d[2]+10*d[3]+4*d[4]+d[5]) %11;
            
            // if value is multiple digits long then inform user
            if (d[6]==10||d[7]==10||d[8]==10||d[9]==10){
                jTextArea1.setText("Error code: d7-d10=10.");
            } else {
                String output = Arrays.toString(d);
                output = output.replaceAll("[^0-9]","");
                jTextArea1.setText(output);
            }
        } catch(NumberFormatException e) { // if input not a number return invalid
            jTextArea1.setText("Unusable input.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // BCH(10,6) decoder
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            int[] d = new int[10];
            int[] s = new int[4];
            // input should be in format 10 numbers
            String in = jTextField1.getText();
            // remove accidental white space
            in = in.replaceAll(" ","");
            
            // pull every character into an array
            for (int i=0; i < in.length(); i++) 
                d[i] = Integer.parseInt(String.valueOf(in.charAt(i)));

            // acquire syndrome values from given vandermonde matrix
            s[0] = (d[0]+d[1]+d[2]+d[3]+d[4]+d[5]+d[6]+d[7]+d[8]+d[9]) % 11;
            s[1] = (d[0]+2*d[1]+3*d[2]+4*d[3]+5*d[4]+6*d[5]+7*d[6]+8*d[7]+9*d[8]+10*d[9]) % 11;
            s[2] = (d[0]+4*d[1]+9*d[2]+5*d[3]+3*d[4]+3*d[5]+5*d[6]+9*d[7]+4*d[8]+d[9]) % 11;
            s[3] = (d[0]+8*d[1]+5*d[2]+9*d[3]+4*d[4]+7*d[5]+2*d[6]+6*d[7]+3*d[8]+10*d[9]) % 11;
            
            // calculate PQR values for error correction
            int P = subMod(s[1]*s[1],s[0]*s[2],11);
            int Q = subMod(s[0]*s[3],s[1]*s[2],11);
            int R = subMod(s[2]*s[2],s[1]*s[3],11);
            
            // begin error correction
            if (s[0]==0&&s[1]==0&&s[2]==0&&s[3]==0){ // no errors
                jTextArea1.setText("No error.");
            } else if (P==0&&Q==0&&R==0){ // single error correction
                try {
                    int i = divMod(s[1],s[0],11); // position
                    int a = s[0]; // magnitude
                    if(i==0) {
                        jTextArea1.setText("Error Code: i=0.");
                        return;
                    } if(i==-1) {
                        jTextArea1.setText("Error Code: i=-1.");
                        return;
                    }

                    // error correction
                    d[i-1] = (d[i-1] - a);
                    if(d[i-1] < 0) d[i-1]= d[i-1] + 11;
                    if(d[i-1] == 10) {
                        jTextArea1.setText("Error Code: Correcting to 10.");
                        return;
                    }

                    // output
                    String output = Arrays.toString(d);
                    output = output.replaceAll("[^0-9]","");
                    jTextArea1.setText("Single error corrected.\n" + output);
                } catch(Exception e) {
                    jTextArea1.setText("Error Code: Error single.");
                }
            } else { // double error correction
                try {
                    int tempSqrt = sqrtMod11(subMod((int) Math.pow(Q,2),4*P*R,11));
                    if(tempSqrt < 0) {
                        jTextArea1.setText("Error Code: No sqrt root.");
                        return;
                    }
                    // error positions
                    int i = divMod(-Q + tempSqrt,2*P,11);
                    int j = divMod(-Q - tempSqrt,2*P,11);
                    if(i==0||j==0) {
                        jTextArea1.setText("Error Code: i/j=0.");
                        return;
                    } if(i==-1||j==-1) {
                        jTextArea1.setText("Error Code: i/j=-1.");
                        return;
                    }
                    // error magnitudes
                    int b = divMod(subMod(i*s[0],s[1],11),i-j,11);
                    int a = subMod(s[0],b,11);
                    
                    // error correction
                    d[i-1] = (d[i-1] - a);
                    if(d[i-1] < 0) d[i-1]= d[i-1] + 11;
                    d[j-1] = (d[j-1] - b);
                    if(d[j-1] < 0) d[j-1]= d[j-1] + 11;
                    if(d[i-1] == 10 || d[j-1] == 10) {
                        jTextArea1.setText("Error Code: Correcting to 10.");
                        return;
                    }
                    
                    // output
//                    System.out.println(i+" "+a+" "+j+" "+b);
//                    System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" P"+P+" Q"+Q+" R"+R);
                    String output = Arrays.toString(d);
                    output = output.replaceAll("[^0-9]","");
                    jTextArea1.setText("Double error corrected.\n" + output);
                } catch(Exception e) {
                    jTextArea1.setText("Error Code: Error double.");
                }
            }
        } catch(Exception e) { // if input not a number return invalid
            jTextArea1.setText("Error Code: Unusable input.");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    // BCH(16,12) decoder
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            String[] strNums;
            int[] d = new int[16];
            int[] s = new int[4];
            // input should be in format num1, num2, num3
            String in = jTextField1.getText();
            strNums = in.split(", ");
            
            // pull every character into an array
            for (int i=0; i < strNums.length; i++)
                d[i] = Integer.parseInt(String.valueOf(strNums[i]));

            // acquire syndrome values from given vandermonde matrix
            s[0] = (d[0]+d[1]+d[2]+d[3]+d[4]+d[5]+d[6]+d[7]+d[8]+d[9]+d[10]+d[11]+d[12]+d[13]+d[14]+d[15]) % 17;
            s[1] = (d[0]+2*d[1]+3*d[2]+4*d[3]+5*d[4]+6*d[5]+7*d[6]+8*d[7]+9*d[8]+10*d[9]+11*d[10]+12*d[11]+13*d[12]+14*d[13]+15*d[14]+16*d[15]) % 17;
            s[2] = (d[0]+4*d[1]+9*d[2]+16*d[3]+8*d[4]+2*d[5]+15*d[6]+13*d[7]+13*d[8]+15*d[9]+2*d[10]+8*d[11]+16*d[12]+9*d[13]+4*d[14]+d[15]) % 17;
            s[3] = (d[0]+8*d[1]+10*d[2]+13*d[3]+6*d[4]+12*d[5]+3*d[6]+2*d[7]+15*d[8]+14*d[9]+5*d[10]+11*d[11]+4*d[12]+7*d[13]+9*d[14]+16*d[15]) % 17;
            
            // calculate PQR values for error correction
            int P = subMod(s[1]*s[1],s[0]*s[2],17);
            int Q = subMod(s[0]*s[3],s[1]*s[2],17);
            int R = subMod(s[2]*s[2],s[1]*s[3],17);
            
            // begin error correction
            if (s[0]==0&&s[1]==0&&s[2]==0&&s[3]==0){ // no errors
                jTextArea1.setText("No error.");
            } else if (P==0&&Q==0&&R==0){ // single error correction
                try {
                    int i = divMod(s[1],s[0],17); // position
                    int a = s[0]; // magnitude
                    if(i==0) {
                        jTextArea1.setText("Error Code: i=0.");
                        return;
                    } if(i==-1) {
                        jTextArea1.setText("Error Code: i=-1.");
                        return;
                    }

                    // error correction
                    d[i-1] = (d[i-1] - a);
                    if(d[i-1] < 0) d[i-1]= d[i-1] + 17;

                    // output
                    String output = Arrays.toString(d);
                    jTextArea1.setText("Single error corrected.\n" + output);
                } catch(Exception e) {
                    jTextArea1.setText("Error Code: Error single.");
                }
            } else { // double error correction
                try {
                    int tempSqrt = sqrtMod17(subMod((int) Math.pow(Q,2),4*P*R,17));
                    if(tempSqrt < 0) {
                        jTextArea1.setText("Error Code: No sqrt root.");
                        return;
                    }
                    // error positions
                    int i = divMod(-Q + tempSqrt,2*P,17);
                    int j = divMod(-Q - tempSqrt,2*P,17);
                    if(i==0||j==0) {
                        jTextArea1.setText("Error Code: i/j=0.");
                        return;
                    } if(i==-1||j==-1) {
                        jTextArea1.setText("Error Code: i/j=-1.");
                        return;
                    }
                    // error magnitudes
                    int b = divMod(subMod(i*s[0],s[1],17),i-j,17);
                    int a = subMod(s[0],b,17);
                    
                    // error correction
                    d[i-1] = (d[i-1] - a);
                    if(d[i-1] < 0) d[i-1]= d[i-1] + 17;
                    d[j-1] = (d[j-1] - b);
                    if(d[j-1] < 0) d[j-1]= d[j-1] + 17;
                    
                    // output
//                    System.out.println(i+" "+a+" "+j+" "+b);
//                    System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" P"+P+" Q"+Q+" R"+R);
                    String output = Arrays.toString(d);
                    jTextArea1.setText("Double error corrected.\n" + output);
                } catch(Exception e) {
                    jTextArea1.setText("Error Code: Error double.");
                }
            }
        } catch(Exception e) { // if input not a number return invalid
            jTextArea1.setText("Error Code: Unusable input.");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    // inverse a with mod n (lec 2 slide 29)
    public int inverse(int a, int n) { 
        if(a < 0) a = a + n; /* change to positive */
	int t = 0; int newt = 1; 
	int r = n; int newr = a;    int q, temp;  
	while(newr != 0) { 
		q = r / newr;  /* integer division */        
		temp = newt;   /* remember newt    */
		newt = t - q*newt;
		t = temp;
		temp = newr;   /* remember newr    */
		newr = r - q*newr;
		r = temp;
	} 
 	if(r > 1) return -1; /* not invertible */
	if(t < 0) t = t + n; /* change to positive */
	return t;
    }
    public int addMod(int x, int y, int n) { 
        int a = (x+y)%n;
        if(a<0) a=a+n;
        return a;
    }
    public int subMod(int x, int y, int n) { 
        int a = (x-y)%n;
        if(a<0) a=a+n;
        return a;
    }
    public int multMod(int x, int y, int n) { 
        int a = (x*y)%n;
        if(a<0) a=a+n;
        return a;
    }
    public int divMod(int x, int y, int n) { 
        int b = inverse(y,n);
        if(b==-1)return b;
        int a = (x*b)%n;
        if(a<0) a=a+n;
        return a;
    }
    public int sqrtMod11(int x) { 
        System.out.println("x "+x);
        switch(x) {
            case 1:
                return 1;
            case 3:
                return 5;
            case 4:
                return 2;
            case 5:
                return 4;
            case 9:
                return 3;
        }
        return -1;
    }
    public int sqrtMod17(int x) { 
        System.out.println("x "+x);
        switch(x) {
            case 1:
                return 1;
            case 2:
                return 6;
            case 4:
                return 2;
            case 8:
                return 5;
            case 9:
                return 3;
            case 13:
                return 8;
            case 15:
                return 7;
            case 16:
                return 4;
        }
        return -1;
    }
    
    // function for testing netbeans
    public static void testing() { 
//        System.out.print(sqrtMod11(3));
        
//        int Q = 9;
//        int P = 3;
//        System.out.print(Math.sqrt(Q));
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
            java.util.logging.Logger.getLogger(CreditCardAndBCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreditCardAndBCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreditCardAndBCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreditCardAndBCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        testing();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreditCardAndBCH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
