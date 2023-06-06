package Campus.POJO_Models;

import java.util.Arrays;

public class Countries {

    // some test nor run properly!!
//create
    // "id": "647eae357ee68a6ee672a1b2",
    //    "name": "London",
    //    "shortName": null,
    //    "translateName": [],
    //    "code": "10",
    //    "hasState": true

//create
    // "id": "647eb10c7ee68a6ee672a1b6",
    //    "name": "Pittsburgh",
    //    "shortName": null,
    //    "translateName": [],
    //    "code": "10",
    //    "hasState": true

    private String id;
    private String name;
    private String shortName;
    private String[] translateName={};
    private String code;
    private boolean hasState;


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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String[] getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String[] translateName) {
        this.translateName = translateName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isHasState() {
        return hasState;
    }

    public void setHasState(boolean hasState) {
        this.hasState = hasState;
    }


    @Override
    public String toString() {
        return "Countries{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", translateName=" + Arrays.toString(translateName) +
                ", code='" + code + '\'' +
                ", hasState=" + hasState +
                '}';
    }
}
