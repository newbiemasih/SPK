/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Corespk.CoreApps;
import Implements.implementOperation;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import Gui.Kolom;
import Gui.TabelModel;
import com.mongodb.MongoException;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author newbie
 */
public class MainGui extends javax.swing.JFrame {

    private int LIMIT_NILAI = 3;
    private int LIMIT_NIK = 8;
    private int LIMIT_NAMA = 25;
    List record = new ArrayList();
    private implementOperation peminatSrv;
    int row;
    
    /**
     * Creates new form MainGui
     */
    public MainGui() {
        initComponents();
        
        setTitle("Aplikasi Sistem Penunjang Keputusan");
        setLocationRelativeTo(null);
        peminatSrv = new implementOperation((Koneksi.getMongo()));
        getContentPane().setBackground(new Color(255, 255, 255));
        
        TabelModel model = new TabelModel(peminatSrv.getAll());
        TabelMurid.setModel(model);
        
        TabelMurid.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = TabelMurid.getSelectedRow();
                if (row != -1) {
                    isiForm();
                }
            }
        });
        kondisiAwal();
    }
    
    void buttonSemula() {
        btnHapus.setEnabled(false);
        btnPerbaharui.setEnabled(false);
        btnTambah.setEnabled(true);
        btnUlangi.setEnabled(false);
    }
    
    void buttonSeleksi() {
        btnHapus.setEnabled(true);
        btnPerbaharui.setEnabled(true);
        btnTambah.setEnabled(false);
        btnUlangi.setEnabled(true);
    }
    
    void tabelDinamis() {
        Kolom kolom = new Kolom(TabelMurid);
        TabelMurid.revalidate();
    }
    
    void loadData() {
        record = peminatSrv.getAll();
    }
    
    final void kondisiAwal() {
        loadData();
        isiTabel();
        kosongkanForm();
        buttonSemula();
        tabelDinamis();
        
        int exit = 0;
        if (exit == JFrame.EXIT_ON_CLOSE){
            Koneksi.getMongo().close();
        }
        if (!peminatSrv.getAll().isEmpty()){
            sub_menu2.setEnabled(true);
            sub_menu1.setEnabled(true);
        } else {
            sub_menu2.setEnabled(false);
            sub_menu1.setEnabled(false);
        }
    }
    
    void kosongkanForm() {
        txtNama.setText("");
        txtNik.setText("");
        txtKelas.setText("");
        txtAkutansi.setText("");
        txtGeografi.setText("");
        txtSosiologi.setText("");
        txtKimia.setText("");
        txtBiologi.setText("");
        txtMatematika.setText("");
        IPA.setSelected(false);
        IPS.setSelected(false);
        btnGroup.setSelected(btnGroup.getSelection(), false);
    }
    
    void isiForm() {
        CoreApps coreApps = (CoreApps) record.get(row);
        txtNama.setText(coreApps.getNama());
        txtNik.setText(coreApps.getNik());
        txtKelas.setText(coreApps.getKelas());
        
        txtAkutansi.setText(coreApps.getAkutansi() + "");
        txtGeografi.setText(coreApps.getGeografi() + "");
        txtSosiologi.setText(coreApps.getSosiologi() + "");
        
        txtKimia.setText(coreApps.getKimia() + "");
        txtFisika.setText(coreApps.getFisika() + "");
        txtBiologi.setText(coreApps.getBiolgi() + "");
        
        txtMatematika.setText(coreApps.getMatematika() + "");
        btnGroup.setSelected(btnGroup.getSelection(), true);
        buttonSeleksi();
        
    }
    
    void isiTabel() {
        Object data[][] = new Object[record.size()][12];
        int isi = 0;
        for (Iterator iter = record.iterator(); iter.hasNext();) {
            CoreApps coreApps = (CoreApps)  iter.next();
            
            data[isi][0] = coreApps.getNama();
            data[isi][1] = coreApps.getNik();
            data[isi][2] = coreApps.getKelas();
            
            data[isi][3] = coreApps.getSosiologi();
            data[isi][4] = coreApps.getAkutansi();
            data[isi][5] = coreApps.getGeografi();
            
            data[isi][6] = coreApps.getKimia();
            data[isi][7] = coreApps.getFisika();
            data[isi][8] = coreApps.getBiolgi();
            
            data[isi][9] = coreApps.getMatematika();
            data[isi][10] = coreApps.getMinat();
            data[isi][11] = coreApps.getHasilMinat();
            isi++;
        }
        
        String header[] = {};
        TabelMurid.setModel(new DefaultTableModel(data, header));
        ScrollMurid.setViewportView(TabelMurid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ScrollMurid = new javax.swing.JScrollPane();
        TabelMurid = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtNik = new javax.swing.JTextField();
        txtKelas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAkutansi = new javax.swing.JTextField();
        txtGeografi = new javax.swing.JTextField();
        txtSosiologi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtKimia = new javax.swing.JTextField();
        txtFisika = new javax.swing.JTextField();
        txtBiologi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMatematika = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        IPA = new javax.swing.JRadioButton();
        IPS = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUlangi = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnPerbaharui = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu1 = new javax.swing.JMenu();
        sub_menu1 = new javax.swing.JMenu();
        PDF = new javax.swing.JMenuItem();
        sub_menu2 = new javax.swing.JMenuItem();
        sub_menu3 = new javax.swing.JMenuItem();
        Menu2 = new javax.swing.JMenu();
        Menu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Penunjang Keputusan");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Aplikasi Sistem Penunjang Keputusan Pembagian Kelas");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("SMA Negeri 1 Khayalan");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setText("Jl. Mayjen Sutoyo No 13, Khayalan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(280, 280, 280))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(305, 305, 305))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        TabelMurid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollMurid.setViewportView(TabelMurid);

        jPanel2.setBackground(new java.awt.Color(1, 191, 233));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("Nama ");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setText("No Induk ");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setText("Kelas Asal ");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel7.setText("Akutansi");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel8.setText("Geografi");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel9.setText("Sosiologi");

        txtAkutansi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAkutansiKeyTyped(evt);
            }
        });

        txtGeografi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGeografiKeyTyped(evt);
            }
        });

        txtSosiologi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSosiologiKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel10.setText("Kimia");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel11.setText("Fisika");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel12.setText("Biologi");

        txtKimia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKimiaKeyTyped(evt);
            }
        });

        txtFisika.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFisikaKeyTyped(evt);
            }
        });

        txtBiologi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBiologiKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel13.setText("Matematika");

        txtMatematika.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatematikaKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel14.setText("Minat");

        btnGroup.add(IPA);
        IPA.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        IPA.setText("IPA");

        btnGroup.add(IPS);
        IPS.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        IPS.setText("IPS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txtKelas))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(38, 38, 38)
                        .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(58, 58, 58)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSosiologi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(16, 16, 16))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGeografi, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(txtAkutansi))))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(13, 13, 13))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel11)
                            .addGap(11, 11, 11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtFisika, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBiologi)
                    .addComponent(txtKimia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatematika, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IPS)
                            .addComponent(IPA))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtAkutansi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtKimia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtMatematika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtGeografi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtFisika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(IPA))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IPS)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(txtSosiologi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtBiologi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jPanel3.setBackground(new java.awt.Color(1, 191, 233));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUlangi.setText("Ulangi");
        btnUlangi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangiActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setToolTipText("");

        btnPerbaharui.setText("Perbaharui");
        btnPerbaharui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerbaharuiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUlangi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPerbaharui, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUlangi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPerbaharui)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu1.setText("Berkas");

        sub_menu1.setText("Export ke");
        sub_menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_menu1ActionPerformed(evt);
            }
        });

        PDF.setText("PDF");
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });
        sub_menu1.add(PDF);

        Menu1.add(sub_menu1);

        sub_menu2.setText("Hapus Semua Data");
        sub_menu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_menu2ActionPerformed(evt);
            }
        });
        Menu1.add(sub_menu2);

        sub_menu3.setText("Keluar");
        sub_menu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_menu3ActionPerformed(evt);
            }
        });
        Menu1.add(sub_menu3);

        jMenuBar1.add(Menu1);

        Menu2.setText("Kelola");
        jMenuBar1.add(Menu2);

        Menu3.setText("Bantuan");
        jMenuBar1.add(Menu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollMurid)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollMurid, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void sub_menu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_menu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_menu2ActionPerformed

    private void btnUlangiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangiActionPerformed
        // TODO add your handling code here:
        kondisiAwal();
    }//GEN-LAST:event_btnUlangiActionPerformed

    private void sub_menu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_menu3ActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(this, "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (exit == JOptionPane.YES_NO_OPTION) {
            Koneksi.getMongo().close();
            System.exit(0);
        }
    }//GEN-LAST:event_sub_menu3ActionPerformed

    private void sub_menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_menu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_menu1ActionPerformed

    private void PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFActionPerformed
        // TODO add your handling code here:
        try {
            int count = TabelMurid.getRowCount();
            Document doc = new Document(PageSize.A4_LANDSCAPE.rotate());
            doc.addTitle("Data Hasil Peminatan Siswa/i");
            
            PdfWriter.getInstance(doc, new FileOutputStream("C:"));
            doc.open();
            PdfPTable pdftable = new PdfPTable(12);
            pdftable.addCell("Nama");
            pdftable.addCell("No Induk");
        } catch (FileNotFoundException | DocumentException | HeadlessException e) {
        }
    }//GEN-LAST:event_PDFActionPerformed

    private void txtAkutansiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAkutansiKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()) || txtAkutansi.getText().length() > LIMIT_NILAI) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAkutansiKeyTyped

    private void txtGeografiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeografiKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()) || txtGeografi.getText().length() > LIMIT_NILAI) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGeografiKeyTyped

    private void txtSosiologiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSosiologiKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()) || txtSosiologi.getText().length() > LIMIT_NILAI) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSosiologiKeyTyped

    private void txtKimiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKimiaKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()) || txtKimia.getText().length() > LIMIT_NILAI){
            evt.consume();
        }
    }//GEN-LAST:event_txtKimiaKeyTyped

    private void txtFisikaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFisikaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFisikaKeyTyped

    private void txtBiologiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBiologiKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBiologiKeyTyped

    private void txtMatematikaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatematikaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatematikaKeyTyped

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if (txtNama.getText().equals("") || txtNik.getText().equals("") || txtKelas.getText().equals("")
                || txtAkutansi.getText().equals("") || txtGeografi.getText().equals("") || txtSosiologi.getText().equals("")
                || txtKimia.getText().equals("") || txtFisika.getText().equals("") || txtBiologi.getText().equals("")
                || txtMatematika.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Data harap diisi dengan lengkap.", "Error Submit", JOptionPane.ERROR_MESSAGE);
        } else {
            CoreApps coreApps = new CoreApps();
            coreApps.setNama(txtNama.getText().toUpperCase().trim());
            coreApps.setNik(txtNik.getText());
            coreApps.setKelas(txtKelas.getText().toUpperCase().trim());
            
            coreApps.setAkutansi(Double.valueOf(txtAkutansi.getText()));
            coreApps.setSosiologi(Double.valueOf(txtSosiologi.getText()));
            coreApps.setGeografi(Double.valueOf(txtGeografi.getText()));
            
            coreApps.setKimia(Double.valueOf(txtKimia.getText()));
            coreApps.setFisika(Double.valueOf(txtFisika.getText()));
            coreApps.setBiolgi(Double.valueOf(txtBiologi.getText()));
            
            coreApps.setMatematika(Double.valueOf(txtMatematika.getText()));
            
            String minat = "";
            if (IPA.isSelected()) {
                minat = "IPA";
            } else if (IPS.isSelected()) {
                minat = "IPS";
            }
            coreApps.setMinat(minat);
            
            String hasil = "";
            double nilaiIPS = (coreApps.getAkutansi() + coreApps.getSosiologi() + coreApps.getSosiologi() + coreApps.getMatematika()) / 4;
            double nilaiIPA = (coreApps.getKimia() + coreApps.getFisika() + coreApps.getBiolgi() + coreApps.getMatematika()) / 4;
            
            if (nilaiIPA >= 80 && nilaiIPA > nilaiIPS) {
                hasil = "IPA";
            } else if(nilaiIPS > 78 && nilaiIPS > nilaiIPA) {
                hasil = "IPS";
            } else {
                if (IPS.isSelected()) {
                    hasil = "IPS";
                } else if (IPA.isSelected()) {
                    hasil = "IPA";
                }
            }
            coreApps.setHasilMinat(hasil);
            peminatSrv.simpan(coreApps);
            kondisiAwal();
        }
            
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnPerbaharuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerbaharuiActionPerformed
        // TODO add your handling code here:
        try {
         if (txtNama.getText().equals("") || txtNik.getText().equals("") || txtKelas.getText().equals("")
                || txtAkutansi.getText().equals("") || txtGeografi.getText().equals("") || txtSosiologi.getText().equals("")
                || txtKimia.getText().equals("") || txtFisika.getText().equals("") || txtBiologi.getText().equals("")
                || txtMatematika.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Data harap diisi dengan lengkap.", "Error Submit", JOptionPane.ERROR_MESSAGE);
        } else {
            CoreApps coreApps = new CoreApps();
            coreApps.setNama(txtNama.getText().toUpperCase().trim());
            coreApps.setNik(txtNik.getText());
            coreApps.setKelas(txtKelas.getText().toUpperCase().trim());
            
            coreApps.setAkutansi(Double.valueOf(txtAkutansi.getText()));
            coreApps.setSosiologi(Double.valueOf(txtSosiologi.getText()));
            coreApps.setGeografi(Double.valueOf(txtGeografi.getText()));
            
            coreApps.setKimia(Double.valueOf(txtKimia.getText()));
            coreApps.setFisika(Double.valueOf(txtFisika.getText()));
            coreApps.setBiolgi(Double.valueOf(txtBiologi.getText()));
            
            coreApps.setMatematika(Double.valueOf(txtMatematika.getText()));
            
            String minat = "";
            if (IPA.isSelected()) {
                minat = "IPA";
            } else if (IPS.isSelected()) {
                minat = "IPS";
            }
            coreApps.setMinat(minat);
            
            String hasil = "";
            double nilaiIPS = (coreApps.getAkutansi() + coreApps.getSosiologi() + coreApps.getSosiologi() + coreApps.getMatematika()) / 4;
            double nilaiIPA = (coreApps.getKimia() + coreApps.getFisika() + coreApps.getBiolgi() + coreApps.getMatematika()) / 4;
            
            if (nilaiIPA >= 80 && nilaiIPA > nilaiIPS) {
                hasil = "IPA";
            } else if(nilaiIPS > 78 && nilaiIPS > nilaiIPA) {
                hasil = "IPS";
            } else {
                if (IPS.isSelected()) {
                    hasil = "IPS";
                } else if (IPA.isSelected()) {
                    hasil = "IPA";
                }
            }
            coreApps.setHasilMinat(hasil);
            peminatSrv.update(coreApps);
            kondisiAwal();
        }
        } catch (MongoException e){
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan database", "Error Database",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPerbaharuiActionPerformed

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
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton IPA;
    private javax.swing.JRadioButton IPS;
    private javax.swing.JMenu Menu1;
    private javax.swing.JMenu Menu2;
    private javax.swing.JMenu Menu3;
    private javax.swing.JMenuItem PDF;
    private javax.swing.JScrollPane ScrollMurid;
    private javax.swing.JTable TabelMurid;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPerbaharui;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUlangi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu sub_menu1;
    private javax.swing.JMenuItem sub_menu2;
    private javax.swing.JMenuItem sub_menu3;
    private javax.swing.JTextField txtAkutansi;
    private javax.swing.JTextField txtBiologi;
    private javax.swing.JTextField txtFisika;
    private javax.swing.JTextField txtGeografi;
    private javax.swing.JTextField txtKelas;
    private javax.swing.JTextField txtKimia;
    private javax.swing.JTextField txtMatematika;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtSosiologi;
    // End of variables declaration//GEN-END:variables
}
