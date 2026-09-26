public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678"));
        System.out.println(l.changeCode("0000", "9999"));
    }
}