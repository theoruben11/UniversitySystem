public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 30, 40);
        Course course2 = new Course("Database Systems", 25, 35);
        Course course3 = new Course("Python", 20, 30);

        course1.displayCourseInfo();
        course2.displayCourseInfo();
        course3.displayCourseInfo();

        System.out.println("-----------------------------------");
        System.out.println("OVERALL UNIVERSITY STATISTICS");
        System.out.println("Total number of students enrolled (all courses combined): "
                + Course.getTotalStudentsAllCourses());
        System.out.println("Number of courses created: " + Course.getCourseCount());
    }
}

class Course {
    private String courseName;
    private int studentsRegistered;
    private int capacity;

    private static int totalStudentsAllCourses = 0;
    private static int courseCount = 0;
    private static double totalFillRateSum = 0;

    public Course(String courseName, int studentsRegistered, int capacity) {
        this.courseName = courseName;
        this.studentsRegistered = studentsRegistered;
        this.capacity = capacity;
        totalStudentsAllCourses += studentsRegistered;
        courseCount++;
        totalFillRateSum += (studentsRegistered / (double) capacity) * 100.0;
    }

    public double calculateFillRate() {
        return (studentsRegistered / (double) capacity) * 100.0;
    }

    public void displayCourseInfo() {
        double fillRate = calculateFillRate();

        System.out.println("Course: " + courseName);
        System.out.println("  Students enrolled: " + studentsRegistered + " / " + capacity);
        System.out.println("  Fill rate: " + String.format("%.1f", fillRate) + "%");
    }

    public static int getTotalStudentsAllCourses() {
        return totalStudentsAllCourses;
    }

    public static int getCourseCount() {
        return courseCount;
    }
    public static double getAverageFillRate() {
        return totalFillRateSum / courseCount;
    }
}