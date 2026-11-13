// sec: 9
// 1- Lujain Elsaeed 202503623
// 2- Fajar Mohammad Yaseen 202507829
// 3- Sohilah nasser 202503491
public class StudyTask {
  
private int taskID;
private String taskTitle;
private int courseID;
private String deadline;
private int priority;
private String status;

// constructor that initializes all instance variables
public StudyTask( int TI , String TT , int CI , String DL , int P , String S ) // We used the first letters of each variable name as parameter names
  {
    taskID = TI ;
    taskTitle = TT ;
    courseID = CI ;
    deadline = DL ;
    priority = P ;
    status = S ;
  
  }
  
 // setter and getter for taskID

  public void setTaskID( int TI )
  {
    taskID = TI ;
  }

  public int getTaskID()
  {
    return taskID;
  }
  
 // setter and getter for taskTitle

  public void setTaskTitle( String TT )
  {
    taskTitle = TT ;
  }

  public String getTaskTitle()
  {
    return taskTitle;
  }

 // setter and getter for courseID

  public void setCourseID( int CI )
  {
    courseID = CI ;
  }

  public int getCourseID()
  {
    return courseID;
  }

  // setter and getter for deadline

  public void setDeadline( String DL )
  {
    deadline = DL ;
  }

  public String getDeadline()
  {
    return deadline;
  }

  // setter and getter for priority

  public void setPriority( int P )
  {
    priority = P ;
  }

  public int getPriority()
  {
    return priority;
  }

  // setter and getter for status

  public void setStatus( String S )
  {
    status = S ;
  }

  public String getStatus()
  {
    return status;
  }

  
  









  
}
