package Campus.POJO_Models;

import java.util.ArrayList;

public class Fees {

    private  String id;
    private String name;
    private String code;
//    private String integrationCode;
    private String budgetAccountIntegrationCode;
    private int priority;
//    private ArrayList<TranslateName> translateName;
    private String[] translateName = {};

    private boolean active;

    public String getId(String s) {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode(String s) {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    public String getIntegrationCode(String memi) {
//        return integrationCode;
//    }

//    public void setIntegrationCode(String integrationCode) {
//        this.integrationCode = integrationCode;
//    }

    public boolean isActive(boolean b) {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPriority(int i) {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

//    public String getIntegrationCode() {
//        return integrationCode;
//    }

    public int getPriority() {
        return priority;
    }

//    public ArrayList<TranslateName> getTranslateName() {
//        return translateName;
//    }

//    public void setTranslateName(ArrayList<TranslateName> translateName) {
//        this.translateName = translateName;
//    }

    public boolean isActive() {
        return active;
    }

    public String getBudgetAccountIntegrationCode() {
        return budgetAccountIntegrationCode;
    }

    public void setBudgetAccountIntegrationCode(String budgetAccountIntegrationCode) {
        this.budgetAccountIntegrationCode = budgetAccountIntegrationCode;
    }

    public String[] getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String[] translateName) {
        this.translateName = translateName;
    }
}
