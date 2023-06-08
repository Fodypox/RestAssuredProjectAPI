package Campus.POJO_Models;

import java.util.Arrays;

public class Fields {

    //"id": "647eb19d7ee68a6ee672a1b7",
    //    "schoolId": "646cbb07acf2ee0d37c6d984",
    //    "name": "SomeField",
    //    "translateName": [],
    //    "code": "10",
    //    "type": "STRING",
    //    "listElements": null,
    //    "systemField": false,
    //    "systemFieldName": null,
    //    "children": []

    private String id;
    private String name;
    private String code;
    private String type;
    private String schoolId;

    private String[] translateName={};
    private String[] children={};
    private String systemFieldName;
    private boolean systemField;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String[] getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String[] translateName) {
        this.translateName = translateName;
    }

    public String[] getChildren() {
        return children;
    }

    public void setChildren(String[] children) {
        this.children = children;
    }

    public String getSystemFieldName() {
        return systemFieldName;
    }

    public void setSystemFieldName(String systemFieldName) {
        this.systemFieldName = systemFieldName;
    }

    public boolean isSystemField() {
        return systemField;
    }

    public void setSystemField(boolean systemField) {
        this.systemField = systemField;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", translateName=" + Arrays.toString(translateName) +
                ", children=" + Arrays.toString(children) +
                ", systemFieldName='" + systemFieldName + '\'' +
                ", systemField=" + systemField +
                '}';
    }
}
