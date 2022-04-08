//Student having fields such as Regno, Name, T1, T2, T3, Assignment and Attendance  �Inherited by PG Student have a unique 
//field Activity; calculate total marks, Average and Grade for a class of 70 MCA students which are created as array of objects 
//of PG Student class.

package yashus;

import java.util.Scanner;

abstract class Student {
	static Integer[] Regno = new Integer[70] ;
	static String[] Name = new String[70];
	static Integer[] T1 = new Integer[70];
	static Integer[] T2 = new Integer[70];
	static Integer[] T3= new Integer[70];
	static Integer[] Assignment= new Integer[70];
	static Integer[] Attendance= new Integer[70];
	public Student(Integer c_count, Integer c_Regno,String c_Name, Integer c_T1, Integer c_T2, Integer c_T3, Integer c_Assignment, Integer c_Attendance)
	{
		Regno[c_count] = c_Regno;
		Name[c_count] = c_Name;
		T1[c_count] = c_T1;
		T2[c_count] = c_T2;
		T3[c_count] = c_T3;
		Assignment[c_count] = c_Assignment;
		Attendance[c_count] = c_Attendance;
	}
}

class Pg_Student extends Student {
	static Integer count =0;
	static Integer[] Activity = new Integer[70];
	static Integer[] total= new Integer[70];
	static Integer[] Average= new Integer[70];
	static char[] stud_grade = new char[70];
	
	public Pg_Student(Integer c_Regno,String c_Name, Integer c_T1, Integer c_T2, Integer c_T3, Integer c_Assignment, Integer c_Attendance, Integer c_Activity)
	{
		super(count, c_Regno, c_Name, c_T1, c_T2, c_T3, c_Assignment, c_Attendance);
		Activity[count] = c_Activity;
		total_marks(count);
		average(count);
		grade(count);
		count++;
	}
	
	

	public void total_marks(int i)
	{
		total[i] = T1[i] + T2[i] + T3[i] + Assignment[i] + Attendance[i] + Activity[i];
	}
	
	public void average(int i)
	{
		Average[i] = total[i]/5;
	}
	
	public void grade(int i)
	{
		if (Average[i] >= 90) stud_grade[i] = 'O';
        else if (Average[i] >= 80 && Average[i] < 90) stud_grade[i] = 'S';
        else if (Average[i] >= 70 && Average[i] < 80) stud_grade[i] = 'A';
        else if (Average[i] >= 60 && Average[i] < 60) stud_grade[i] = 'B';
        else if (Average[i] >= 50 && Average[i] < 60) stud_grade[i] = 'C';
        else stud_grade[i] = 'F';
	}
	
	public static void display()
	{
		for(int i=0; i<count; i++)
		{
			System.out.println(Regno[i]+" "+Name[i]+" "+T1[i]+" "+T2[i]+" "+T3[i]+" "+Assignment[i]+" "+Attendance[i]+" "+Activity[i]);
		}
	}
	
}

public class test 
{
	

	public static void main(String[] args) 
	{
		Integer cnt,regno,T1,T2,T3,assignment,activity,attendance;
		String name;
		Scanner myObj = new Scanner(System.in);
		//Pg_Student s = new Pg_Student();
		System.out.println("Enter the number of details you want to input");
		cnt = Integer.parseInt(myObj.nextLine());
		for(int i=0; i<cnt; i++)
		{
			//Scanner myObj = new Scanner(System.in);
	        //System.out.println("Enter name, age, gender, address and marks:");  // String input

	        // Numerical input
	        System.out.println("Enter Registration number of "+(i+1)+" Student :");
	        regno = Integer.parseInt(myObj.nextLine());
	        
	        System.out.println("Enter name of "+(i+1)+" Student :");
	        name = myObj.nextLine();
	        
	        System.out.println("Enter test1 marks of "+(i+1)+" Student :");
	        T1 = Integer.parseInt(myObj.nextLine());
	        
	        System.out.println("Enter test2 marks of "+(i+1)+" Student :");
	        T2 = Integer.parseInt(myObj.nextLine());

	        System.out.println("Enter test3 marks of "+(i+1)+" Student :");
	        T3 = Integer.parseInt(myObj.nextLine());
	        
	        System.out.println("Enter assignment marks of "+(i+1)+" Student :");
	        assignment = Integer.parseInt(myObj.nextLine());
	        
	        System.out.println("Enter activity marks of "+(i+1)+" Student :");
	        activity	= Integer.parseInt(myObj.nextLine());
	        
	        System.out.println("Enter attendance marks of "+(i+1)+" Student :");
	        attendance = Integer.parseInt(myObj.nextLine());
	        Pg_Student s = new Pg_Student(regno,name,T1,T2,T3,assignment,attendance,activity);
	        
		}
		Pg_Student.display();
	}
}