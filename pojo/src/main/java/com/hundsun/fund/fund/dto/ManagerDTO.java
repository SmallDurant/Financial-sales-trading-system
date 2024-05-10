package com.hundsun.fund.fund.dto;
import java.time.LocalDate;
public class ManagerDTO {
    private Long managerId;
    private String managerName;
    private String introduction;
    private LocalDate birthday;
    private String photo;
    private Byte educationalBackground;
    private Boolean isDelete;

    // 构造函数
    public ManagerDTO() {
    }

    // 带所有参数的构造函数，用于方便地创建DTO对象
    public ManagerDTO(Long managerId, String managerName, String introduction, LocalDate birthday,
                      String photo, Byte educationalBackground, Boolean isDelete) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.introduction = introduction;
        this.birthday = birthday;
        this.photo = photo;
        this.educationalBackground = educationalBackground;
        this.isDelete = isDelete;
    }

    // Getter和Setter方法
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Byte getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(Byte educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    // toString方法，用于打印DTO的信息
    @Override
    public String toString() {
        return "ManagerDTO{" +
                "managerId=" + managerId +
                ", managerName='" + managerName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", birthday=" + birthday +
                ", photo='" + photo + '\'' +
                ", educationalBackground=" + educationalBackground +
                ", isDelete=" + isDelete +
                '}';
    }
}
