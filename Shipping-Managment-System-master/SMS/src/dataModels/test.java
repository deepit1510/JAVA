package dataModels;


import java.io.*;
import java.lang.*;
import java.lang.String.*;
import java.util.Scanner;
import java.util.Scanner.*;
class Student
{
protected String name;
protected int age;
protected String gender;
protected String address;
protected float m1, m2;
protected float total;
public Student()
{
 name ="";
 age=0;
 gender="M";
 address="";
 m1=0;m2=0;
}

public Student(String c_name, int c_age, String c_gender, String c_address,float c_m1, float c_m2)  {
 name= c_name;
 age= c_age;
 gender=c_gender;
 address=c_address;
 m1=c_m1;  
 m2=c_m2;
}

void get_data()
{
// to get data from the user
 Scanner myObj = new Scanner(System.in);
 //System.out.println("Enter name, age, gender, address and marks:");  // String input
 
 // Numerical input
 System.out.println("Enter name:");
 name = myObj.nextLine();
 
 System.out.println("Enter age:");
 age = Integer.parseInt(myObj.nextLine());
 System.out.println("Enter gender:");

 gender = myObj.nextLine();
 
System.out.println("Enter address:");
address = myObj.nextLine();
 
System.out.println("Enter marks1:");
m1 = myObj.nextFloat();
System.out.println("Enter marks2:");
 m2 = myObj.nextFloat();
}
public void total_marks( )
{  
total = m1+m2;
System.out.println(total);
}
public void total_marks(int m1, int m2)
{  
total = m1+m2;
System.out.println(total);
}
void disp_info()
{
System.out.println("Name: "+name);
System.out.println("Age: "+age);
System.out.println("Gender: "+gender);
System.out.println("Address:" +address);

}
}

public class test extends Student{

public static void main(String[] args) {
Student s=new Student();
s.disp_info();
s.total_marks();
Student s1=new Student("David", 20,"F","12 KKKKHHH St Karnataka",70,80);
s1.disp_info();
s1.total_marks();
s.get_data();
s.disp_info();
s.total_marks(70,90);

}


}
