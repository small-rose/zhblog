package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class SysConfig implements Serializable {
    private Long id;

    private String configModule;

    private String configCode;

    private String configName;

    private String configValue;

    private String addDate;

    private String updDate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigModule() {
        return configModule;
    }

    public void setConfigModule(String configModule) {
        this.configModule = configModule == null ? null : configModule.trim();
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode == null ? null : configCode.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate == null ? null : addDate.trim();
    }

    public String getUpdDate() {
        return updDate;
    }

    public void setUpdDate(String updDate) {
        this.updDate = updDate == null ? null : updDate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", configModule=").append(configModule);
        sb.append(", configCode=").append(configCode);
        sb.append(", configName=").append(configName);
        sb.append(", configValue=").append(configValue);
        sb.append(", addDate=").append(addDate);
        sb.append(", updDate=").append(updDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}