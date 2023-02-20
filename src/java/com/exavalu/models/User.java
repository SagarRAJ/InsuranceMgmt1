/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.FnolService;
import com.exavalu.services.LoginService;
import com.exavalu.services.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Win10
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private static final Logger log = Logger.getLogger(User.class.getName());

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
        sessionMap.put("Loggedin", NONE);
    }
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String roleId;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String doPresignup() {
        String result = "FAILURE";
        ArrayList roleList = RoleService.getAllRoles();
        if (roleList != null) {
            sessionMap.put("RoleList", roleList);
            System.out.println(roleList);
            result = "SUCCESS";
        }

        return result;
    }

    public String doSignup() {
        String result = "FAILURE";
        boolean sign = LoginService.doSignUp(this);
        if (sign == true) {
            result = "SUCCESS";
        }
        return result;
    }

    public String doLogin() {
        String result = "FAILURE";
        boolean log = LoginService.doLogIn(this);
        sessionMap.put("User", this);
        sessionMap.put("Loggedin", this);

        if (log == true) {
            result = "SUCCESS";
        }
        return result;

    }

    public String doLogout() {
        String result = "SUCCESS";
        sessionMap.clear();
        return result;
    }

    public String doPrefnol() {
        String result = "FAILURE";
        System.out.println(this.emailAddress);
        sessionMap.put("EmailAddress", this.emailAddress);
        result = "SUCCESS";
        return result;

    }

    public String doViewlogedfnol() {
        String result = "FAILURE";
        ArrayList fnollist = FnolService.doViewLogedFnol();
        if (fnollist != null) {
            sessionMap.put("FnolList", fnollist);
            User user = new User();
            user.setRoleId("2");
            sessionMap.put("User", user);
            result = "SUCCESS";
        }

        return result;
    }

    public String doViewlogedfnolinsuranceofficer() {
        String result = "FAILURE";
        ArrayList fnollist = FnolService.doViewLogedFnolOfficer();
        if (fnollist != null) {
            sessionMap.put("FnolList", fnollist);
            User user = new User();
            user.setRoleId("3");
            sessionMap.put("User", user);
            result = "SUCCESS";
        }

        return result;
    }

}
