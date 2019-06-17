package com.xianqingzao.yequxiaoquan.pojo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String merchantId;
    private String merchantName;
    private String startDate;
    private String endDate;
    private String location;
    private String tags;
    private String topLimit;
    private String status;
    @NotBlank
    private String refuseReason;
    private String morningActivity;
    private String lunch;
    private String afternoonActivity;
    private String dinner;
    private String eveningActivity;

    private String singlePrice;
    private String doublePrice;
    private String treblePrice;
    private String sextuplePrice;
    private String decuplePrice;

    private String roomNum;
    private String roomPrice;
    private String bedNum;
    private String bedPrice;
    private String hotelInfo;

    private String activityPhotos;
    private String stayOverPhotos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTopLimit() {
        return topLimit;
    }

    public void setTopLimit(String topLimit) {
        this.topLimit = topLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public String getMorningActivity() {
        return morningActivity;
    }

    public void setMorningActivity(String morningActivity) {
        this.morningActivity = morningActivity;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getAfternoonActivity() {
        return afternoonActivity;
    }

    public void setAfternoonActivity(String afternoonActivity) {
        this.afternoonActivity = afternoonActivity;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getEveningActivity() {
        return eveningActivity;
    }

    public void setEveningActivity(String eveningActivity) {
        this.eveningActivity = eveningActivity;
    }

    public String getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }

    public String getDoublePrice() {
        return doublePrice;
    }

    public void setDoublePrice(String doublePrice) {
        this.doublePrice = doublePrice;
    }

    public String getTreblePrice() {
        return treblePrice;
    }

    public void setTreblePrice(String treblePrice) {
        this.treblePrice = treblePrice;
    }

    public String getSextuplePrice() {
        return sextuplePrice;
    }

    public void setSextuplePrice(String sextuplePrice) {
        this.sextuplePrice = sextuplePrice;
    }

    public String getDecuplePrice() {
        return decuplePrice;
    }

    public void setDecuplePrice(String decuplePrice) {
        this.decuplePrice = decuplePrice;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public String getBedPrice() {
        return bedPrice;
    }

    public void setBedPrice(String bedPrice) {
        this.bedPrice = bedPrice;
    }

    public String getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(String hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    public String getActivityPhotos() {
        return activityPhotos;
    }

    public void setActivityPhotos(String activityPhotos) {
        this.activityPhotos = activityPhotos;
    }

    public String getStayOverPhotos() {
        return stayOverPhotos;
    }

    public void setStayOverPhotos(String stayOverPhotos) {
        this.stayOverPhotos = stayOverPhotos;
    }
}
