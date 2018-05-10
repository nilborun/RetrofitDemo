package com.example.bs0158.galleryapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User{


    @SerializedName("EmployeeId")

    private Integer employeeId;
    @SerializedName("EmployeeCode")

    private String employeeCode;
    @SerializedName("DepartmentId")
    @Expose
    private Integer departmentId;
    @SerializedName("DepartmentName")

    private String departmentName;
    @SerializedName("DesignationId")

    private Integer designationId;
    @SerializedName("DesignationTitle")

    private String designationTitle;
    @SerializedName("RoleId")

    private Integer roleId;
    @SerializedName("RoleTitle")

    private String roleTitle;
    @SerializedName("EmployeeName")

    private String employeeName;
    @SerializedName("JobLocation")

    private String jobLocation;
    @SerializedName("PhoneNumber")

    private String phoneNumber;
    @SerializedName("Email")

    private String email;
    @SerializedName("ImagePath")

    private Object imagePath;
    @SerializedName("BloodGroup")

    private String bloodGroup;
    @SerializedName("OfficeNumber")
    private String officeNumber;

        public Integer getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(Integer employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeCode() {
            return employeeCode;
        }

        public void setEmployeeCode(String employeeCode) {
            this.employeeCode = employeeCode;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public Integer getDesignationId() {
            return designationId;
        }

        public void setDesignationId(Integer designationId) {
            this.designationId = designationId;
        }

        public String getDesignationTitle() {
            return designationTitle;
        }

        public void setDesignationTitle(String designationTitle) {
            this.designationTitle = designationTitle;
        }

        public Integer getRoleId() {
            return roleId;
        }

        public void setRoleId(Integer roleId) {
            this.roleId = roleId;
        }

        public String getRoleTitle() {
            return roleTitle;
        }

        public void setRoleTitle(String roleTitle) {
            this.roleTitle = roleTitle;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getJobLocation() {
            return jobLocation;
        }

        public void setJobLocation(String jobLocation) {
            this.jobLocation = jobLocation;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getImagePath() {
            return imagePath;
        }

        public void setImagePath(Object imagePath) {
            this.imagePath = imagePath;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public void setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
        }

        public String getOfficeNumber() {
            return officeNumber;
        }

        public void setOfficeNumber(String officeNumber) {
            this.officeNumber = officeNumber;
        }


}
