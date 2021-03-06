/**
 * Copyright (C) 2014 Karlsruhe Institute of Technology 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kit.dama.transfer.client.impl.ui;

import edu.kit.dama.transfer.client.impl.ui.model.ButtonColumn;
import edu.kit.dama.transfer.client.impl.ui.model.TransferTableModel;
import edu.kit.dama.rest.SimpleRESTContext;
import edu.kit.dama.staging.entities.download.DownloadInformation;
import edu.kit.dama.rest.staging.types.DownloadInformationWrapper;
import edu.kit.dama.rest.staging.client.impl.StagingServiceRESTClient;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.UIManager;

/**
 *
 * @author jejkal
 */
public class TransferUI2 extends javax.swing.JFrame {

  private TransferTableModel model = new TransferTableModel();

  /**
   * Creates new form TransferUI2
   */
  public TransferUI2() {
    initComponents();
    SimpleRESTContext context = new SimpleRESTContext("lYdegmLxox7faYpk", "ACfbYGCdAj3mLziU");

    DownloadInformationWrapper results = new StagingServiceRESTClient("https://dama.lsdf.kit.edu/KITDM/rest/StagingInformationService", context).getAllDownloadInformation(-1, -1, context);
    
    mainSplitPane.addPane(jTransferTableScrollPane);
    mainSplitPane.addPane(jLogPaneScrollPane);
    mainSplitPane.setInitiallyEven(true);
    jXTransferTable.setModel(model);
    
    
    
    
    for (DownloadInformation result : results.getEntities()) {
      model.addRow(result);
    }

    jXTransferTable.setEditable(true);
    Action delete = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
       // JXTable table = (JXTable) e.getSource();
        int modelRow = Integer.valueOf(e.getActionCommand());
        System.out.println("Action to " + modelRow);
        // ((DefaultTableModel) table.getModel()).removeRow(modelRow);
      }
    };
    new ButtonColumn(jXTransferTable, delete, 3);
  }

//  private void reloadTransferTable() {
//    SimpleRESTContext context = new SimpleRESTContext("lYdegmLxox7faYpk", "ACfbYGCdAj3mLziU");
//    //obtain local transfers
//    try {
//      List<Long> localTransfers = TransferHelper.getLocalTransfers();
//      for (Long transferId : localTransfers) {
//        DownloadInformationWrapper result = new StagingServiceRESTClient("http://dama.lsdf.kit.edu:8080/KITDM/rest/StagingInformationService", context).getDownloadById(transferId, context);
//      }
//
//    } catch (IOException ex) {
//    }
//
//    //obtain remote transfers
//
//    new StagingServiceRESTClient("http://dama.lsdf.kit.edu:8080/KITDM/rest/StagingInformationService", context).getAllDownloadInformation(-1, -1, context);
//  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTransferTableScrollPane = new javax.swing.JScrollPane();
    jXTransferTable = new org.jdesktop.swingx.JXTable();
    jLogPaneScrollPane = new javax.swing.JScrollPane();
    jLogPane = new javax.swing.JEditorPane();
    mainSplitPane = new com.jidesoft.swing.JideSplitPane();

    jTransferTableScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Transfers"));

    jXTransferTable.setModel(new javax.swing.table.DefaultTableModel(
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
    jTransferTableScrollPane.setViewportView(jXTransferTable);

    jLogPaneScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Logging"));
    jLogPaneScrollPane.setViewportView(jLogPane);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    mainSplitPane.setOneTouchExpandable(true);
    mainSplitPane.setOrientation(0);
    mainSplitPane.setShowGripper(true);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

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
      /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
       if ("Nimbus".equals(info.getName())) {
          
       //info.getClassName());
       break;
       }
       }*/

      javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(TransferUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TransferUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TransferUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TransferUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new TransferUI2().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JEditorPane jLogPane;
  private javax.swing.JScrollPane jLogPaneScrollPane;
  private javax.swing.JScrollPane jTransferTableScrollPane;
  private org.jdesktop.swingx.JXTable jXTransferTable;
  private com.jidesoft.swing.JideSplitPane mainSplitPane;
  // End of variables declaration//GEN-END:variables
}
