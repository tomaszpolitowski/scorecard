package com.phonak.scorecard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

public class Score {

    private String username;
    private  Integer indleTime;
    @NotNull(message = "Date cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private  Integer totalTimeWorked;
    private Integer slimtipRepairs;
    private Integer cShellRepairs;
    private Integer itcRemakes;
    private Integer iteRepairs;
    private  Integer bteRicRepairs;
    private Integer iteDevicesIn;
    private Integer bteDevicesIn;
    private  Integer iteOrdersIn;
    private  Integer accessories;
    private Integer bteCreatingRepairsRaports;
    private Integer iteCreatingRepairsRaports;
    private Integer ordersScan;
    private Integer devicesOut;
    private  Integer reset;
    private Integer housingReplacement;



    public Score() { }

    public Score(String username, Integer indleTime, LocalDate date, Integer totalTimeWorked, Integer slimtipRepairs, Integer cShellRepairs, Integer itcRemakes, Integer iteRepairs, Integer bteRicRepairs, Integer iteDevicesIn, Integer bteDevicesIn, Integer iteOrdersIn, Integer accessories, Integer bteCreatingRepairsRaports, Integer iteCreatingRepairsRaports, Integer ordersScan, Integer devicesOut, Integer reset, Integer housingReplacement) {
        this.username = username;
        this.indleTime = indleTime;
        this.date = date;
        this.totalTimeWorked = totalTimeWorked;
        this.slimtipRepairs = slimtipRepairs;
        this.cShellRepairs = cShellRepairs;
        this.itcRemakes = itcRemakes;
        this.iteRepairs = iteRepairs;
        this.bteRicRepairs = bteRicRepairs;
        this.iteDevicesIn = iteDevicesIn;
        this.bteDevicesIn = bteDevicesIn;
        this.iteOrdersIn = iteOrdersIn;
        this.accessories = accessories;
        this.bteCreatingRepairsRaports = bteCreatingRepairsRaports;
        this.iteCreatingRepairsRaports = iteCreatingRepairsRaports;
        this.ordersScan = ordersScan;
        this.devicesOut = devicesOut;
        this.reset = reset;
        this.housingReplacement = housingReplacement;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Integer getIndleTime() {
        return indleTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getTotalTimeWorked() {
        return totalTimeWorked;
    }

    public Integer getSlimtipRepairs() {
        return slimtipRepairs;
    }

    public Integer getcShellRepairs() {
        return cShellRepairs;
    }

    public Integer getItcRemakes() {
        return itcRemakes;
    }

    public Integer getIteRepairs() {
        return iteRepairs;
    }

    public Integer getBteRicRepairs() {
        return bteRicRepairs;
    }

    public Integer getIteDevicesIn() {
        return iteDevicesIn;
    }

    public Integer getBteDevicesIn() {
        return bteDevicesIn;
    }

    public Integer getIteOrdersIn() {
        return iteOrdersIn;
    }

    public Integer getAccessories() {
        return accessories;
    }

    public Integer getBteCreatingRepairsRaports() {
        return bteCreatingRepairsRaports;
    }

    public Integer getIteCreatingRepairsRaports() {
        return iteCreatingRepairsRaports;
    }

    public Integer getOrdersScan() {
        return ordersScan;
    }

    public Integer getDevicesOut() {
        return devicesOut;
    }

    public Integer getReset() {
        return reset;
    }

    public Integer getHousingReplacement() {
        return housingReplacement;
    }

    public void setIndleTime(Integer indleTime) {
        this.indleTime = indleTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTotalTimeWorked(Integer totalTimeWorked) {
        this.totalTimeWorked = totalTimeWorked;
    }

    public void setSlimtipRepairs(Integer slimtipRepairs) {
        this.slimtipRepairs = slimtipRepairs;
    }

    public void setcShellRepairs(Integer cShellRepairs) {
        this.cShellRepairs = cShellRepairs;
    }

    public void setItcRemakes(Integer itcRemakes) {
        this.itcRemakes = itcRemakes;
    }

    public void setIteRepairs(Integer iteRepairs) {
        this.iteRepairs = iteRepairs;
    }

    public void setBteRicRepairs(Integer bteRicRepairs) {
        this.bteRicRepairs = bteRicRepairs;
    }

    public void setIteDevicesIn(Integer iteDevicesIn) {
        this.iteDevicesIn = iteDevicesIn;
    }

    public void setBteDevicesIn(Integer bteDevicesIn) {
        this.bteDevicesIn = bteDevicesIn;
    }

    public void setIteOrdersIn(Integer iteOrdersIn) {
        this.iteOrdersIn = iteOrdersIn;
    }

    public void setAccessories(Integer accessories) {
        this.accessories = accessories;
    }

    public void setBteCreatingRepairsRaports(Integer bteCreatingRepairsRaports) {
        this.bteCreatingRepairsRaports = bteCreatingRepairsRaports;
    }

    public void setIteCreatingRepairsRaports(Integer iteCreatingRepairsRaports) {
        this.iteCreatingRepairsRaports = iteCreatingRepairsRaports;
    }

    public void setOrdersScan(Integer ordersScan) {
        this.ordersScan = ordersScan;
    }

    public void setDevicesOut(Integer devicesOut) {
        this.devicesOut = devicesOut;
    }

    public void setReset(Integer reset) {
        this.reset = reset;
    }

    public void setHousingReplacement(Integer housingReplacement) {
        this.housingReplacement = housingReplacement;
    }
}
