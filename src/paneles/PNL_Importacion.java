/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import static principal.Principal.tres;

public class PNL_Importacion extends javax.swing.JPanel {

    /**
     * Creates new form Visual
     */
    public static String ruta_archivo = "";
    
    public static String nombre_pdf="";
    public static int pag_pdf;
    public static String direct="";
    
    public PNL_Importacion() {
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

        jPanel2 = new javax.swing.JPanel();
        sc = new javax.swing.JScrollPane();
        btnabrir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnabrir.setBackground(new java.awt.Color(255, 255, 255));
        btnabrir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnabrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pdf.png"))); // NOI18N
        btnabrir.setText("Abrir archivo PDF");
        btnabrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnabrirActionPerformed(evt);
            }
        });
        sc.setViewportView(btnabrir);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sc, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sc, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void abrir_pdf(String url) { 
        try {
           SwingController control=new SwingController();
            SwingViewBuilder factry=new SwingViewBuilder(control, 2, 1);
            JPanel veiwerCompntpnl=factry.buildViewerPanel();
            ComponentKeyBinding.install(control, veiwerCompntpnl);
            control.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                control.getDocumentViewController()));
                control.openDocument(url);
                pag_pdf = control.getDocument().getNumberOfPages();                   
            sc.setViewportView(veiwerCompntpnl);
        } catch (Exception ex) {
            tres.setEnabled(false);
            JOptionPane.showMessageDialog(this,"Cannot Load Pdf");
        }
        
    }
    
    private void btnabrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabrirActionPerformed
        abrirPdf();
       
    }//GEN-LAST:event_btnabrirActionPerformed

    public void abrirPdf(){
        
        JFileChooser j = new JFileChooser(ruta_archivo);
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);             
        int se = j.showOpenDialog(this);
        if (se == 0) {
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
            nombre_pdf = j.getSelectedFile().getName();
            direct = j.getSelectedFile().getPath();
            abrir_pdf(ruta_archivo);
            if(ruta_archivo.compareTo("")!=0){
                 tres.setEnabled(true);
             }
            else{
                tres.setEnabled(false);
             }
               
        } else {
           tres.setEnabled(false);
            JOptionPane.showMessageDialog(null, "No selecciono");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabrir;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane sc;
    // End of variables declaration//GEN-END:variables

    
}
