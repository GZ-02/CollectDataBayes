package com.example.georgia.collectdatabayes;

/**
 * Created by Georgia on 06-Mar-18.
 */

public class SensorsTable {

    private String _tmst;
    private  String LocalTime;
    private int _key;
    private String _SSID;
    private String _RSSI;
    private String cellNo;

    //Class constructors
    public SensorsTable(){

    }

    public SensorsTable(String _tmst,String LocalTime,String SSID,String RSSI,String cellNo) {
        this._tmst=_tmst;
        this.LocalTime=LocalTime;
        this._SSID=SSID;
        this._RSSI=RSSI;
        this.cellNo=cellNo;
    }

    //Methods to set and get table variables
    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }


    public void setLocalTime(String localTime) {
        LocalTime = localTime;
    }

    public void set_tmst(String _tmst) {
        this._tmst = _tmst;
    }

    public void set_key(int _key) {
        this._key = _key;
    }

    public void set_SSID(String _SSID) {
        this._SSID = _SSID;
    }

    public void set_RSSI(String _RSSI) {
        this._RSSI = _RSSI;
    }

    public String getLocalTime() {
        return LocalTime;
    }

    public String get_tmst() {
        return _tmst;
    }

    public int get_key() {
        return _key;
    }

    public String get_SSID() {
        return _SSID;
    }

    public String get_RSSI() {
        return _RSSI;
    }

    public String getCellNo() {
        return cellNo;
    }

}
