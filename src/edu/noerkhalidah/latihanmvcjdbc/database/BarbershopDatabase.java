/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.noerkhalidah.latihanmvcjdbc.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.noerkhalidah.latihanmvcjdbc.entity.Pelanggan;
import edu.noerkhalidah.latihanmvcjdbc.impl.PelangganDaoImpl;
import edu.noerkhalidah.latihanmvcjdbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author axioo
 * Nama : Noerkhalidah Miskiyah
 * NIM : 10118077
 * Kelas : IF2
 * 
 */
public class BarbershopDatabase {

    private static Connection connection;
    private static PelangganDao pelangganDao;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/barbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static PelangganDao getPelangganDao() throws SQLException {
        if (pelangganDao == null) {
            pelangganDao = new PelangganDaoImpl(getConnection()) {

                @Override
                public List<Pelanggan> selectAllPelanggan() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
        }
        return pelangganDao;
    }
}
