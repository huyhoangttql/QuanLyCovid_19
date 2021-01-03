/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author levietdung
 */
public class DayModel {
    
    private String year;
    private String month;
    private String day;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
    @Override
    public String toString(){
        return this.day + "/" + this.month + "/" + this.year;
    }
    
    public ArrayList<String> getDayInMonth(){
        ArrayList<String> days = new ArrayList<String>();
        switch(this.getMonth()){
            case "1":
            case "3":
            case "5":
            case "7":
            case "8":
            case "10":
            case "12":
                for (int i = 1; i <= 31; i++){
                    if (i <= 9){
                        days.add("0" + i);
                    } else {
                        days.add(" " + i);
                    }
                }
                break;
            case "4":
            case "6":
            case "9":
            case "11":
                for (int i = 1; i <= 30; i++){
                    if (i <= 9){
                        days.add("0" + i);
                    } else {
                        days.add(" " + i);
                    }
                }
                break;
            case "2":
                for (int i = 1; i <= 28; i++){
                    if (i <= 9){
                        days.add("0" + i);
                    } else {
                        days.add(" " + i);
                    }
                }
                break;
        }
        return days;
    }
}
