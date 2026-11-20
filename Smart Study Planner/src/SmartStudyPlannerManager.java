// sec: 9
// 1- Lujain Elsaeed 202503623
// 2- Fajar Mohammad Yaseen 202507829
// 3- Sohilah nasser 202503491
import java.util.LinkedList;

public class SmartStudyPlannerManager {
    private LinkedList<Course> courses = new  LinkedList<Course>();
    private LinkedList<StudyTask> tasks = new LinkedList<StudyTask>();
    private LinkedList<StudySession> sessions = new LinkedList<StudySession>();

    //add a course ensuring that the course ID is unique
    public void addCourse(Course c1 )
    {
        for (int i = 0; i < courses.size(); i++)
        {
            if (courses.get(i).equals(c1))
            {
                throw new IllegalArgumentException("Course ID already exists");
            }
        }

        courses.add(c1);

    }

    // Display all courses
    public void displayCourses()
    {
        if (courses.isEmpty())
            System.out.println("No Courses Found");
        else{
            for (int i = 0; i < courses.size(); i++)
            {
                System.out.println(courses.get(i));
            }
        }
    }

    //add a study task ensuring that the task ID is unique and the associated course exists
    public void addStudyTask( StudyTask t1 )
    {
        for (int i = 0; i < tasks.size() ; i++)
        {
            if(tasks.get(i).equals(t1))
                throw new IllegalArgumentException(" Task ID already exists");
        }

        boolean Found = false; // to check if the course is found

        for (int i = 0; i < courses.size() ; i++)
        {
            if(t1.getCourseID() == courses.get(i).getCourseID() )
            { Found = true ;
                break; }

        }

        if (Found == false)
            throw new IllegalArgumentException("Course ID does not exist");

        tasks.add(t1);

    }

    //Display all study tasks

    public void displayStudyTasks()
    {
        if (tasks.isEmpty())
            System.out.println("No Study Tasks Found");
        else
        {
            for (int i = 0; i < tasks.size() ; i++)
            {
                System.out.println(tasks.get(i));

            }
        }
    }

    // Search for a study task using its ID

    public StudyTask searchTask(int taskID)
    {
        StudyTask copyT = null ;

        for (int i = 0; i < tasks.size() ; i++)
        {
            if(tasks.get(i).getTaskID() == taskID)
            {
                copyT = tasks.get(i)  ;
                break;

            }
        }
        if( copyT != null )
        {
            return copyT;
        }
        else
            return null ;
    }
// Update a study task's status

    public void updateTaskStatus( int taskID , String newStatus  )
    {
        StudyTask theTask = searchTask(taskID);
        if ( theTask != null)
        {

            theTask.setStatus( newStatus );
        }
        else
            System.out.println("Task is not Found ");
    }

    //Display all High-priority tasks that are not Completed

    public void displayHpriorityNC()
    {
        boolean Found = false;

        for (int i = 0; i < tasks.size(); i++)
        {
            StudyTask theTask = tasks.get(i);

            if (theTask.isHighPriority() && !theTask.isCompleted())
            {
                System.out.println(theTask);
                Found = true;
            }
        }

        if (Found == false)
            System.out.println("No High Priority Incomplete Tasks Found");
    }

    //Add a study session, ensuring that the session ID is unique and the associated task exists
    public void addStudySession( StudySession s1 )
    {
        for (int i = 0; i < sessions.size() ; i++)
        {
            if(sessions.get(i).equals(s1))
                throw new IllegalArgumentException(" session ID already exists");
        }

        boolean Found = false; // to check if the task is found

        for (int i = 0; i < tasks.size() ; i++)
        {
            if(s1.getTaskID() == tasks.get(i).getTaskID() )
            { Found = true ;
                break; }

        }

        if (Found == false)
            throw new IllegalArgumentException("Task ID does not exist");

        sessions.add(s1);

    }

    // Display all study sessions associated with a specified task ID

    public void displaySessionsByTask(int taskID)
    {
        boolean Found = false;

        for (int i = 0; i < sessions.size(); i++)
        {
            StudySession s2 = sessions.get(i);

            if (s2.getTaskID() == taskID)
            {
                System.out.println(s2);
                Found = true;
            }
        }

        if (Found == false)
            System.out.println("No Sessions Found for this Task");
    }

    // Calculating the overall task completion percentage

    public double calculateTaskCompletion( )
    {
        double CompleteTask = 0.0 ;
        double TotalTask = 0.0 ;

        if (tasks.isEmpty())
            return 0.0;

        for( int i = 0 ; i< tasks.size(); i++ )
        {
            if(tasks.get(i).isCompleted())
            {
                CompleteTask++;

            }
            TotalTask++;

        }

        double per = (CompleteTask/TotalTask) * 100 ;

        return per;
    }

    //  Deleting a study task only if no study sessions are associated with it

    public void deleteTask(int taskID)
    {
        StudyTask Ts = searchTask(taskID);

        if( Ts == null )
        { System.out.println(" Task is not Found ");
            return; }

        for(int i = 0; i < sessions.size(); i++ )
        {
            StudySession Ss = sessions.get(i);
            if(Ss.getTaskID() == taskID)
            {
                System.out.println("There are still sessions in the task ");
                return;

            }

        }

        tasks.remove(Ts);
        System.out.println("task has been removed");
    }


    // Delete a course only if no study tasks are associated with it
    public void deleteCourse(int courseID)
    {

        Course Cs = null;

        for (int i = 0; i < courses.size(); i++) // first search for the course
        {
            if (courses.get(i).getCourseID() == courseID)
            {
                Cs = courses.get(i);
                break;
            }
        }

        if (Cs == null)
        {
            System.out.println("Course is not Found");
            return;
        }

        for (int i = 0; i < tasks.size(); i++)
        {
            StudyTask St = tasks.get(i);

            if (St.getCourseID() == courseID)
            {
                System.out.println("There are still tasks associated with this course");
                return;
            }
        }

        courses.remove(Cs);
        System.out.println("Course has been removed");
    }


}

