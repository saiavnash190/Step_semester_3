public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (name == null || isPresent(name) || count >= presentStudents.length) {
            return;
        }
        presentStudents[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (name.equals(presentStudents[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}