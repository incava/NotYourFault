package com.incava.notyourfault;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ShelterItem implements Serializable {

    String rprsTelno;
    //대표전화번호

    String fxno;
    //팩스번호

    String emlAddr;
    //이메일주소

    String cpctCnt;
    //정원수

    String etrTrgtCn;
    //입소대상내용

    String etrPrdCn;
    //입소기간내용

    String nrbSbwNm;
    //인근지하철명

    String nrbBusStnNm;
    //인근버스정류장명

    String crtrYmd;
    //기준일자

    String expsrYn;
    //노출여부

    String rmrkCn;
    //비고

    String fcltNm;
    //시설명

    String operModeCn;
    //운영형태내용

    String fcltTypeNm;
    //시설유형내용

    String ctpvNm;
    //시도명

    String sggNm;
    //시군구명

    String roadNmAddr;
    //도로명주소

    String lotnoAddr;
    //지번주소

    String lat;
    //위도

    String lot;
    //경도

    String hmpgAddr;
    //홈페이지주소


    public String getRprsTelno() {
        return rprsTelno;
    }

    public void setRprsTelno(String rprsTelno) {
        this.rprsTelno = rprsTelno;
    }

    public String getFxno() {
        return fxno;
    }

    public void setFxno(String fxno) {
        this.fxno = fxno;
    }

    public String getEmlAddr() {
        return emlAddr;
    }

    public void setEmlAddr(String emlAddr) {
        this.emlAddr = emlAddr;
    }

    public String getCpctCnt() {
        return cpctCnt;
    }

    public void setCpctCnt(String cpctCnt) {
        this.cpctCnt = cpctCnt;
    }

    public String getEtrTrgtCn() {
        return etrTrgtCn;
    }

    public void setEtrTrgtCn(String etrTrgtCn) {
        this.etrTrgtCn = etrTrgtCn;
    }

    public String getEtrPrdCn() {
        return etrPrdCn;
    }

    public void setEtrPrdCn(String etrPrdCn) {
        this.etrPrdCn = etrPrdCn;
    }

    public String getNrbSbwNm() {
        return nrbSbwNm;
    }

    public void setNrbSbwNm(String nrbSbwNm) {
        this.nrbSbwNm = nrbSbwNm;
    }

    public String getNrbBusStnNm() {
        return nrbBusStnNm;
    }

    public void setNrbBusStnNm(String nrbBusStnNm) {
        this.nrbBusStnNm = nrbBusStnNm;
    }

    public String getCrtrYmd() {
        return crtrYmd;
    }

    public void setCrtrYmd(String crtrYmd) {
        this.crtrYmd = crtrYmd;
    }

    public String getExpsrYn() {
        return expsrYn;
    }

    public void setExpsrYn(String expsrYn) {
        this.expsrYn = expsrYn;
    }

    public String getRmrkCn() {
        return rmrkCn;
    }

    public void setRmrkCn(String rmrkCn) {
        this.rmrkCn = rmrkCn;
    }

    public String getFcltNm() {
        return fcltNm;
    }

    public void setFcltNm(String fcltNm) {
        this.fcltNm = fcltNm;
    }

    public String getOperModeCn() {
        return operModeCn;
    }

    public void setOperModeCn(String operModeCn) {
        this.operModeCn = operModeCn;
    }

    public String getFcltTypeNm() {
        return fcltTypeNm;
    }

    public void setFcltTypeNm(String fcltTypeNm) {
        this.fcltTypeNm = fcltTypeNm;
    }

    public String getCtpvNm() {
        return ctpvNm;
    }

    public void setCtpvNm(String ctpvNm) {
        this.ctpvNm = ctpvNm;
    }

    public String getSggNm() {
        return sggNm;
    }

    public void setSggNm(String sggNm) {
        this.sggNm = sggNm;
    }

    public String getRoadNmAddr() {
        return roadNmAddr;
    }

    public void setRoadNmAddr(String roadNmAddr) {
        this.roadNmAddr = roadNmAddr;
    }

    public String getLotnoAddr() {
        return lotnoAddr;
    }

    public void setLotnoAddr(String lotnoAddr) {
        this.lotnoAddr = lotnoAddr;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getHmpgAddr() {
        return hmpgAddr;
    }

    public void setHmpgAddr(String hmpgAddr) {
        this.hmpgAddr = hmpgAddr;
    }

    public ShelterItem(){

    }

    public ShelterItem(String rprsTelno, String fxno, String emlAddr, String cpctCnt, String etrTrgtCn,
                       String etrPrdCn, String nrbSbwNm, String nrbBusStnNm, String crtrYmd, String expsrYn,
                       String rmrkCn, String fcltNm, String operModeCn, String fcltTypeNm, String ctpvNm,
                       String sggNm, String roadNmAddr, String lotnoAddr, String lat, String lot,
                       String hmpgAddr) {
        this.rprsTelno = rprsTelno;
        this.fxno = fxno;
        this.emlAddr = emlAddr;
        this.cpctCnt = cpctCnt;
        this.etrTrgtCn = etrTrgtCn;
        this.etrPrdCn = etrPrdCn;
        this.nrbSbwNm = nrbSbwNm;
        this.nrbBusStnNm = nrbBusStnNm;
        this.crtrYmd = crtrYmd;
        this.expsrYn = expsrYn;
        this.rmrkCn = rmrkCn;
        this.fcltNm = fcltNm;
        this.operModeCn = operModeCn;
        this.fcltTypeNm = fcltTypeNm;
        this.ctpvNm = ctpvNm;
        this.sggNm = sggNm;
        this.roadNmAddr = roadNmAddr;
        this.lotnoAddr = lotnoAddr;
        this.lat = lat;
        this.lot = lot;
        this.hmpgAddr = hmpgAddr;
    }
}
