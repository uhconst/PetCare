/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.AnimalControl;
import control.PessoaControl;
import control.RacaControl;
import javax.swing.JOptionPane;
import model.domain.Pessoa;

/**
 *
 * @author Constancio
 */
public class CadastroAnimal extends javax.swing.JInternalFrame{

    private static AnimalControl animalControl = new AnimalControl();

    /**
     * Creates new form CadastroAnimal
     */
    public CadastroAnimal(){
        initComponents();
    }

    public AnimalControl getAnimalControl(){
        return animalControl;
    }
    
    
    static void setProprietario( PessoaControl pessoaControl ){
        pessoaControl.testPodeApagar();
        animalControl.setProprietario(pessoaControl.getPessoaSelecionado()); 
        txtProprietario.setText(animalControl.getNomeProprietario());
        //animalControl.testPodeApagar();
    }
        
    static void setRaca( RacaControl racaControl ){
        animalControl.setRaca(racaControl.getRacaSelecionado()); 
        txtRaca.setText(animalControl.getNomeRaca());
    }
        
/*
    public static void setAnimalControl( AnimalControl animalControl ){
        CadastroAnimal.animalControl = animalControl;
    }
*/
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblProprietario = new javax.swing.JLabel();
        lblRaca = new javax.swing.JLabel();
        lblNomeDoAnimal = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        txtProprietario = new javax.swing.JTextField();
        txtRaca = new javax.swing.JTextField();
        txtNomeDoAnimal = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        btnProprietario = new javax.swing.JButton();
        btnRaca = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblProprietario.setText("Proprietário");

        lblRaca.setText("Raça");

        lblNomeDoAnimal.setText("Nome do animal");

        lblSexo.setText("Sexo");

        txtProprietario.setEditable(false);
        txtProprietario.setBackground(new java.awt.Color(204, 204, 204));

        txtRaca.setEditable(false);
        txtRaca.setBackground(new java.awt.Color(204, 204, 204));

        btnProprietario.setText("Proprietario");
        btnProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProprietarioActionPerformed(evt);
            }
        });

        btnRaca.setText("Raça");
        btnRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProprietario)
                    .addComponent(lblRaca)
                    .addComponent(lblNomeDoAnimal)
                    .addComponent(lblSexo))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProprietario, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txtNomeDoAnimal))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProprietario)
                    .addComponent(btnRaca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProprietario)
                    .addComponent(txtProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProprietario))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaca)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRaca))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeDoAnimal)
                    .addComponent(txtNomeDoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnSalvar)
                .addGap(61, 61, 61)
                .addComponent(btnLimpar)
                .addGap(67, 67, 67)
                .addComponent(btnCancelar)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnCancelar))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        animalControl.salvar();
        JOptionPane.showMessageDialog(this,
            "Animal salvo com sucesso",
            "Salvar animal",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRacaActionPerformed
        ConsultaRaca consultaRacaView = new ConsultaRaca();
        consultaRacaView.setVisible(true);
    }//GEN-LAST:event_btnRacaActionPerformed

    private void btnProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProprietarioActionPerformed
        ConsultaPessoa consultaPessoaView = new ConsultaPessoa();
        consultaPessoaView.setVisible(true);
    }//GEN-LAST:event_btnProprietarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnProprietario;
    private javax.swing.JButton btnRaca;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNomeDoAnimal;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JTextField txtNomeDoAnimal;
    private static javax.swing.JTextField txtProprietario;
    private static javax.swing.JTextField txtRaca;
    private javax.swing.JTextField txtSexo;
    // End of variables declaration//GEN-END:variables
}
