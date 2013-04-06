package Routenplaner;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI.java
 *
 * Created on 10.05.2012, 07:45:08
 */

import java.util.Vector;
import javax.swing.ImageIcon;
/**
 *
 * @author jbarthelmes
 */
public class VIEW extends javax.swing.JFrame {

    private Vector<String> knotenliste;
    private STEUERUNG controller;
    private Object startwert;
    private Object zielwert;


    /** Creates new form GUI */
    public VIEW() {
        initComponents();
        knotenliste = new Vector<String>();
        startwert=null;
        zielwert=null;

    }
    
    public void initialisieren(Vector<String> liste, STEUERUNG controller){
        knotenliste = liste;
        this.controller = controller;
        startList.setListData(knotenliste);
        zielList.setListData(knotenliste);
    }


    public void routeAusgeben(Vector<String> route, int distanz) {
        ausgabeList.setListData(route);
        distanzLabel.setText("Distanz: "+ String.valueOf(distanz) + " Schritte");
        
        //Landschaftsschutzgebiet!!!
        
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startTextField = new javax.swing.JTextField();
        zielTextField = new javax.swing.JTextField();
        startScrollPane = new javax.swing.JScrollPane();
        startList = new javax.swing.JList();
        zielScrollPane = new javax.swing.JScrollPane();
        zielList = new javax.swing.JList();
        ausgabeScrollPane = new javax.swing.JScrollPane();
        ausgabeList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        karte = new javax.swing.JLabel();
        karteComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        distanzLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Routenplaner AvH - v1.0.0");
        setIconImages(null);
        setResizable(false);

        startTextField.setText("Start");
        startTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                startGainFocus(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                startLooseFocus(evt);
            }
        });
        startTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                startRelease(evt);
            }
        });

        zielTextField.setText("Ziel");
        zielTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                zielGainFocus(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                zielLooseFocus(evt);
            }
        });
        zielTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                zielRelease(evt);
            }
        });

        startList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        startList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                startValueChanged(evt);
            }
        });
        startScrollPane.setViewportView(startList);

        zielList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                zielValueChanged(evt);
            }
        });
        zielScrollPane.setViewportView(zielList);

        ausgabeScrollPane.setViewportView(ausgabeList);

        jButton1.setText("Route Berechnen");
        jButton1.setToolTipText("");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                routeBerechnen(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(592, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(592, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(592, 400));

        karte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Routenplaner/Erdgeschoss1.jpg"))); // NOI18N
        karte.setMaximumSize(new java.awt.Dimension(592, 400));
        karte.setPreferredSize(new java.awt.Dimension(592, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(karte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(karte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        karteComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Erdgeschoss", "1. Obergeschoss", "2. Obergeschoss", "Pavillon Ost", "Pavillon West" }));
        karteComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                karteValue(evt);
            }
        });

        jLabel1.setText("<html>\n01) III Nord 1<br>\n02) III Nord 2<br>\n03) III Nord 3<br>\n04) II Nord 1<br>\n05) II Nord 2<br>\n06) II Nord 3<br>\n07) I Nord 1<br>\n08) I Nord 2<br>\n09) I Nord 3<br>\n10) I Nord 4<br>\n11) II Süd 1<br>\n12) II Süd 2<br>\n13) II Süd 3<br>\n14) I Süd 1<br>\n15) I Süd 2<br>\n16) I Süd 3<br>\n17) I Süd 4<br>\n18) Mitte 1<br>\n19) Mitte 2<br>\n20) Mitte 3<br>\n21) Mitte 4<br>\n22) Unterkeller 1<br>\n23) Unterkeller 2<br>\n24) Eingang Pavillon West<br>\n25) Eingang Pavillon Ost<br>\n26) Pavillon West Gang 1<br>\n27) Pavillon West Gang 2<br>\n28) Pavillon Ost Gang 1<br>\n29) Pavillon Ost Gang 2<br>\n30) Treppenhaus Nord 1 Etage 1<br>\n31) Treppenhaus Nord 1 Etage 2<br>\n32) Treppenhaus Nord 2 Etage 1<br>\n33) Treppenhaus Nord 2 Etage 2<br>\n34) Treppenhaus Nord 3 Etage 1<br>\n35) Treppenhaus Nord 3 Etage 2<br>\n36) Treppenhaus Süd 1 Etage 1<br>\n37) Treppenhaus Süd 1 Etage 2<br>\n38) Treppenhaus Süd 1 Etage 3<br>\n39) Treppenhaus Süd 2 Etage 1<br>\n40) Treppenhaus Süd 2 Etage 2<br>\n41) Treppenhaus Süd 2 Etage 3<br>\n42) Treppenhaus Süd 3 Etage 1<br>\n43) Treppenhaus Süd 3 Etage 2<br>\n44) Treppenhaus Süd 3 Etage 3\n</html>");

        distanzLabel.setText("Distanz: 0 Schritte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ausgabeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(distanzLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(startTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(zielTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(startScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(zielScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(karteComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zielTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(startScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zielScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(karteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ausgabeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(distanzLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startGainFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startGainFocus
        if (startTextField.getText().equals("Start")){
            startTextField.setText("");
        }
    }//GEN-LAST:event_startGainFocus

    private void zielGainFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_zielGainFocus
        if (zielTextField.getText().equals("Ziel")){
            zielTextField.setText("");
        }
    }//GEN-LAST:event_zielGainFocus

    private void startLooseFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startLooseFocus
        if (startTextField.getText().equals("")){
            startTextField.setText("Start");
        }
    }//GEN-LAST:event_startLooseFocus

    private void zielLooseFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_zielLooseFocus
        if (zielTextField.getText().equals("")){
            zielTextField.setText("Ziel");
        }
    }//GEN-LAST:event_zielLooseFocus

    private void routeBerechnen(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_routeBerechnen
        controller.routeBerechnen(startwert.toString(), zielwert.toString());
    }//GEN-LAST:event_routeBerechnen

    private void startValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_startValueChanged
        startwert=startList.getSelectedValue();
    }//GEN-LAST:event_startValueChanged

    private void zielValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_zielValueChanged
        zielwert=zielList.getSelectedValue();
    }//GEN-LAST:event_zielValueChanged

    private void startRelease(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startRelease
        if(startTextField.getText().toString().equals("what is the answer to life the universe and everything")){
            karte.setIcon(new ImageIcon(this.getClass().getResource("/Routenplaner/42.jpg")));
        }
        
        Vector<String> vector;
        Vector<String> nvector = new Vector<String>();
        vector=knotenliste;
        for(int i=0;i<vector.size();i++){
             if(vector.elementAt(i).toLowerCase().contains(startTextField.getText().toString().toLowerCase())){
                  nvector.add(vector.elementAt(i));
             }
        }
        startList.setListData(nvector);
    }//GEN-LAST:event_startRelease

    private void zielRelease(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zielRelease
        Vector<String> vector;
        Vector<String> nvector = new Vector<String>();
        vector=knotenliste;
        for(int i=0;i<vector.size();i++){
             if(vector.elementAt(i).toLowerCase().contains(zielTextField.getText().toString().toLowerCase())){
                  nvector.add(vector.elementAt(i));
             }
        }
        zielList.setListData(nvector);
    }//GEN-LAST:event_zielRelease

    private void karteValue(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_karteValue
        String value=karteComboBox.getSelectedItem().toString();
        ImageIcon icon=null;
        karte.setText("");
        if(value.equals("Erdgeschoss")){
            icon = new ImageIcon(this.getClass().getResource("/Routenplaner/Erdgeschoss1.jpg"));
        }else if(value.equals("1. Obergeschoss")){
            icon = new ImageIcon(this.getClass().getResource("/Routenplaner/Obergeschoss Groß1.jpg"));
        }else if(value.equals("2. Obergeschoss")){
            icon = new ImageIcon(this.getClass().getResource("/Routenplaner/2 Obergeschoss groß1.jpg"));           
        }else if(value.equals("Pavillon Ost")){
            icon = new ImageIcon(this.getClass().getResource("/Routenplaner/Pavillonost1.jpg"));         
        }else if(value.equals("Pavillon West")){
            icon = new ImageIcon(this.getClass().getResource("/Routenplaner/PavillonWest1.jpg"));
        }else{
            karte.setText("Karte nicht vorhanden!");
        }
            karte.setIcon(icon);
    }//GEN-LAST:event_karteValue



    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ausgabeList;
    private javax.swing.JScrollPane ausgabeScrollPane;
    private javax.swing.JLabel distanzLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel karte;
    private javax.swing.JComboBox karteComboBox;
    private javax.swing.JList startList;
    private javax.swing.JScrollPane startScrollPane;
    private javax.swing.JTextField startTextField;
    private javax.swing.JList zielList;
    private javax.swing.JScrollPane zielScrollPane;
    private javax.swing.JTextField zielTextField;
    // End of variables declaration//GEN-END:variables

}
