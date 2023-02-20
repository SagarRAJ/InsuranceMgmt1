/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Dmv;
import com.exavalu.models.Fnol;
import com.exavalu.models.Policy;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Win10
 */
public class VerifyService {

    public static boolean doVerifyByUnderTaker(Policy policy, Dmv dmv, Fnol fnol) {

        boolean result = false;
        if ((policy.getPolicyNumber()).equals(fnol.getPolicyNumber()) && (dmv.getVehicleNumber()).equals(fnol.getVehicleNumber())) {
            int row = 0;
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurance.fnol\n"
                    + "SET\n"
                    + "emailAddress = ? ,\n"
                    + "policyNumber = ? ,\n"
                    + "description = ? ,\n"
                    + "vehicleNumber = ? ,\n"
                    + "claimNumber = ? ,\n"
                    + "approvalUnderWriterStatus = ?,\n"
                    + "approvalInsuranceOfficerStatus = ? \n"
                    + "WHERE claimNumber = ?;";

            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setString(1, fnol.getEmailAddress());
                preparedStatement.setString(2, fnol.getPolicyNumber());
                preparedStatement.setString(3, fnol.getDescription());
                preparedStatement.setString(4, fnol.getVehicleNumber());
                preparedStatement.setString(5, fnol.getClaimNumber());
                preparedStatement.setString(6, "1");
                preparedStatement.setString(7, "0");
                preparedStatement.setString(8, fnol.getClaimNumber());

                System.out.println("SQL = " + preparedStatement);
                row = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Construct the error message with date and time
                String errorMessage = timestamp.toString() + ": " + ex.getMessage();

            }

            if (row == 1) {
                result = true;
            }

        } else {
            int row = 0;
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurance.fnol\n"
                    + "SET\n"
                    + "emailAddress = ? ,\n"
                    + "policyNumber = ? ,\n"
                    + "description = ? ,\n"
                    + "vehicleNumber = ? ,\n"
                    + "claimNumber = ? ,\n"
                    + "approvalUnderWriterStatus = ?,\n"
                    + "approvalInsuranceOfficerStatus = ? \n"
                    + "WHERE claimNumber = ?;";

            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setString(1, fnol.getEmailAddress());
                preparedStatement.setString(2, fnol.getPolicyNumber());
                preparedStatement.setString(3, fnol.getDescription());
                preparedStatement.setString(4, fnol.getVehicleNumber());
                preparedStatement.setString(5, fnol.getClaimNumber());
                preparedStatement.setString(6, "2");
                preparedStatement.setString(7, "0");
                preparedStatement.setString(8, fnol.getClaimNumber());

                System.out.println("SQL = " + preparedStatement);
                row = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Construct the error message with date and time
                String errorMessage = timestamp.toString() + ": " + ex.getMessage();

            }

            if (row == 1) {
                result = true;
            }

        }

        return result;

    }

    public static boolean doVerifyByInsuranceOfficer(Policy policy, Dmv dmv, Fnol fnol) {
        boolean result = false;
        if ((policy.getPolicyNumber()).equals(fnol.getPolicyNumber()) && (dmv.getVehicleNumber()).equals(fnol.getVehicleNumber())) {
            int row = 0;
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurance.fnol\n"
                    + "SET\n"
                    + "emailAddress = ? ,\n"
                    + "policyNumber = ? ,\n"
                    + "description = ? ,\n"
                    + "vehicleNumber = ? ,\n"
                    + "claimNumber = ? ,\n"
                    + "approvalInsuranceOfficerStatus = ? \n"
                    + "WHERE claimNumber = ?;";

            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setString(1, fnol.getEmailAddress());
                preparedStatement.setString(2, fnol.getPolicyNumber());
                preparedStatement.setString(3, fnol.getDescription());
                preparedStatement.setString(4, fnol.getVehicleNumber());
                preparedStatement.setString(5, fnol.getClaimNumber());
                preparedStatement.setString(6, "1");
                preparedStatement.setString(7, fnol.getClaimNumber());

                System.out.println("SQL = " + preparedStatement);
                row = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Construct the error message with date and time
                String errorMessage = timestamp.toString() + ": " + ex.getMessage();

            }

            if (row == 1) {
                result = true;
            }

        } else {
            int row = 0;
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurance.fnol\n"
                    + "SET\n"
                    + "emailAddress = ? ,\n"
                    + "policyNumber = ? ,\n"
                    + "description = ? ,\n"
                    + "vehicleNumber = ? ,\n"
                    + "claimNumber = ? ,\n"
                    + "approvalInsuranceOfficerStatus = ? \n"
                    + "WHERE claimNumber = ?;";

            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setString(1, fnol.getEmailAddress());
                preparedStatement.setString(2, fnol.getPolicyNumber());
                preparedStatement.setString(3, fnol.getDescription());
                preparedStatement.setString(4, fnol.getVehicleNumber());
                preparedStatement.setString(5, fnol.getClaimNumber());
                preparedStatement.setString(6, "2");
                preparedStatement.setString(7, fnol.getClaimNumber());

                System.out.println("SQL = " + preparedStatement);
                row = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Construct the error message with date and time
                String errorMessage = timestamp.toString() + ": " + ex.getMessage();

            }

            if (row == 1) {
                result = true;
            }

        }

        return result;

    }

}
