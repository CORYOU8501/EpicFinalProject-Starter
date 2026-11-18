public class TacticalOperator {

    private String callSign;
    private String specialty;
    private int readinessLevel;
    private String missionZone;

    // Constructor
    public TacticalOperator(String callSign, String specialty,
                            int readinessLevel, String missionZone) {
        this.callSign = callSign;
        this.specialty = specialty;
        this.readinessLevel = readinessLevel;
        this.missionZone = missionZone;
    }

    // Getters and setters
    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getReadinessLevel() {
        return readinessLevel;
    }

    public void setReadinessLevel(int readinessLevel) {
        this.readinessLevel = readinessLevel;
    }

    public String getMissionZone() {
        return missionZone;
    }

    public void setMissionZone(String missionZone) {
        this.missionZone = missionZone;
    }

    // Display an operator's mission information
    public void displayOperator() {
        System.out.println("----------------------------");
        System.out.println("Call Sign: " + callSign);
        System.out.println("Specialty: " + specialty);
        System.out.println("Readiness: " + readinessLevel + "%");
        System.out.println("Mission Zone: " + missionZone);
        System.out.println("----------------------------");
    }
}
