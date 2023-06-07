package Campus.POJO_Models;

public class GradeLevel {
    //{
    //    "id": "647feb52e4cfbb0586750d92",
    //    "name": "wqeqwewqedssa",
    //    "order": 11,
    //    "shortName": "qwq",
    //    "nextGradeLevel": {
    //        "id": "646cca8aacf2ee0d37c6d998",
    //        "name": null,
    //        "order": 0,
    //        "shortName": null,
    //        "nextGradeLevel": null,
    //        "active": false,
    //        "translateName": null,
    //        "translateShortName": null,
    //        "tenantId": null,
    //        "schoolIds": null,
    //        "showToAllSchools": false,
    //        "maxApplicationCount": null
    //    },
    //    "active": true,
    //    "translateName": [],
    //    "translateShortName": [],
    //    "tenantId": "646cb816433c0f46e7d44cb0",
    //    "schoolIds": [
    //        "646cbb07acf2ee0d37c6d984"
    //    ],
    //    "showToAllSchools": false,
    //    "maxApplicationCount": 11
    //}

    private String id=null;

    private String name;
    private int order;
    private String shortName;
    private void nextGradeLevel(){
         String id="646cca8aacf2ee0d37c6d998";
         String name=null;
         int order=0;
         String shortName=null;
         String nextGradeLevel=null;
         boolean active=false;
         String translateName=null;
         String translateShortName=null;
         String tenantId=null;
         String schoolIds=null;
         boolean showToAllSchools=false;
         String maxApplicationCount=null;
    }
    private boolean active=true;
    private String[] translateName;
    private String[] translateShortName;
    private String tenantId="646cb816433c0f46e7d44cb0";
    private String[] schoolIds={"646cbb07acf2ee0d37c6d984"};
    private boolean showToAllSchools=false;
    private int maxApplicationCount=11;

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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String[] getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String[] translateName) {
        this.translateName = translateName;
    }

    public String[] getTranslateShortName() {
        return translateShortName;
    }

    public void setTranslateShortName(String[] translateShortName) {
        this.translateShortName = translateShortName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String[] getSchoolIds() {
        return schoolIds;
    }

    public void setSchoolIds(String[] schoolIds) {
        this.schoolIds = schoolIds;
    }

    public boolean isShowToAllSchools() {
        return showToAllSchools;
    }

    public void setShowToAllSchools(boolean showToAllSchools) {
        this.showToAllSchools = showToAllSchools;
    }

    public int getMaxApplicationCount() {
        return maxApplicationCount;
    }

    public void setMaxApplicationCount(int maxApplicationCount) {
        this.maxApplicationCount = maxApplicationCount;
    }
}
