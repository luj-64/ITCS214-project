// sec: 9
// 1- Lujain Elsaeed 202503623
// 2- Fajar Mohammad Yaseen 202507829
// 3- Sohilah nasser 202503491
public class StudySession {
  private int sessionID;
  private int taskID;
  private int durationHours;

  public StudySession(int SI , int TI , int DH) // We used the first two letters of each variable name as parameter names
  {
    if( SI > 999999 || SI < 100000 )
    throw new IllegalArgumentException("Invalid Session ID");
    if( TI > 999999 || TI < 100000 )
    throw new IllegalArgumentException("Invalid Task ID");
    if( DH <= 0 )
    throw new IllegalArgumentException("Invalid Duration hours");
    
    sessionID = SI ;
    taskID = TI ;
    durationHours = DH ;
  }

  // setter and getter for sessionID

  public void setSessionID( int SI )
  {
    if( SI > 999999 || SI < 100000 )
    throw new IllegalArgumentException("Invalid Session ID");
    
    sessionID = SI ;
  }

  public int getSessionID()
  {
    return sessionID;
  }

  // setter and getter for taskID 

  public void setTaskID( int TI )
  {
     if( TI > 999999 || TI < 100000 )
    throw new IllegalArgumentException("Invalid Task ID");
    taskID = TI ;
  }

  public int getTaskID()
  {
    return taskID;
  }

  // setter and getter for durationHours 

  public void setDurationHours( int DH )
  {
    if( DH <= 0 )
    throw new IllegalArgumentException("Invalid Duration hours");
    
    durationHours = DH ;
  }

  public int getDurationHours()
  {
    return durationHours;
  }

// equals method 

  !!!!!!!!

// toString method that returns all session information
  
 public String toString()
  {
    StringBuilder sb = new StringBuilder("[");
    sb.append(sessionID);
    sb.append("--->");
    sb.append(taskID);
    sb.append("--->");
    sb.append(durationHours);
    sb.append("]");
    return sb.toString();
  }
  

}
