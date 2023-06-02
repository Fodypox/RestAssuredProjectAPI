package Campus.POJO_Models;

public class Notification_Keys_Value {

    /**
     * {
     *     "id": "6479e64e60a7325b2ac0b589",
     *     "name": "Academy try qa1",
     *     "shortName": "AQA1",
     *     "multiplier": 2,
     *     "nonWorkingDaysCounted": false,
     *     "hoursRequired": false,
     *     "active": true,
     *     "turnout": false,
     *     "school": "646cbb07acf2ee0d37c6d984"
     * }
     *
     * https://test.mersys.io/school-service/api/timesheet-multiplier
     * */

    private String id;
    private String name;
    private String shortName;
    private int multiplier;
    private boolean nonWorkingDaysCounted = false;
    private boolean hoursRequired = false;
    private boolean active = true;
    private boolean turnout = false;
    private String school;

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

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public boolean isNonWorkingDaysCounted() {
        return nonWorkingDaysCounted;
    }

    public void setNonWorkingDaysCounted(boolean nonWorkingDaysCounted) {
        this.nonWorkingDaysCounted = nonWorkingDaysCounted;
    }

    public boolean isHoursRequired() {
        return hoursRequired;
    }

    public void setHoursRequired(boolean hoursRequired) {
        this.hoursRequired = hoursRequired;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isTurnout() {
        return turnout;
    }

    public void setTurnout(boolean turnout) {
        this.turnout = turnout;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Notification_Keys_Value{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", multiplier=" + multiplier +
                ", nonWorkingDaysCounted=" + nonWorkingDaysCounted +
                ", hoursRequired=" + hoursRequired +
                ", active=" + active +
                ", turnout=" + turnout +
                ", school='" + school + '\'' +
                '}';
    }


}
