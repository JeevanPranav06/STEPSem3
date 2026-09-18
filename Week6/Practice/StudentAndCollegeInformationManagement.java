public class StudentAndCollegeInformationManagement {

    static class Student {
        String name;
        int attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        Student first = new Student("Ravi", 90);
        Student second = new Student("Anitha", 85);
        Student.printCollegeInfo();
    }
}
