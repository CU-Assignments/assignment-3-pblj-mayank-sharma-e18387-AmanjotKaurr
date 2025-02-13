import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class UniversityEnrollmentSystem {
    private static final int MAX_ENROLLMENT = 5;
    private static HashMap<String, HashSet<String>> coursePrerequisites = new HashMap<>();
    private static HashMap<String, Integer> courseEnrollment = new HashMap<>();
    private static HashSet<String> completedCourses = new HashSet<>();
    
    static {
        coursePrerequisites.put("Advanced Java", new HashSet<>() {{ add("Core Java"); }});
        courseEnrollment.put("Advanced Java", 3); 
    }

    public static void enroll(String course) throws CourseFullException, PrerequisiteNotMetException {
        if (courseEnrollment.getOrDefault(course, 0) >= MAX_ENROLLMENT) {
            throw new CourseFullException("Error: CourseFullException - The course " + course + " is full.");
        }
        
        if (coursePrerequisites.containsKey(course)) {
            for (String prerequisite : coursePrerequisites.get(course)) {
                if (!completedCourses.contains(prerequisite)) {
                    throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete " + prerequisite + " before enrolling in " + course + ".");
                }
            }
        }
        
        courseEnrollment.put(course, courseEnrollment.getOrDefault(course, 0) + 1);
        System.out.println("Enrollment successful in " + course + ". Current Enrollment: " + courseEnrollment.get(course));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enroll in Course: ");
        String course = scanner.nextLine();
        
        try {
            enroll(course);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Enrollment process completed.");
            scanner.close();
        }
    }
}
