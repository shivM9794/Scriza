package com.example.scriza.RepositoryModel.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("scheme_id")
    @Expose
    private Integer schemeId;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("company_id")
    @Expose
    private Integer companyId;
    @SerializedName("email_verified_at")
    @Expose
    private Object emailVerifiedAt;
    @SerializedName("two_factor_confirmed_at")
    @Expose
    private Object twoFactorConfirmedAt;
    @SerializedName("current_team_id")
    @Expose
    private Object currentTeamId;
    @SerializedName("profile_photo_path")
    @Expose
    private Object profilePhotoPath;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("active")
    @Expose
    private int active;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("profile_photo_url")
    @Expose
    private String profilePhotoUrl;
    @SerializedName("tokens")
    @Expose
    private List<Token> tokens;

    public User(Integer id, String name, String email, String mobile, Integer schemeId, Integer roleId, Integer companyId, Object emailVerifiedAt, Object twoFactorConfirmedAt, Object currentTeamId, Object profilePhotoPath, Integer parentId, Integer active, String createdAt, String updatedAt, String profilePhotoUrl, List<Token> tokens) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.schemeId = schemeId;
        this.roleId = roleId;
        this.companyId = companyId;
        this.emailVerifiedAt = emailVerifiedAt;
        this.twoFactorConfirmedAt = twoFactorConfirmedAt;
        this.currentTeamId = currentTeamId;
        this.profilePhotoPath = profilePhotoPath;
        this.parentId = parentId;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.profilePhotoUrl = profilePhotoUrl;
        this.tokens = tokens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public Object getTwoFactorConfirmedAt() {
        return twoFactorConfirmedAt;
    }

    public void setTwoFactorConfirmedAt(Object twoFactorConfirmedAt) {
        this.twoFactorConfirmedAt = twoFactorConfirmedAt;
    }

    public Object getCurrentTeamId() {
        return currentTeamId;
    }

    public void setCurrentTeamId(Object currentTeamId) {
        this.currentTeamId = currentTeamId;
    }

    public Object getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(Object profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
