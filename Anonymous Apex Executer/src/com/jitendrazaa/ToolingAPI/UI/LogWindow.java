/** 
 * @Website http://JitendraZaa.com
 * @GitHub https://github.com/JitendraZaa
 * @Date 02-22-2015
 * 
 */
package com.jitendrazaa.ToolingAPI.UI;

import com.jitendrazaa.ToolingAPI.Utility;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jitendra  
 */
public class LogWindow   extends javax.swing.JFrame {

   private static final long serialVersionUID = -7772453172710900886L;
   private static boolean scrollLock = false;
   private static Logger LOGGER = null;
   
    /** Creates new form LogWindow */
    public LogWindow() {
        
        initComponents(); 
        Utility.centerWindow(this);
        resetLogText();
        if(LOGGER == null)
        {
             LOGGER = Logger.getLogger(LogWindow.class.getName());
             LOGGER.setLevel(Level.INFO);
             try{  
                String fileName =  new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss'.log'").format(new Date());  
                 System.err.println(fileName);
                FileHandler handler=new FileHandler(fileName);
                handler.setFormatter(new SimpleFormatter());
                LOGGER.addHandler(handler);
                messageln("Created Log file by Name - "+fileName);
            }catch(Exception e)
            {
                messageln("failed to initialize Log file");
                messageln(Utility.stackTraceToString(e));
            }
        } 
    } 
    
    
    public void message(String msg)
    {
        txtLog.append(msg);
        LOGGER.info(msg);
        if(!scrollLock)
        {
            txtLog.setCaretPosition(txtLog.getDocument().getLength());
        }
    }
    
    /**
     * This method is used to reset the Log Window Text
     */
    private void resetLogText()
    {
        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy, HH:mm:ss z");
        Date date = new Date();
        
        txtLog.setText("Created By     : Jitendra Zaa"
                    +"\nReport issue   : https://github.com/JitendraZaa/Anonymous-Apex-Executer"
                    +"\nDate           : "+ dateFormat.format(date)
                    +"\n----------------------------------------------------------------------"
                    +"\n");
        txtLog.setCaretPosition(txtLog.getDocument().getLength());
    }

    /**
     * Log Message and add New Line
     * @param msg
     */
    public void messageln(String msg)
    {
    	final String m = msg;
    	SwingUtilities.invokeLater(new Runnable()
    	{
    	    public void run()
    	    { 
    	    	txtLog.append(m+"\n");
                LOGGER.info(m);
                if(!scrollLock)
                {
                    txtLog.setCaretPosition(txtLog.getDocument().getLength());
                }
    	    }
    	});
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        folderChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnScroll_Lock = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        folderChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setTitle("System Debug Log");

        txtLog.setBackground(new java.awt.Color(0, 0, 0));
        txtLog.setColumns(20);
        txtLog.setForeground(new java.awt.Color(255, 255, 0));
        txtLog.setLineWrap(true);
        txtLog.setRows(5);
        txtLog.setText("Created By \t: Cognizant Technology Solutions\nReport issue \t: jitendra.zaa@cognizant.com\n----------------------------------------------------------------------\n");
        txtLog.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtLog);

        btnScroll_Lock.setText("Scroll Lock");
        btnScroll_Lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScroll_LockActionPerformed(evt);
            }
        });

        btnClear.setText("Clear Log");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnScroll_Lock)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnScroll_Lock)
                    .addComponent(btnClear))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnScroll_LockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScroll_LockActionPerformed
        scrollLock = !scrollLock;
}//GEN-LAST:event_btnScroll_LockActionPerformed

private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    resetLogText();
}//GEN-LAST:event_btnClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnScroll_Lock;
    private javax.swing.JFileChooser folderChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
