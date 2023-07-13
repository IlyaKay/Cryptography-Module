/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RainbowTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Ilya
 */
public class RainbowTable extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Gen Rainbow");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("CrackRain5000");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CrackRain1000");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // generate table
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // start recording time
            long startTime = System.nanoTime();
            int k = 0;
            int o = 0;

            // generate table of size rainbowTableSize
            for(int i = 0; i < rainbowTableSize; i++) {
                
                // generate a starting value for the chain
                String startVal = startChain();

                // loop until unique value for start of chain is found
                while(rainbowTable.containsValue(startVal)) {
                    startVal = startChain();
                    k++;
                }

                // hash and reduce for chain length
                String hashCode = SHA1(startVal);
                String reducedCode = reduce(hashCode, 0);
                for(int j = 1; j < chainLength; j++) {
                    hashCode = SHA1(reducedCode);
                    reducedCode = reduce(hashCode, j);
                }

                // check that the final value of the chain is unique
                if(rainbowTable.containsKey(reducedCode)) {
                    i--;
                    o++;
                }   // set the chain tail as the key in the hashmap
                    // to allow for fast .get() matching later
                else {
                    rainbowTable.put(reducedCode, startVal);
                }
            }

            System.out.println(k);
            System.out.println(o);
            // save rainbow table to a file
            FileOutputStream fOut = new FileOutputStream(fNameGen);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(rainbowTable);
            fOut.close();
            oOut.close();
            
            // terminal print completion message and time stamp
            System.out.println("Complete");
            long endTime = System.nanoTime();
            int[] time = formatTime(startTime,endTime);
            System.out.println("Min:Sec:MiliSec - "+time[0]+":"+time[1]+":"+time[2]);
            
        // catch statements to stop netbeans from yelling at me
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(RainbowTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException | NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(RainbowTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // crack hash using table of chain 5000
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        rainbowCrack(fName5000, 5000);
    }//GEN-LAST:event_jButton2ActionPerformed

    // crack hash using table of chain 1000
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        rainbowCrack(fName1000, 1000);
    }//GEN-LAST:event_jButton3ActionPerformed

    // convert data to hex
    private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer(); 
        for (int i = 0; i < data.length; i++) { 
        	int halfbyte = (data[i] >>> 4) & 0x0F; 
        	int two_halfs = 0; 
        	do { 
	            if ((0 <= halfbyte) && (halfbyte <= 9)) 
	                buf.append((char) ('0' + halfbyte)); 
	            else 
	            	buf.append((char) ('a' + (halfbyte - 10))); 
	            halfbyte = data[i] & 0x0F; 
        	} while(two_halfs++ < 1); 
        } 
        return buf.toString(); 
    } 
  
    // SHA-1 Hashing
    public static String SHA1(String text)  
    throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
	MessageDigest md; 
	md = MessageDigest.getInstance("SHA-1"); 
	byte[] sha1hash = new byte[40]; 
	md.update(text.getBytes("iso-8859-1"), 0, text.length()); 
	sha1hash = md.digest(); 
	return convertToHex(sha1hash); 
    } 

    // string format check
    private boolean SHA1format(String str)
    {
        if(str.length() != 40) return false;
        return str.matches("[a-z0-9]*");
    }
    
    // organise time
    private int[] formatTime(long start, long end)
    {
        int milis = (int) ((end - start) / 1000000);
        int second = (milis / 1000) % 60;
        int minute = (milis / (1000 * 60));
        int newMilis = (milis % 1000);
        int[] time = new int[3];
        time[0] = minute; time[1] = second; time[2] = newMilis;
        return time;
    }
    
    // reduce function
    public String reduce(String hash, int pos)
    {
       BigInteger bigNumber = new BigInteger(Integer.toString(hash.hashCode()));
       // position used to avoid collisions
       bigNumber = bigNumber.add(new BigInteger(Integer.toString(pos)));
       int n = bigNumber.mod(primeP).intValue();  
       return intToPassword(n);  
    }
    
    // reduce function cont.
    public String intToPassword(int n)
    {
        int base = alphabet.length;
        int r;
        String s = "";
        while(n >= 0) {
            r = n % base;
            n = n / base;
            s = alphabet[r] + s;
            n = n - 1;
        }
        return s;
    }
    
    // chain reduce the hash 
    // in the hopes that it matches a tail rainbowtable key
    public String chainReduce(String hash, int pos, int chainL) throws NoSuchAlgorithmException, UnsupportedEncodingException 
    {
        String pwd = reduce(hash, pos);
        while (pos != chainL - 1) {
            pos++;
            pwd = reduce(SHA1(pwd), pos);
        }
        return pwd;
    }
    
    // initial chain value
    public String startChain()
    {
        String val = "";
        Random rand = new Random();
        for(int i = 0; i < passwordLength; i++) {
            val = alphabet[rand.nextInt(alphabet.length)] + val;
        }
        return val;
    }
    
    // rainbow table cracking
    public void rainbowCrack(String fName, int chainL) {
        try {
            // start recording time
            long startTime = System.nanoTime();
            
            // read in hash and remove accidental white space
            String hashInput = jTextField1.getText().replaceAll(" ","");

            // check that the input matches sha-1 format
            if(SHA1format(hashInput)) {
                
                // load rainbow table from file
                FileInputStream fIn = new FileInputStream(fName);
                ObjectInputStream oIn = new ObjectInputStream(fIn);
                rainbowTable = (HashMap) oIn.readObject();
                fIn.close();
                oIn.close();
                
                boolean hashCracked = false;
                int k = 0;
                
                // run through every possibility of chainReduce starting from the end of the chain
                for(int i = 0; i < chainL; i++) {
                    String lastChainVal = chainReduce(hashInput, (chainL-1) - i, chainL);

                    //If a value found in has map from the tested key.
                    String rKey = (String) rainbowTable.get(lastChainVal);
                    if(rKey != null) {
                        String previousString;
                        String reducedCode = rKey;
                        String hashCode;
                        
                        // search for original hash match
                        for(int j = 0; j < chainL; j++) {
                            previousString = reducedCode;
                            hashCode = SHA1(reducedCode);
                            reducedCode = reduce(hashCode, j);
                            
                            // if a match it found then output the plaintext that was hashed
                            if(hashCode.equals(hashInput)) {
                                jTextArea1.setText(previousString);
                                hashCracked = true;
                                System.out.println(k);
                                break;
                            }
                        }
                        if(hashCracked) 
                            break;
                        k++;
                    }
                }
                if(!hashCracked)
                    jTextArea1.setText("Rainbow table does not contain this hash.");
            } else
                jTextArea1.setText("Hash must be in SHA-1 format.");
            
            // terminal print completion message and time stamp
            System.out.println("Complete");
            long endTime = System.nanoTime();
            int[] time = formatTime(startTime,endTime);
            System.out.println("Min:Sec:MiliSec - "+time[0]+":"+time[1]+":"+time[2]);
            
        // catch statements to stop netbeans from yelling at me
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(RainbowTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(RainbowTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    // variable init
//    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
    char[] alphabet = {'0','1','2','3','4','5','6','7','8','9'};
    HashMap rainbowTable = new HashMap();
    int chainLength = 5000;
    int passwordLength = 8;
    int searchSpace;
    int rainbowTableSize;
    BigInteger primeP;
    String fNameGen = ("RainbowTable.txt");
    String fName5000 = ("RainbowTable5000.txt");
    String fName1000 = ("RainbowTable1000.txt");
    
    /**
     * Creates new form RainbowTable
     * Also initialises some vars
     */
    public RainbowTable() {
        initComponents();
        
        // calculate password space
        BigInteger tempSpace = new BigInteger("0");
        BigInteger A = new BigInteger(Integer.toString(alphabet.length));
        for(int i = 0; i <= passwordLength; i++) {
            tempSpace = tempSpace.add(A.pow(i));
        }
        searchSpace = tempSpace.intValue();
        
        // calculate rainbowtable size
        rainbowTableSize = (int)((searchSpace / chainLength) * 1.5);
        System.out.println(searchSpace);
        System.out.println(rainbowTableSize);
        
        // find a prime larger than the password space
        primeP = tempSpace.nextProbablePrime();
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
            java.util.logging.Logger.getLogger(RainbowTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RainbowTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RainbowTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RainbowTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RainbowTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
