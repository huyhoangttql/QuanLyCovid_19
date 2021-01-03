/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhaiBaoYTe {
    private String ID;
    private String status;
    private String infectedFrom;
    private String recoveredConfirm;
    private String treatingPlace;
    private String quarantineStartDate;
    private String quarantineFinishDate;
    private String quarantinePlace;

    public KhaiBaoYTe(String id, String hoten, String infectedfrom, String recoveredconfirm, String treatingplace, 
                      String quarantinestartdate, String quarantinefinishdate, String quarantineplace) {
        this.ID = id;
        this.status = hoten;
        this.infectedFrom = infectedfrom;
        this.recoveredConfirm = recoveredconfirm;
        this.treatingPlace = treatingplace;
        this.quarantineStartDate = quarantinestartdate;
        this.quarantineFinishDate = quarantinefinishdate;
        this.quarantinePlace = quarantineplace;
    }
    
    public KhaiBaoYTe(String hoten, String infectedfrom, String recoveredconfirm, String treatingplace, 
                      String quarantinestartdate, String quarantinefinishdate, String quarantineplace) {        
        this.status = hoten;
        this.infectedFrom = infectedfrom;
        this.recoveredConfirm = recoveredconfirm;
        this.treatingPlace = treatingplace;
        this.quarantineStartDate = quarantinestartdate;
        this.quarantineFinishDate = quarantinefinishdate;
        this.quarantinePlace = quarantineplace;
    }

    public String getID() {
        return ID;
    }

    public String getStatus() {
        return status;
    }

    public String getInfectedFrom() {
        if (this.infectedFrom == null){
            return "-";
        }
        return this.infectedFrom;
    }

    public String getRecoveredConfirm() {
        if (this.recoveredConfirm == null){
            return "-";
        }
        return this.recoveredConfirm;
    }

    public String getTreatingPlace() {
        if (this.treatingPlace == null){
            return "-";
        }
        return treatingPlace;
    }

    public String getQuarantineStartDate() {
        if (this.quarantineStartDate == null){
            return "-";
        }
        return this.quarantineStartDate;
    }

    public String getQuarantineFinishDate() {
        if (this.quarantineFinishDate == null){
            return "-";
        }
        return this.quarantineFinishDate;
    }

    public String getQuarantinePlace() {
        if (this.quarantinePlace == null){
            return "-";
        }
        return quarantinePlace;
    }
}


