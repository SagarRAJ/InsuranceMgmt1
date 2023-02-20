/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Role;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Win10
 */
public class RoleService {

    private static final Logger log = Logger.getLogger(RoleService.class);

    public static ArrayList getAllRoles() {
        ArrayList roleList = new ArrayList<>();
        String sql = "Select * from insurance.roles";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setRoleId(rs.getString("roleId"));
                role.setRoleName(rs.getString("roleName"));
                System.out.println(role.getRoleId());
                System.out.println(role.getRoleName());
                roleList.add(role);
            }
        } catch (SQLException ex) {

        }

        return roleList;
    }

}
