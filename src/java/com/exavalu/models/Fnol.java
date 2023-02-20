/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DmvService;
import com.exavalu.services.FnolService;
import com.exavalu.services.PolicyService;
import com.exavalu.services.VerifyService;
import static com.opensymphony.xwork2.Action.NONE;
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
public class Fnol extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

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
    private String policyNumber;
    private String description;
    private String vehicleNumber;
    private String claimNumber;
    private String approvalByUnderWriterMessage;
    private String approvalByInsuranceOfficerMessage;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getApprovalByUnderWriterMessage() {
        return approvalByUnderWriterMessage;
    }

    public void setApprovalByUnderWriterMessage(String approvalByUnderWriterMessage) {
        this.approvalByUnderWriterMessage = approvalByUnderWriterMessage;
    }

    public String getApprovalByInsuranceOfficerMessage() {
        return approvalByInsuranceOfficerMessage;
    }

    public void setApprovalByInsuranceOfficerMessage(String approvalByInsuranceOfficerMessage) {
        this.approvalByInsuranceOfficerMessage = approvalByInsuranceOfficerMessage;
    }

    public String doLogfnol() {
        String result = "Failure";
        System.out.println(this.getEmailAddress());
        boolean logFnol = FnolService.doLogFnol(this);
        if (logFnol == true) {
            User user = new User();
            user.setRoleId("1");
            user.setEmailAddress(this.getEmailAddress());
            sessionMap.put("User", user);
            result = "SUCCESS";

        }
        return result;

    }

    public String doVerifyfnol() throws Exception {
        String result = "FAILURE";
        Policy policy = PolicyService.doFetchPolicy();
        Dmv dmv = DmvService.doFetchDmv();
        boolean verify = VerifyService.doVerifyByUnderTaker(policy, dmv, this);
        if (verify == true) {
            result = "SUCCESS";
        }

        return result;
    }

    public String doVerifyfnolio() throws Exception {
        String result = "FAILURE";
        Policy policy = PolicyService.doFetchPolicy();
        Dmv dmv = DmvService.doFetchDmv();
        boolean verify = VerifyService.doVerifyByInsuranceOfficer(policy, dmv, this);
        if (verify == true) {
            result = "SUCCESS";
        }

        return result;
    }

    public String doShowpreviousclaim() {
        String result = "FAILURE";
        System.out.println("this is email:" + this.getEmailAddress());
        ArrayList fnollist = FnolService.doShowPreviousClaim(this);
        if (fnollist != null) {
            sessionMap.put("FnolList", fnollist);
            result = "SUCCESS";
            User user = new User();
            user.setRoleId("1");
            sessionMap.put("User", user);
        }
        return result;
    }
}
