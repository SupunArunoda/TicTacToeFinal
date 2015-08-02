
package tictactoe_2;

import javax.swing.JFrame;


public class topScores extends javax.swing.JFrame {

    public topScores() {
        initComponents();
        saveDB db = new saveDB();
        db.preparelists();
        int[] score=db.getScorelist();
        String[] names=db.getNamelist();
        P1.setText(names[0]);
        P2.setText(names[1]);
        P3.setText(names[2]);
        P4.setText(names[3]);
        P5.setText(names[4]);
        S1.setText(String.valueOf(score[0]));
        S2.setText(String.valueOf(score[1]));
        S3.setText(String.valueOf(score[2]));
        S4.setText(String.valueOf(score[3]));
        S5.setText(String.valueOf(score[4]));
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeadL = new javax.swing.JLabel();
        NameL = new javax.swing.JLabel();
        P1 = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        P3 = new javax.swing.JLabel();
        P4 = new javax.swing.JLabel();
        ScoreL = new javax.swing.JLabel();
        S1 = new javax.swing.JLabel();
        S2 = new javax.swing.JLabel();
        S3 = new javax.swing.JLabel();
        S4 = new javax.swing.JLabel();
        P5 = new javax.swing.JLabel();
        S5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeadL.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        HeadL.setText("      TOP 5 PLAYERS");

        NameL.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        NameL.setText("Name");

        ScoreL.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        ScoreL.setText("Score");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(HeadL, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameL)
                            .addComponent(P1)
                            .addComponent(P2)
                            .addComponent(P3)
                            .addComponent(P4)
                            .addComponent(P5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(S3)
                            .addComponent(S2)
                            .addComponent(S1)
                            .addComponent(ScoreL)
                            .addComponent(S4)
                            .addComponent(S5))
                        .addGap(76, 76, 76)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeadL)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameL)
                    .addComponent(ScoreL))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P1)
                    .addComponent(S1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P2)
                    .addComponent(S2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P3)
                    .addComponent(S3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P4)
                    .addComponent(S4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P5)
                    .addComponent(S5))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(topScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(topScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(topScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(topScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                
        
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadL;
    private javax.swing.JLabel NameL;
    private javax.swing.JLabel P1;
    private javax.swing.JLabel P2;
    private javax.swing.JLabel P3;
    private javax.swing.JLabel P4;
    private javax.swing.JLabel P5;
    private javax.swing.JLabel S1;
    private javax.swing.JLabel S2;
    private javax.swing.JLabel S3;
    private javax.swing.JLabel S4;
    private javax.swing.JLabel S5;
    private javax.swing.JLabel ScoreL;
    // End of variables declaration//GEN-END:variables
}
