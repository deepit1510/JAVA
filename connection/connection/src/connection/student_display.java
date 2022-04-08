package connection;
import java.sql.*;


public class student_display{
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/stud";          
    static final String USER = "root";
    static final String PASS = "";

public static void display_student()
{
    Connection conn = null;
    Statement stmt = null;

    try{
  
        Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
     System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT student_id, student_name,father_name,mobile_no,teacher_id,subject_1,subject_2,subject_3,subject_4,subject_5 FROM student";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
	

            int student_id = rs.getInt("student_id");
            String student_name = rs.getString("student_name");
            String father_name = rs.getString("father_name");
	Long mobile_no = rs.getLong("mobile_no");	
	int teacher_id = rs.getInt("teacher_id");
	String subject_1 = rs.getString("subject_1");	
	String subject_2 = rs.getString("subject_2");	
	String subject_3 = rs.getString("subject_3");	
	String subject_4 = rs.getString("subject_4");	
	String subject_5 = rs.getString("subject_5");	
	
	
	System.out.println("Id :" +student_id);
            	System.out.println(" Name: " +student_name);
	System.out.println(" Father Name: " +father_name);
	System.out.println(" mobile: " +mobile_no);
	 System.out.println(" teacher_id: " +teacher_id);
	 System.out.println("subject_1: "  +subject_1);
	 System.out.println("subject_2: "  +subject_2);
	 System.out.println("subject_3: "  +subject_3);
	 System.out.println("subject_4: "  +subject_4);
	 System.out.println("subject_5: "  +subject_5);

        }

        rs.close();
        stmt.close();
        conn.close();
    }catch(SQLException se){     se.printStackTrace();
    }catch(Exception e){
        // Handle errors for Class.forName
        e.printStackTrace();
    }finally{
        // finally block used to close resources
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se){
            se.printStackTrace();
        } // end finally
    } // end try
System.out.println("Goodbye.");
} // End method main
} // end class ClientBase



