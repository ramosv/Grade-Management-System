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
public class Course {

	//****************************
	//Attributes
	//****************************
	
	public String CourseName;
    public int CourseID;
    public static ArrayList<Student> AllStudents;
    public static ArrayList<Course> AllCourses = new ArrayList<Course>();

    //****************************
  	//Getters and Setters
  	//****************************
    
    public String GetCourseName() 
    {
    	return CourseName;
    }
    public int getCourseID() 
    {
    	return CourseID;
    }
    public void SetCourseName(String X) 
    {
    	CourseName = X;
    }
    public void SetCourseID(int X)
    {
    	CourseID = X;
    }
    //****************************
  	//Course Constructors
  	//****************************
    public Course(int courseid, String coursename)
    {
        CourseName = coursename;
        CourseID = courseid;
        AllStudents = new ArrayList<Student>();    
    }
    
    public Course() 
    {
    	
    }
    /***********************************************************************************
	 * Teacher Menu                                                                    *
	 *                                                                                 *
	 * PURPOSE: Gives Access to main teacher menu                   				   *
	 *                                                                                 *
	 * Return value: Prints Out Teacher Menu w/ options        					       *
	 *                                                                                 *
	 * *********************************************************************************
	 */
    public static void TeacherMenu() 
	{
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Teacher Interface");
		System.out.println("----------------------------------------");
		System.out.println("Choose one of the following options");
        System.out.println("1. Enter Course");
        System.out.println("2. Student Menu(Add Students)");
        System.out.println("3. Remove Course");
        System.out.println("4. Print All Courses");
        System.out.println("5. Close Interface");
        System.out.println("----------------------------------------");

        
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine();
        
        switch (userChoice)
        {
            case "1":
                EnterCourse();
                break;
            case "2":
                StudentMenu();
                break;
            case "3":
                RemoveCourses();
                break;
            case "4":
                PrintCourses();
                break;
            case "5":
                close();
                break;
        }
		
	}
    /***********************************************************************************
	 * Student Menu                                                                    *
	 *                                                                                 *
	 * PURPOSE: Gives Access to Student menu                       		     		   *
	 *                                                                                 *
	 * Return value: Prints Out Student Menu w/ options        					       *
	 *                                                                                 *
	 * *********************************************************************************
	 */
    public static void StudentMenu() 
	{
		System.out.println();
		System.out.println("----------------------------------------");
        System.out.println("Student Menu Interface");
        System.out.println("----------------------------------------");
        System.out.println("Choose one of the following options:");
        System.out.println("1. Enter Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Enter Grade");
        System.out.println("4. Grade Analytics");
        System.out.println("5. Close Interface");
        System.out.println("----------------------------------------");
        
       Scanner sc = new Scanner(System.in);
       String userChoice = sc.nextLine();
        
       switch (userChoice)
        {
            case "1":
                EnterStudent();
                break;
            case "2":
                RemoveStudent();
                break;
            case "3":
                EnterGrade();
                break;
            case "4":
                GradeAnalytics();
                break;
            case "5":
                close();
                break;
        }
        
	}
    
    //*********************************************************
    // TEACHER MENU METHODS
    //********************************************************
     
