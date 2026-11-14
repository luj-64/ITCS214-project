// sec: 9
// 1- Lujain Elsaeed 202503623
// 2- Fajar Mohammad Yaseen 202507829
// 3- Sohilah nasser 202503491
public class Course {
private int courseID ;
private String courseName ;
private String instructorName ;
private int creditHours ;

// the constructor that initializes all instance variables

  public Course (int CI , String CN , String IN , int CH ) // We used the first two letters of each variable name as parameter names

  {
    if( CI > 99999 || CI < 10000 )
    throw new IllegalArgumentException("Invalid Course ID");

    if( CH > 6 || CH < 1 )
    throw new IllegalArgumentException("Invalid Credit hours");
  
    courseID = CI;
    courseName = CN;
    instructorName = IN;
    creditHours = CH;
    
  }
  
// setter and getter for courseID

  public void setCourseID( int CI )
  {
    if( CI > 99999 || CI < 10000 )
    throw new IllegalArgumentException("Invalid Course ID");
    courseID = CI ;
  }

  public int getCourseID()
  {
    return courseID;
  }

 // setter and getter for courseName

  public void setCourseName( String CN )
  {
    courseName = CN ;
  }

  public String getCourseName()
  {
    return courseName;
  } 

   // setter and getter for instructorName

  public void setInstructorName( String IN )
  {
    instructorName = IN ;
  }

  public String getInstructorName()
  {
    return instructorName;
  } 


  // setter and getter for creditHours

  public void setCreditHours( int CH )
  {
    if( CH > 6 || CH < 1 )
    throw new IllegalArgumentException("Invalid Credit hours");
    creditHours = CH ;
  }

  public int getCreditHours()
  {
    return creditHours;
  }

// equals method 
public boolean equals(Object obj)
{
    if (!(obj instanceof Course))
        return false;

    Course c = (Course) obj;
  if(courseID == c.courseID)
    return true;
  else
    return false; 
}

// toString mehod that returns a string containing all course information
 public String toString()
  {
    StringBuilder sb = new StringBuilder("[");
    sb.append(courseID);
    sb.append("--->");
    sb.append(courseName);
    sb.append("--->");
    sb.append(instructorName);
    sb.append("--->");
    sb.append(creditHours);
    sb.append("]");
    return sb.toString();
  }
 
  
}
