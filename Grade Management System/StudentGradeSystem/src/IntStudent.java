import java.util.*;
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
public class IntStudent extends Student{
	
	/* Inheritance:
    It is using Inheritance by Using the properties and methods from the 
    Parent class course. Only difference between an IntStudents ans students
    it that it has and International Name country they are from and also a
    IntGrade to show the grade from their country, but every other property is the same.
    Now there is no need to ReWrite all that code because IntStuden Inherits from
    student class.         
    */

	//****************************
	//Attributes
	//****************************
	public String International;
	public double IntGrade;
	
	//****************************
  	//IntStudents Constructors
  	//****************************
	public IntStudent(int id, String name, double grade, String international, double intgrade)
    {
		super(id,name,grade);
        this.International = international;
        this.IntGrade = intgrade;
    }
	
	/* Polymorphism:
    I am applying polomorphism by writting a second constructor that is 
    allowing the property Grade to have different implementation in our code.
    I wrote two methods with the same name to demonstrate this.
    */
	
	//Getter and Setters
	public double GetIntGrade()
    {
        return IntGrade;
    }
	public int GetIntGrade(int x)
    {
		this.IntGrade = x;
        return x;
    }
	public void setIntGrade(double x) 
	{
		this.IntGrade = x;
	}
	public String GetInternational() 
	{
		return this.International;
	}
	public void setInternational(String x) 
	{
		this.International= x;
	}
    

}