    /***********************************************************************************
   	 * Enter Course                                                                    *
   	 *                                                                                 *
   	 * PURPOSE: Allows teacher to enter a course                  		     		   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
	public static void EnterCourse() 
	{
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("Enter a Course");
        System.out.println("----------------------------------");
        System.out.println("Enter a New Course ID: ");
        
        
        String newid  = sc.nextLine();
        int NewID = Integer.parseInt(newid);
        
        System.out.println("Enter a Name for the Course:");
        
        String Newname = sc.nextLine();

        System.out.println("New Course: " + Newname + "| ID: " + NewID + "| Has been Succesfully Created!");

        Course NewCourse = new Course(NewID, Newname);

        AllCourses.add(NewCourse);
        TeacherMenu();
	}
	
	 /**********************************************************************************
   	 * Remove Course                                                                   *
   	 *                                                                                 *
   	 * PURPOSE: Allows teacher to remove a course from the list of courses             *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
	
	public static void RemoveCourses() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Remove Course");
        System.out.println("----------------------------------------");
        for (Course x : AllCourses)
        {
            System.out.println("Course ID: " + x.CourseID + " |Course Name: " + x.CourseName);
        }
        System.out.println("Select Course ID to Remove Course and its Students");
        String selectCourse  = sc.nextLine();
        int selectedCourse = Integer.parseInt(selectCourse);

        Boolean exist = false;
        for (Course x : AllCourses)
            if (selectedCourse == x.CourseID)
            {
                AllCourses.remove(x);
                for(Student y : AllStudents)
                {   
                    AllStudents.remove(y);
                }
                exist = true;
            }
        if (exist == false)
        {
            System.out.println("Course does not exist");
        }
        
        TeacherMenu();
	}
	
	 /**********************************************************************************
   	 * Print Courses                                                                   *
   	 *                                                                                 *
   	 * PURPOSE: Allows the teacher to print out all the courses                        *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
	public static void PrintCourses() 
	{
		System.out.println();
		System.out.println("----------------------------------------");
        System.out.println("All Courses");
        System.out.println("----------------------------------------");
        for(Course x : AllCourses)
        {
            System.out.println("Course ID: " + x.CourseID + " |Course Name: " + x.CourseName);
        }
        
        TeacherMenu();
	}
	
	//*********************************************************
    // STUDENT MENU METHODS
    //********************************************************
	
	/***********************************************************************************
   	 * Remove Student                                                                  *
   	 *                                                                                 *
   	 * PURPOSE: Gives Access to remove students                   		     		   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
	
	public static void RemoveStudent()
    {
		 Scanner sc = new Scanner(System.in);
		 System.out.println();
		 System.out.println("---------------------------------");
    	 System.out.println("Remove Student");
         System.out.println("---------------------------------");
         for (Course x:AllCourses)
         {
             System.out.println("Course ID: " + x.CourseID + " |Course Name: " + x.CourseName);
         }
         String courseID  = sc.nextLine();
         int SelectCourse = Integer.parseInt(courseID);

         boolean exist = false;
         for (Course x:AllCourses)
             if (SelectCourse == x.CourseID)
             {
                 x.RemoveStudents();
                 exist = true;
             }
         if (exist == false)
         {
             System.out.println("Course does not exist");
         }
         TeacherMenu();
     }
	
	/***********************************************************************************
   	 * Remove Students                                                                 *
   	 *                                                                                 *
   	 * PURPOSE: Gives Access to remove students                   		     		   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public void RemoveStudents()
    {
    	Scanner sc = new Scanner(System.in);
        for(Student x : AllStudents)
        {
            System.out.println("Name: " + x.Name + " |ID: " + x.Id);
        }
        System.out.println("Choose a Student to Remove");
        String id  = sc.nextLine();
        int ID = Integer.parseInt(id);

        for(Student x : AllStudents)
            if(ID == x.Id)
            {
            	AllStudents.remove(x);
            }              
    }
    
    /***********************************************************************************
   	 * Enter Students                                                                  *
   	 *                                                                                 *
   	 * PURPOSE: Gives Access to enter students                   		     		   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public static void EnterStudent()
    {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("----------------------------");
   	 	System.out.println("Enter Student");
   	 System.out.println("--------------------------------");
        for (Course x:AllCourses)
        {
            System.out.println("Course ID: " + x.CourseID + " |Course Name: " + x.CourseName);
        }
        System.out.println("Select a Course to Add a Student: ");
        String courseID  = sc.nextLine();
        int SelectCourse = Integer.parseInt(courseID);

        boolean exist = false;
        for (Course x:AllCourses)
            if (SelectCourse == x.CourseID)
            {
                x.AddStudent();
                exist = true;
            }
        if (exist == false)
        {
            System.out.println("Course does not exist");
        }
        TeacherMenu();
    }
    
    /***********************************************************************************
   	 * Add Students                                                                    *
   	 *                                                                                 *
   	 * PURPOSE: Gives Access to add students                    		     		   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public void AddStudent()
    {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Student ID: ");
        String id  = sc.nextLine();
        int ID = Integer.parseInt(id);
        
        System.out.println("Enter New Student Name: ");
        String Newname = sc.nextLine();

        Student NewStudent = new Student(ID, Newname, 0);
        AllStudents.add(NewStudent);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Course ID: "+CourseID + " |Course Name: " + CourseName);
        System.out.println("----------------------------------------");
        System.out.println("List of Student in Course: " + CourseName);
        for(Student x : AllStudents)
        {
            System.out.println("Name: " + x.Name + " |ID: " + x.Id);
        }

    }
    
    /***********************************************************************************
   	 * Enter Grade                                                                     *
   	 *                                                                                 *
   	 * PURPOSE: Gives Access to enter grade                   		     		   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public static void EnterGrade()
    {
   	 Scanner sc = new Scanner(System.in);
   	 System.out.println();
   	 System.out.println("-------------------------------");
   	 System.out.println("Enter Grade");
        System.out.println("-------------------------------");
        for (Course x:AllCourses)
        {
            System.out.println("Course ID: " + x.CourseID + " |Course Name: " + x.CourseName);
        }
        System.out.println("Choose a Course to Edit a Student Grade");
        String courseID  = sc.nextLine();
        int SelectCourse = Integer.parseInt(courseID);
        boolean exist = false;
        for (Course x:AllCourses)
            if (SelectCourse == x.CourseID)
            {
                x.EnterGrades();
                exist = true;
            }
        if (exist == false)
        {
            System.out.println("Course does not exist");
        }
        System.out.println();
        TeacherMenu();
    }
    
    /***********************************************************************************
   	 * Enter Grades                                                                    *
   	 *                                                                                 *
   	 * PURPOSE: Gives Access to enter grades  	                 		     		   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public void EnterGrades()
    {
    	Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("List of students in Course: " + CourseName);
        for(Student x : AllStudents)
        {
            System.out.println("Name: " + x.Name + " |ID: " + x.Id);
        }
        System.out.println("Choose a Student to Enter Final Grade");
        String id  = sc.nextLine();
        int ID = Integer.parseInt(id);
        System.out.println("Enter a Grade for the Student:");
        String newgrade  = sc.nextLine();
        double NewGrade = Double.parseDouble(newgrade);

        for(Student x : AllStudents)
            if (ID == x.Id)
            {
                x.setGrade(NewGrade);
                System.out.println("ID: " + x.Id + " | Name: " + x.Name + " | Grade: " + NewGrade);
                
            }
    }
    
    /***********************************************************************************
   	 * Grades Analytics                                                                *
   	 *                                                                                 *
   	 * PURPOSE: Gives Grade Analytics			                 		     		   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public static void GradeAnalytics()
    {
   	 	Scanner sc = new Scanner(System.in);
   	 	System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Grade Analytics");
        System.out.println("----------------------------------");
        for (Course x:AllCourses)
        {
            System.out.println("Course ID: " + x.CourseID + " |Course Name: " + x.CourseName);
        }
        System.out.println("Choose a Course to Print Grade Analytics");
        String courseID  = sc.nextLine();
        int SelectCourse = Integer.parseInt(courseID);
        boolean exist = false;
        System.out.println();
		System.out.println("----------------------------------------");
        System.out.println("Running Grade Analytics...");
        System.out.println("----------------------------------------");
        for (Course x:AllCourses)
            if (SelectCourse == x.CourseID)
            {
                x.Average();
                x.Minimum();
                x.Maximum();
                x.Percentage();
                exist = true;
            }
        if (exist == false)
        {
            System.out.println("Course does not exist");
        }
        System.out.println();
        TeacherMenu();

    }
    //*********************************************************
    // STUDENT MENU METHODS
    //********************************************************
   
    /***********************************************************************************
   	 * Average                                                         			       *
   	 *                                                                                 *
   	 * PURPOSE: Calculate Average		                 		     	         	   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public void Average()
    {
        double avg = 0;
        
        List<Double> AllGrades = new ArrayList<Double>();
        for(Student x : AllStudents)
        {
            AllGrades.add(x.getGrade());
        }
        for(double x : AllGrades)
        {
            if (x > 0)
            {
                avg = avg + x;
                
            }
        }
        double total = avg / AllGrades.size();

        System.out.println("Student Average Grade: " + Math.round(total));
        

    }
    
    /***********************************************************************************
   	 * Minimum                                                        			       *
   	 *                                                                                 *
   	 * PURPOSE: Calculate Minimum 	                 		     	         	   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public void Minimum()
    {
    	double findmin = 100000;
        String name = "";
        
        List<Double> AllGrades = new ArrayList<Double>();
        for (Student x : AllStudents)
        {
            AllGrades.add(x.getGrade());

        }
        for (double x : AllGrades)
        {
            if (x < findmin)
            {                   
                findmin = x;                  
            }
        }
        for (Student x : AllStudents)
        {
            if (x.getGrade() == findmin)
            {
                name = x.Name;
            }

        }
        System.out.println("--------------------------------------------");
        System.out.println("Minumum Grade: " + findmin + " Student: " + name );
        

    }
    
    /***********************************************************************************
   	 * Maximum                                                        			       *
   	 *                                                                                 *
   	 * PURPOSE: Calculate Maximum 	                 		     	         	   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public void Maximum()
    {
    	double findMax = -10000;
        String name = ("");
        List<Double> AllGrades = new ArrayList<Double>();
        for(Student x : AllStudents)
        {
            AllGrades.add(x.getGrade());
        }
        for(Double x : AllGrades)
        {
            if (x > findMax)
            {
                findMax = x;                
            }
        }
        
        for(Student x : AllStudents)
        {
            if (x.getGrade() == findMax)
            {
                name = x.Name;
            }

        }
        System.out.println("---------------------------------------");
        System.out.println("Maximum Grade: " + findMax + " Student: " + name);
        
    }
    
    /***********************************************************************************
   	 * Median                                                			     		   *
   	 *                                                                                 *
   	 * PURPOSE: Calculate Median	                 		     	             	   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */

