/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.noerkhalidah.latihanmvcjdbc.controller;

import edu.noerkhalidah.latihanmvcjdbc.entity.Pelanggan;
import edu.noerkhalidah.latihanmvcjdbc.model.PelangganModel;
import edu.noerkhalidah.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *
 * @author axioo
 * Nama : Noerkhalidah Miskiyah
 * Kelas : IF2
 * NIM : 10118077
 */
public class PelangganController {
    
    private PelangganModel model;
    
    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view) {
        model.resetPelanggan();
    }
       
    public void insertPelanggan(PelangganView view) {
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Masih Kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama Depan tak boleh lebih dari 255");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Number telepon tak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !!email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
                }
            }
        }
    
        public void updatePelanggan(PelangganView view) {
            
            //jika tidak ada yang diseleksi kasih peringatan
            if (view.getTabelPelanggan().getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan diubah");
                return;
            }
            
        Integer id = Integer.parseInt(view.getTxtId().getText());
        
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Masih Kosong");
            } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama Depan tak boleh lebih dari 255");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Number telepon tak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !!email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Diubah");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{ "Terjadi error di database dengan pesan ", e.getMessage()
                });
                }
            }
        }
        
        public void deletePelanggan(PelangganView view) {
            
             //jika tidak ada yang diseleksi kasih peringatan
            if (view.getTabelPelanggan().getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan didihapus");
                return;
            }    
                if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?") == JOptionPane.OK_OPTION) {
                Integer id = Integer.parseInt(view.getTxtId().getText());
                model.setId(id);
                    
                try {
                    model.deletePelanggan();
                    JOptionPane.showMessageDialog(view, "Pelanggan berhasil dihapus");
                    model.resetPelanggan();
             } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", e.getMessage()});
             }
        }
    
    }   
} 