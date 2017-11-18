package com.example.taeinkim.openmovieinfo;

/**
 * Created by TAEIN.KIM on 2017-10-22.
 */

public class MovieInfoListItem {

    private String rnum = null;
    private String rank = null;
    private String rankOldAndNew = null;
    private String movieNm = null;
    private String openDt = null;
    private String salesAmt = null;
    private String salesShare = null;
    private String salesAcc = null;
    private String audiCnt = null;
    private String audiAcc = null;
    private String showCnt = null;

    public MovieInfoListItem(String rnum, String rank, String rankOldAndNew, String movieNm, String openDt, String salesAmt, String salesShare, String salesAcc, String audiCnt, String audiAcc, String showCnt) {
        this.rnum = rnum;
        this.rank = rank;
        this.rankOldAndNew = rankOldAndNew;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.salesAmt = salesAmt;
        this.salesShare = salesShare;
        this.salesAcc = salesAcc;
        this.audiCnt = audiCnt;
        this.audiAcc = audiAcc;
        this.showCnt = showCnt;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRankOldAndNew() {
        return rankOldAndNew;
    }

    public void setRankOldAndNew(String rankOldAndNew) {
        this.rankOldAndNew = rankOldAndNew;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getSalesAmt() {
        return salesAmt;
    }

    public void setSalesAmt(String salesAmt) {
        this.salesAmt = salesAmt;
    }

    public String getSalesShare() {
        return salesShare;
    }

    public void setSalesShare(String salesShare) {
        this.salesShare = salesShare;
    }

    public String getSalesAcc() {
        return salesAcc;
    }

    public void setSalesAcc(String salesAcc) {
        this.salesAcc = salesAcc;
    }

    public String getAudiCnt() {
        return audiCnt;
    }

    public void setAudiCnt(String audiCnt) {
        this.audiCnt = audiCnt;
    }

    public String getAudiAcc() {
        return audiAcc;
    }

    public void setAudiAcc(String audiAcc) {
        this.audiAcc = audiAcc;
    }

    public String getShowCnt() {
        return showCnt;
    }

    public void setShowCnt(String showCnt) {
        this.showCnt = showCnt;
    }
    
}
