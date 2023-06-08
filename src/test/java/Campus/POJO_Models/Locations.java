package Campus.POJO_Models;

public class Locations {

    //"id": "647eafea7ee68a6ee672a1b4",
    //    "deleted": false,
    //    "name": "Voronezh",
    //    "shortName": "Vor",
    //    "capacity": 60,
    //    "active": true,
    //    "school": "646cbb07acf2ee0d37c6d984",
    //    "type": "LABORATORY"

    private String id;
    private String name;
    private String shortName;
    private boolean active = false;
    private int capacity = 120;
    private String type = "CLASS";
    private String school = "6390f3207a3bcb6a7ac977f9";

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", active=" + active +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}