    public double Median()
    {
        List<Double> AllGrades = new ArrayList<Double>();
        for(Student x : AllStudents)
        {
            AllGrades.add(x.getGrade());
        }

        return Median();
    }
    
    /***********************************************************************************
   	 * Percentage                                                    	     		   *
   	 *                                                                                 *
   	 * PURPOSE: Calculate Percentage	                 	     	             	   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public void Percentage()
    {
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        double f = 0;
        List<Double> AllGrades = new ArrayList<Double>();
        for(Student x : AllStudents)
        {
            AllGrades.add(x.getGrade());      
        }
        for(double x : AllGrades)
        {
            if (x >= 90)
            {
                a = a + 1;
            }

            else if (x >= 80)
            {
                b = b + 1;
            }

            else if (x >= 70)
            {
                c = c + 1;
            }

            else if (x >= 60)
            {
                d = d + 1;
            }

            else if (x < 60)
            {
                f = f + 1;
            }
            else
            {

            }
        }

        double aresult = a / AllGrades.size();
        double bresult = b / AllGrades.size();
        double cresult = c / AllGrades.size();
        double dresult = d / AllGrades.size();
        double fresult = f / AllGrades.size();

        System.out.println("---------------------------------------");
        System.out.println("Grade Percentage of All Enrolled students");
        System.out.println("Percentage of A's: " + Math.round(aresult * 100) + "%");
        System.out.println("Percentage of B's: " + Math.round(bresult * 100) + "%");
        System.out.println("Percentage of C's: " + Math.round(cresult * 100) + "%");
        System.out.println("Percentage of D's: " + Math.round(dresult * 100) + "%");
        System.out.println("Percentage of F's: " + Math.round(fresult * 100) + "%");
    }
    
    
    /***********************************************************************************
   	 * Close                                                    	     		   *
   	 *                                                                                 *
   	 * PURPOSE: Close Menu	                 	     	             	   *
   	 *                                                                                 *
   	 * Return value: Void        					    							   *
   	 *                                                                                 *
   	 * *********************************************************************************
   	 */
    public static void close() 
	{
		System.exit(0);
	}

}
