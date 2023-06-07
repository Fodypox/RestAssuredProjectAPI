package Campus.POJO_Models;

import java.util.Arrays;

public class Discounts {

    /** {"id":"647fdea1e4cfbb0586750d80",
     * "description":"leblebi",
     * "code":"kafa",
     * "translateDescription":[],
     * "active":true,
     * "priority":10,
     * "tenantId":"646cb816433c0f46e7d44cb0"}*/
    private String id;

    private String description;

    private String code;

    private String[] translateDescription={};

    private boolean active = true;
    private int priority = 1;

    private String tenantId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String[] getTranslateDescription() {
        return translateDescription;
    }

    public void setTranslateDescription(String[] translateDescription) {
        this.translateDescription = translateDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", translateDescription=" + Arrays.toString(translateDescription) +
                ", active=" + active +
                ", priority=" + priority +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}

