// sec: 9
// 1- Lujain Elsaeed 202503623
// 2- Fajar Mohammad Yaseen 202507829
// 3- Sohilah nasser 202503491
import java.util.Scanner;
public class SmartStudyPlannerApplication {
    SmartStudyPlannerManager manager = new SmartStudyPlannerManager(); // object  to manage courses, tasks, and sessions
    Scanner input = new Scanner(System.in); //object to read user input

    // To display the menue
    public void displayMenu()
    {
        System.out.println("Menu Options: ");
        System.out.println("1- Add Course ");
        System.out.println("2- Add Study Task ");
        System.out.println("3- Add Study Session ");
        System.out.println("4- Update Task Status ");
        System.out.println("5- Search Study Task ");
        System.out.println("6- Delete Study Task ");
        System.out.println("7- Delete Course ");
        System.out.println("8- Display All Courses ");
        System.out.println("9- Display All Study Tasks ");
        System.out.println("10- Display High Priority Incomplete Tasks ");
        System.out.println("11- Display Sessions by Task ID ");
        System.out.println("12- Calculate Overall Task Completion ");
        System.out.println("0- Exit the menu ");

    }

    //To add a course
    public void addCourse()
    {
        System.out.print("Enter Course ID: ");
        int courseID = input.nextInt();
        input.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = input.nextLine();

        System.out.print("Enter Instructor Name: ");
        String instructorName = input.nextLine();

        System.out.print("Enter Credit Hours: ");
        int creditHours = input.nextInt();
        try {
            Course course = new Course(courseID, courseName, instructorName, creditHours);
            manager.addCourse(course);
            System.out.println("Course added successfully!");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    //To add a task
    public void addTask()
    {
        System.out.print("Enter Task ID: ");
        int taskID = input.nextInt();
        input.nextLine();

        System.out.print("Enter Task Title: ");
        String taskTitle = input.nextLine();

        System.out.print("Enter Course ID: ");
        int courseID = input.nextInt();
        input.nextLine();

        System.out.print("Enter Deadline: ");
        String deadline = input.nextLine();

        System.out.print("Enter Priority (1 for High, 2 for Medium , 3 for Low):  ");
        int priority = input.nextInt();
        input.nextLine();

        System.out.print("Enter status (Pending, In Progress, or Completed): ");
        String status = input.nextLine();

        try {
            StudyTask task = new StudyTask(taskID, taskTitle, courseID, deadline, priority, status);
            manager.addStudyTask(task);
            System.out.println("Study Task added successfully!");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // To add session

    public void addSession()
    {
        System.out.print("Enter session ID: ");
        int sessionID = input.nextInt();

        System.out.print("Enter Task ID: ");
        int taskID = input.nextInt();

        System.out.print("Enter Duration Hours ");
        int durationHours = input.nextInt();


        try {
            StudySession session = new StudySession(sessionID, taskID, durationHours);
            manager.addStudySession(session);
            System.out.println("Study Session added successfully!");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    // To update task
    public void updateTask()
    {
        System.out.print("Enter Task ID: ");
        int taskID = input.nextInt();
        input.nextLine();

        System.out.print("Enter The New Status: ");
        String newStatus = input.nextLine();

        try {

            manager.updateTaskStatus(taskID, newStatus);
            System.out.println("Task status updated successfully!");

        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    // To search task
    public void searchTask()
    {
        System.out.print("Enter Task ID: ");
        int taskID = input.nextInt();


        StudyTask t1 = manager.searchTask(taskID);

        if(t1 != null)
            System.out.println(t1.toString());
        else
            System.out.println("Task Not Found");

    }

    // To delete task
    public void deleteTask()
    {
        System.out.print("Enter Task ID: ");
        int taskID = input.nextInt();

        manager.deleteTask(taskID);

    }

    // To delete cours

    public void deleteCourse()
    {
        System.out.print("Enter Course ID: ");
        int courseID = input.nextInt();

        manager.deleteCourse(courseID);

    }

    // To display all courses

    public void displayAllCourses()
    {
        manager.displayCourses();
    }

    // To  display all study tasks
    public void displayAllStudyTasks()
    {
        manager.displayStudyTasks();
    }

    // To  display high priority incomplete tasks
    public void displayHPriorityIncompleteTasks()
    {
        manager.displayHpriorityNC();
    }

    // To  display study sessions for a task

    public void displaySessionsForTask()
    {
        System.out.print("Enter Task ID: ");
        int taskID = input.nextInt();
        manager.displaySessionsByTask(taskID);
    }

    // To  display overall task completion percentage

    public void calculateCompletionPercentage()
    {
        double per = manager.calculateTaskCompletion();

        if (per == 0.0)
            System.out.println("No tasks available or no tasks have been completed yet");
        else
            System.out.println("Overall Task Completion: " + per + "%");
    }

    // to run menue
    public void runMenu()
    {
        int choice;
        String answer = "Y";

        do
        {
            System.out.println();
            displayMenu();

            System.out.println();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            System.out.println();

            if (choice == 1)
                addCourse();

            else if (choice == 2)
                addTask();

            else if (choice == 3)
                addSession();

            else if (choice == 4)
                updateTask();

            else if (choice == 5)
                searchTask();

            else if (choice == 6)
                deleteTask();

            else if (choice == 7)
                deleteCourse();

            else if (choice == 8)
                displayAllCourses();

            else if (choice == 9)
                displayAllStudyTasks();

            else if (choice == 10)
                displayHPriorityIncompleteTasks();

            else if (choice == 11)
                displaySessionsForTask();

            else if (choice == 12)
                calculateCompletionPercentage();

            else if (choice == 0)
                System.out.println("Exiting Smart Study Planner");

            else
                System.out.println("Invalid choice. Please try again.");
                System.out.println();

            if (choice != 0)
            {
                System.out.print("Do you want to display the menu again? (Y/N): ");
                answer = input.next();
            }

        } while (choice != 0 && answer.equalsIgnoreCase("Y"));
    }


    // main method
    public static void main(String[] args)
    {
        SmartStudyPlannerApplication app = new SmartStudyPlannerApplication();
        System.out.println();
        System.out.print("Do you want to display the menu? (Y/N): ");
        String answer = app.input.next();

        if (answer.equalsIgnoreCase("Y"))
            app.runMenu();
        else
            System.out.println("Exiting Smart Study Planner");
    }


}
