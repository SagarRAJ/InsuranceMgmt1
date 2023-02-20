/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Fnol;
import com.exavalu.utils.JDBCConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win10
 */
public class FnolService {

    public static boolean doLogFnol(Fnol fnol) {
        boolean result = false;
        String sql = "INSERT INTO insurance.fnol(emailAddress,policyNumber,description,vehicleNumber)\n"
                + "VALUES\n"
                + "(? ,\n"
                + "? ,\n"
                + "? ,\n"
                + "?)";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            System.out.println(fnol.getEmailAddress());
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, fnol.getEmailAddress());
            prepareStatement.setString(2, fnol.getPolicyNumber());
            prepareStatement.setString(3, fnol.getDescription());
            prepareStatement.setString(4, fnol.getVehicleNumber());
            int success = prepareStatement.executeUpdate();

            if (success == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FnolService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static ArrayList doViewLogedFnol() {
        ArrayList fnollist = new ArrayList<>();
        String sql = "SELECT f.*, s1.underwritermessage, s2.insurranceofficermessage FROM fnol f\n"
                + "INNER JOIN status s1 ON f.approvalUnderWriterStatus = s1.statusId \n"
                + "INNER JOIN status s2 ON f.approvalInsuranceOfficerStatus = s2.statusId;";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Fnol fnol = new Fnol();
                fnol.setEmailAddress(rs.getString("emailAddress"));
                fnol.setClaimNumber(rs.getString("claimNumber"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setDescription(rs.getString("description"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setApprovalByUnderWriterMessage(rs.getString("underwritermessage"));
                fnollist.add(fnol);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FnolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fnollist;
    }

//    public static boolean doEditFnol(Fnol fnol) {
//        boolean success = false;
//        String sql = ""
//
//    }
    public static ArrayList doViewLogedFnolOfficer() {

        ArrayList fnollist = new ArrayList<>();
        String sql = "SELECT f.*, s1.underwritermessage, s2.insurranceofficermessage FROM fnol f\n"
                + "INNER JOIN status s1 ON f.approvalUnderWriterStatus = s1.statusId \n"
                + "INNER JOIN status s2 ON f.approvalInsuranceOfficerStatus = s2.statusId;";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Fnol fnol = new Fnol();
                fnol.setEmailAddress(rs.getString("emailAddress"));
                fnol.setClaimNumber(rs.getString("claimNumber"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setDescription(rs.getString("description"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setApprovalByUnderWriterMessage(rs.getString("underwritermessage"));
                fnol.setApprovalByInsuranceOfficerMessage(rs.getString("insurranceofficermessage"));
                fnollist.add(fnol);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FnolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fnollist;
    }

    public static ArrayList doShowPreviousClaim(Fnol fnl) {
        ArrayList fnollist = new ArrayList<>();
        String email = fnl.getEmailAddress();
        System.out.println(email);
        String sql = "SELECT f.*, s1.underwritermessage, s2.insurranceofficermessage FROM fnol f\n"
                + "                 INNER JOIN status s1 ON f.approvalUnderWriterStatus = s1.statusId \n"
                + "                 INNER JOIN status s2 ON f.approvalInsuranceOfficerStatus = s2.statusId\n"
                + "                 where emailAddress=?";
        System.out.println(sql);
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, email);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Fnol fnol = new Fnol();
                fnol.setEmailAddress(rs.getString("emailAddress"));
                fnol.setClaimNumber(rs.getString("claimNumber"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setDescription(rs.getString("description"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setApprovalByUnderWriterMessage(rs.getString("underwritermessage"));
                fnol.setApprovalByInsuranceOfficerMessage(rs.getString("insurranceofficermessage"));
                fnollist.add(fnol);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FnolService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fnollist;
    }
}
