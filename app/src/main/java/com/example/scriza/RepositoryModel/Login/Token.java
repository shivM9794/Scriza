package com.example.scriza.RepositoryModel.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Token {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tokenable_type")
    @Expose
    private String tokenableType;
    @SerializedName("tokenable_id")
    @Expose
    private Integer tokenableId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("abilities")
    @Expose
    private List<String> abilities;
    @SerializedName("last_used_at")
    @Expose
    private Object lastUsedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Token(Integer id, String tokenableType, Integer tokenableId, String name, List<String> abilities, Object lastUsedAt, String createdAt, String updatedAt) {
        this.id = id;
        this.tokenableType = tokenableType;
        this.tokenableId = tokenableId;
        this.name = name;
        this.abilities = abilities;
        this.lastUsedAt = lastUsedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTokenableType() {
        return tokenableType;
    }

    public void setTokenableType(String tokenableType) {
        this.tokenableType = tokenableType;
    }

    public Integer getTokenableId() {
        return tokenableId;
    }

    public void setTokenableId(Integer tokenableId) {
        this.tokenableId = tokenableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public Object getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(Object lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
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
}
