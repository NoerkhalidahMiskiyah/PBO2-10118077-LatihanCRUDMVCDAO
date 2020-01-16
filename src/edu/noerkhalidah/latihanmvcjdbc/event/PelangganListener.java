/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.noerkhalidah.latihanmvcjdbc.event;

import edu.noerkhalidah.latihanmvcjdbc.entity.Pelanggan;
import edu.noerkhalidah.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * @author axioo
 * Nama : Noerkhalidah Miskiyah
 * Nim : 10118077
 * Kelas : IF2
 */
public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    
    public void onInsert(Pelanggan pelanggan);
    
    public void onUpdate(Pelanggan pelanggan);
    
    public void onDelete();
}
