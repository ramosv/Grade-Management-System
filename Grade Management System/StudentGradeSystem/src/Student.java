/****************************************************************************************************************
 *          						Final Project --  Student Management System	 						        *
 * 																												*
 * PROGRAMMER: Vicente Ramos and Sergio Perez Reyes																*
 * CLASS: CS 160 and CS 200																						*
 * ASSIGNMENT: Final Project																					*
 * INSTRUCTOR: Dean Zeller																						*
 * SUBMISSION DATE: Saturday, December 7th.																	    *
 * 																												*
 * DESCRIPTION:																									*
 * The following is a student management system that allows a teacher to create multiple courses, add students  *
 * to the courses, give them grades and print analytics for each course so see how students are doing in the    *
 * in the class																								    *
 * 									                                                                            *
 * COPYRIGHT:																									*
 * This program is a copyright (c) 2019 Vicente Ramos, Sergio Perez Reyes and Dean Zeller.						*
 * This is original work, with the idea from an outside project.												*
 * 																												*
 * **************************************************************************************************************
 */
public class Student {

	//****************************
	//Attributes
	//****************************
	
	public int Id;
    public String Name;
    public double Grade;
    
    //****************************
  	//Student Constructor
  	//****************************
    
    public Student(int id, String name, double grade)
    {
        this.Id = id;
        this.Name = name;
        this.Grade = grade;   
    }
    
  //****************************
  	//Getters and Setters
  	//****************************
    
    
    public String GetName() 
    {
    	return this.Name;
    }
    public void setName(String X) 
    {
    	this.Name = X;
    }
    public int getCourseID() 
    {
    	return this.Id;
    }
    public void setCourseID(int X) 
    {
    	this.Id = X;
    }
    public double getGrade()
    {
    	return this.Grade;
    }
    public void setGrade(double X)
    {
        this.Grade = X;
    }
    


}
