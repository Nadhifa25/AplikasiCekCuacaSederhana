import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author vivob
 */
public class CekCuacaForm extends javax.swing.JFrame {
    
    private static final String API_KEY = "0c47391e1e94e767cbb2f55520874940";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String FILE_NAME = "weather_data.csv";

    /**
     * Creates new form CekCuacaForm
     */
    public CekCuacaForm() {
        initComponents();
        updateWeatherTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblHasil = new javax.swing.JLabel();
        txtKota = new javax.swing.JTextField();
        cmbLokasi = new javax.swing.JComboBox<>();
        btnCek = new javax.swing.JButton();
        btnFavorit = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuaca = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("APLIKASI CEK CUACA SEDERHANA");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 238, 222));

        jLabel2.setText("Masukkan Nama Kota");

        jLabel3.setText("Pilih Lokasi");

        lblHasil.setText("Hasil");

        cmbLokasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banjarbaru", "Banjarmasin", "Martapura", " " }));

        btnCek.setText("Cek Cuaca");
        btnCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekActionPerformed(evt);
            }
        });

        btnFavorit.setText("Simpan Favorit");
        btnFavorit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoritActionPerformed(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        tblCuaca.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCuaca);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(lblHasil))
                            .addComponent(cmbLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(btnCek)
                            .addGap(18, 18, 18)
                            .addComponent(btnFavorit)
                            .addGap(18, 18, 18)
                            .addComponent(btnExport)
                            .addGap(18, 18, 18)
                            .addComponent(btnKeluar))))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblHasil)
                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCek)
                    .addComponent(btnFavorit)
                    .addComponent(btnExport)
                    .addComponent(btnKeluar))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekActionPerformed
        String city = txtKota.getText();
        if (!city.isEmpty()) {
            try {
                String result = getWeather(city);
                lblHasil.setText(result);  

                // Simpan ke daftar favorit jika belum ada
                if (!isCityInFavorites(city)) {
                    cmbLokasi.addItem(city);
                }

                // Simpan ke tabel
                addToTable(city, result);
                saveWeatherData(city, result);

            } catch (IOException ex) {
                lblHasil.setText("Gagal mengambil data cuaca.");
            }
        } else {
            lblHasil.setText("Masukkan nama kota terlebih dahulu.");
        }
    }//GEN-LAST:event_btnCekActionPerformed

    private void btnFavoritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoritActionPerformed
        String city = txtKota.getText();
        if (!city.isEmpty() && !isCityInFavorites(city)) {
            cmbLokasi.addItem(city);
        }
    }//GEN-LAST:event_btnFavoritActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
         JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke " + FILE_NAME);
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
         System.exit(0);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private String getWeather(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            return "Gagal mendapatkan data cuaca!";
        }

        String jsonData = response.body().string();
        JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
        JsonObject main = jsonObject.getAsJsonObject("main");
        JsonObject weather = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject();

        String description = weather.get("description").getAsString();
        double temperature = main.get("temp").getAsDouble();
        return "Cuaca: " + description + " | Suhu: " + temperature + "°C";
    }

    private boolean isCityInFavorites(String city) {
        for (int i = 0; i < cmbLokasi.getItemCount(); i++) {
            if (cmbLokasi.getItemAt(i).equals(city)) {
                return true;
            }
        }
        return false;
    }

    private void addToTable(String city, String weather) {
        DefaultTableModel model = (DefaultTableModel) tblCuaca.getModel();
        model.addRow(new Object[]{city, weather});
    }

    private void saveWeatherData(String city, String weather) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(city + "," + weather);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateWeatherTable() {
        List<String[]> data = loadWeatherData();
        String[] columnNames = {"Kota", "Cuaca"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (String[] row : data) {
            model.addRow(row);
        }

        tblCuaca.setModel(model);
    }

    private List<String[]> loadWeatherData() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
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
            java.util.logging.Logger.getLogger(CekCuacaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CekCuacaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CekCuacaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CekCuacaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CekCuacaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCek;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFavorit;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JComboBox<String> cmbLokasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHasil;
    private javax.swing.JTable tblCuaca;
    private javax.swing.JTextField txtKota;
    // End of variables declaration//GEN-END:variables
}
