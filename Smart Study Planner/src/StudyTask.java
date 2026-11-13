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
    if ( TI < 100000 || TI > 999999  )
    throw new IllegalArgumentException("Invalid Task ID");
    if (CI > 99999 || CI < 10000)
    throw new IllegalArgumentException("Invalid Course ID");
    if ( P < 1  || P > 3 )
    throw new IllegalArgumentException("Invalid Priority"); 
    if ( ! S.equalsIgnoreCase("Pending") && ! S.equalsIgnoreCase("In Progress") && ! S.equalsIgnoreCase("Completed") )
    throw new IllegalArgumentException("Invalid Status"); 
    
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
    if ( TI < 100000 || TI > 999999  )
    throw new IllegalArgumentException("Invalid Task ID");  

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
    if (CI > 99999 || CI < 10000)
    throw new IllegalArgumentException("Invalid Course ID");  
    courseID = CI ;
  }

  public int getCourseID()
  {
    return courseID;
  }

  // setter and getter for deadline

  public void setDeadline( String DL )
  {
     if (  )
    throw new IllegalArgumentException("Invalid deadline"); 
    deadline = DL ;
  }

  public String getDeadline()
  {
    return deadline;
  }

  // setter and getter for priority

  public void setPriority( int P )
  {
    if ( P < 1  || P > 3 )
    throw new IllegalArgumentException("Invalid Priority"); 
    priority = P ;
  }

  public int getPriority()
  {
    return priority;
  }

  // setter and getter for status

  public void setStatus( String S )
  {
    if ( ! S.equalsIgnoreCase("Pending") && ! S.equalsIgnoreCase("In Progress") && ! S.equalsIgnoreCase("Completed") )
    throw new IllegalArgumentException("Invalid Status"); 
    
    status = S ;
  }

  public String getStatus()
  {
    return status;
  }

//equals method 

!!!!!!!!!

// toString method that returns all task information
 public String toString()
  {
    StringBuilder sb = new StringBuilder("[");
    sb.append(taskID);
    sb.append("--->");
    sb.append(taskTitle);
    sb.append("--->");
    sb.append(courseID);
    sb.append("--->");
    sb.append(deadline); 
    sb.append("--->");
    sb.append(priority);
    sb.append("--->");
    sb.append(status);
    sb.append("]");
    return sb.toString();
  }

  // isCompleted method that returns true if the task is completed
  public boolean isCompleted()
    {
    if(status.equalsIgnoreCase("Completed"))
      return true;
    else
      return false;
    }

// isHighPriority method that returns true if the task has High priority

 public boolean isHighPriority()
   {
   if( priority == 1 )
     return true;
   else
     return false;
   }

  
}
