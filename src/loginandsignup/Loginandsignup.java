package  loginandsignup;
import java.io.IOException;
import java.sql.Statement;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import static loginandsignup.Loginandsignup.count;
import static loginandsignup.Loginandsignup.name;
import static loginandsignup.Loginandsignup.Email;
import static loginandsignup.Loginandsignup.quiz;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import static loginandsignup.Connections.getConnection;
import static loginandsignup.Loginandsignup.no1;
import static loginandsignup.Quiz1.question_no;

class Connections
{
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/quiz";
        String username = "root";
        String password = "sham7890";
        return DriverManager.getConnection(url, username, password);
    }
}

class Students
{
    
}


class Admin extends Connections
        
{
      public static void signup(String username ,String email  ,String password,String RecoveryPassword ) throws SQLException 
       {  
        try {
            
                Connection connection = getConnection();
                Statement st = connection.createStatement();
             
             
                String query = "INSERT INTO admin (Admin_user_name, Email, password,RecoveryPassword)" + "VALUES ('" + username + "', '" + email + "', '" + password + "','" + RecoveryPassword + "')";
                st.execute(query);
                JOptionPane.showMessageDialog(null, "New account has been created successfully!");
            
                connection.close(); // Close the connection when done
        }      
       catch (SQLException e) {
        Connection connection = Connections.getConnection();
        Statement st = connection.createStatement();
        String query = "Selec* from admin where Admin_user_name ='" + username + "'";
        ResultSet rs = st.executeQuery(query); // Use executeQuery() instead of execute()
    
    if (rs.next()) { // Check if the ResultSet has any data
        String s = rs.getString("Admin_user_name");
        String E = rs.getString("Email");
        if (username.equals(s)){
            JOptionPane.showMessageDialog(null, "Username Already Exisit ");
        }
        else if(email.equals(E))
        {
            JOptionPane.showMessageDialog(null, "Email Already Exisit ");
        }
        else{
                JOptionPane.showMessageDialog(null, "Failed to add Admin ");
                e.printStackTrace();
        }
    }
    else{
                JOptionPane.showMessageDialog(null, "Failed to add Admin ");
                e.printStackTrace();
        }
     }
       }
     
       public static void Login(String username, String password, login currentInstance) {
    try {
        Connection connection = getConnection();
        Statement st = connection.createStatement();
 
        String query = "SELECT Admin_user_name, password, Email FROM admin WHERE Admin_user_name = '" + username + "' AND password = '" + password + "'";
        ResultSet rs = st.executeQuery(query);
         ResultSet rs2;
//        String query2 = "SELECT quiz_title FROM quiz WHERE quizno = (SELECT MAX(quizno) FROM quiz)";
//        Statement st2 = connection.createStatement(); // Create a new statement for the second query
//        ResultSet rs2 = st2.executeQuery(query2);

        String no = "0", no_quiz = "0";
        name = username;
        

        if (rs.next()) {
            Email = rs.getString("Email");
           
            Loginandsignup.count(rs.getString("Admin_user_name"));
            no = Loginandsignup.no1;
            no_quiz = Loginandsignup.no2;
             String query2 = "SELECT quiz_title FROM quiz WHERE quizno = (SELECT MAX(quizno) FROM quiz)";
           
            
            Admindashboard adminframe = new Admindashboard();
            adminframe.setadminname(username);
            adminframe.setStudents(no);
            adminframe.setQuizzes(no_quiz);
            adminframe.setadminname1(rs.getString("Admin_user_name"));
            adminframe.setEmail(rs.getString("Email"));
            adminframe.setQuiztitle(getquiztitle(rs.getString("Admin_user_name")));
            adminframe.setVisible(true);
            currentInstance.dispose();
         
        } else {
            // No rows found, login failed
            JOptionPane.showMessageDialog(null, "No Account Found");
        }

        // Close result sets, statements, and connection
        rs.close();
        
        st.close();
       // st2.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   static String  title ="";
    public static String getquiztitle(String id)
    {
        try {
        Connection connection = getConnection();
        Statement st = connection.createStatement();
        String query2 = "SELECT quiz_title FROM quiz WHERE quizno = (SELECT MAX(quizno) FROM quiz WHERE Admin_user_name = '" + id + "')";

       Statement st2 = connection.createStatement(); // Create a new statement for the second query
       ResultSet rs2 = st2.executeQuery(query2);
       if(rs2.next())
       {
           
          title = rs2.getString("quiz_title");
          return title;
       }
       
    } catch(SQLException e)
        {
              e.printStackTrace();
        }
        return title;
       
    }
    
    public static void AddStudent(String username, String name, String password,String Adminname) throws SQLException {
       
        try {
                
                Connection connection =getConnection();
                Statement st = connection.createStatement();
                String query = "INSERT INTO student (Student_user_name, Name, password, Admin_user_name)" +
                           " VALUES ('" + username + "', '" + name + "', '" + password + "', '" + Adminname + "')";
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Added Successfully");
                AddStudent a = new AddStudent();
                a.dispose();
                a.setadminname(Adminname);
                a.setVisible(true);
                connection.close();
        }
        catch (SQLException e) {
        Connection connection =getConnection();
        Statement st = connection.createStatement();
        String query = "Select Student_user_name from student where Student_user_name ='" + username + "'";
        ResultSet rs = st.executeQuery(query); // Use executeQuery() instead of execute()
    
    if (rs.next()) { // Check if the ResultSet has any data
        String s = rs.getString("Student_user_name");
        if (username.equals(s)){
            JOptionPane.showMessageDialog(null, "Student Already Exisit ");
        }
        else{
                JOptionPane.showMessageDialog(null, "Failed to add student: ");
                e.printStackTrace();
        }
    }
    else{
                JOptionPane.showMessageDialog(null, "Failed to add student: ");
                e.printStackTrace();
        }
     }
    }
     public static void RemoveStudent(String username,String Adminname)
     {
         try
         {
              Connection connection = getConnection();
              Statement st = connection.createStatement();
              String query = "DELETE FROM student WHERE Student_user_name = '" + username + "' AND Admin_user_name = '" + Adminname + "'";

               st.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Student Removed Successfully");
                AddStudent a = new AddStudent();
                a.dispose();
                a.setadminname(Adminname);
                a.setVisible(true);
                connection.close();
         }
          catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Failed to Remove student: ");
                e.printStackTrace();
        }
     }
     protected static ArrayList<String> Students(String Adminname) 
       {
            ArrayList<String> student = new ArrayList<>();
             try {
             Connection connection =  Connections.getConnection();
             Statement st = connection.createStatement();
             
             
            String query ="SELECT* FROM student WHERE Admin_user_name = '" + Adminname + "'";
            ResultSet rs = st.executeQuery(query);
            int i = 1;
            while(rs.next()) 
            {
                
                String student_name = rs.getString("Name");
                String student_username = rs.getString("Student_user_name");
                String password = rs.getString("Password");
                
                student.add(student_name);
                student.add(student_username);
                student.add(password);
                
                i++;
            }
            rs.close();
            st.close();
            connection.close(); 
       }
        catch(SQLException e)
        {
              e.printStackTrace();
        }
     return student;
       }
      
    public static String Recoverpassword;
    public static boolean check;
   protected static void PasswordRecovery(String username , String Email,String Recoverypassword )
   {
        try {
            
                Connection connection = getConnection();
                Statement st = connection.createStatement();
                
                String query = "SELECT * FROM admin WHERE Admin_user_name = '" + username + "' AND Email = '" + Email + "' AND RecoveryPassword = '" + Recoverypassword + "'";
                ResultSet rs = st.executeQuery(query);
                if(rs.next())
                {
                    Recoverpassword = rs.getString("password");
                    check = true;
                }
                else 
                {
                    check=false;
                    JOptionPane.showMessageDialog(null, "Invalid Details");
                }
                 rs.close();
            st.close();
            connection.close(); 
       }
       catch(SQLException e)
        {
              e.printStackTrace();
        }
     
}
   
   
   
}
public class Loginandsignup {
    
 static String name;
  static String Email,quiz;
    public static void main(String[] args) {
        home homeframe = new home();
        homeframe.setVisible(true);
        homeframe.pack();
        homeframe.setLocationRelativeTo(null);
        homeframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        
         // Missing parentheses to instantiate the object
        
    }

     static String  no1 = "0" , no2 = "0";
    public static void count(String username)
    {
       
        try {
        Connection connection = Connections.getConnection();
        Statement st = connection.createStatement();
        String query2 = "SELECT COUNT(Student_user_name) AS no FROM student GROUP BY Admin_user_name HAVING Admin_user_name = '" + username + "'";
       
            ResultSet rs1 = st.executeQuery(query2); // Moved here to ensure it's executed only after rs.next()
            
            if (rs1.next()) {
                no1 = rs1.getString("no");
            }
           
          String query3 = "SELECT COUNT(quiz_id) AS no FROM quiz GROUP BY Admin_user_name HAVING Admin_user_name = '" + username + "'";
       
             rs1 = st.executeQuery(query3); // Moved here to ensure it's executed only after rs.next()
            
            if (rs1.next()) {
                no2 = rs1.getString("no");
            }
          
            rs1.close();
          
    }
         catch (SQLException e) {
        e.printStackTrace();
    }
   
}
    
}

class Quiz1 
{
    private String quizid;
    private String quizTitle;
    private double marks_per_question;
    private int hr;
    private int min;
    private int sec;
    private Time time;
    private String Quiz_Description;
    int  count = 1;
    
    
    public Quiz1(String quizid, String quizTitle, double marks_per_question,int hr,int min,int sec,String Quiz_Description)
    {
        this.quizid=quizid;
        this.quizTitle=quizTitle;
        this.marks_per_question = marks_per_question;
        this.time = new Time(hr,min,sec);
        this.Quiz_Description=Quiz_Description;
       }
   public Quiz1()
    {
    } 
   public Quiz1 (String quizid)
   {
       this.quizid = quizid;
   }
    

    
    public void Add_quiz(String admin_id,int Questionno)
    {
        try
        {
              Connection connection = Connections.getConnection();
              Statement st = connection.createStatement();
               SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
               String  timeStr = sdf.format(time);
                String query2 = "SELECT COUNT(quiz_id) AS no FROM quiz WHERE Admin_user_name = '" + admin_id + "'";
       
            ResultSet rs1 = st.executeQuery(query2); // Moved here to ensure it's executed only after rs.next()
             int  quizno=0;
             if (rs1.next()) {
              quizno = rs1.getInt("no");
              quizno++;
            }
         
              
              String query = "INSERT INTO quiz (quiz_id, Admin_user_name, quiz_title, quiz_description, time_limit, marks_per_question, QuestionNo,quizno) " +
               "VALUES ('" + quizid + "', '" + admin_id + "', '" + quizTitle + "', '" + Quiz_Description + "', '" + timeStr + "', '" + marks_per_question + "', '" + Questionno + "','" + quizno + "')";

              st.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Quiz Created");

        }
       catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed Try Again");
            e.printStackTrace();
         }
    }
    
    
   
       static String quiz_ids,admin_id; 
       static int question_no = 0,qno;
        protected static void checkquiz(String quiz_id, String Admin_id, Quiz currentInstance) {
    try {
        Connection connection =  Connections.getConnection();
        Statement st = connection.createStatement();
        String query2 = "SELECT * FROM quiz WHERE quiz_id = '" + quiz_id + "' AND Admin_user_name = '" + Admin_id + "'";

        ResultSet rs = st.executeQuery(query2);
        
        if (rs.next()) { // If at least one row is found
            qno = rs.getInt("QuestionNo");
            quiz_ids = quiz_id;
            admin_id = Admin_id;
            
            // Assuming 'Add_question' is the frame where you add questions
            Add_question quizframe = new Add_question();
            quizframe.setid(quiz_id);
            quizframe.setAdmin(Admin_id);
            quizframe.setVisible(true);
            currentInstance.dispose();
        } else {
            // No rows found
            JOptionPane.showMessageDialog(null, "No Quiz Found");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

       


      protected static void Add_question(String Question, String option1, String option2, String option3, String option4, String Correct_option, String Admin_id, String id) {
    try {
        Connection connection =  Connections.getConnection();
        Statement st = connection.createStatement();

        // Check if the question already exists
        String checkQuery = "SELECT * FROM add_question WHERE quiz_id = '" + id + "' AND question = '" + Question + "'";
        ResultSet rs = st.executeQuery(checkQuery);
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Question already exists!");
        } else {
            // Insert the question if it doesn't exist
            String query = "INSERT INTO add_question (questionno, quiz_id, Admin_user_name, question, option1, option2, option3, option4, correct_option) "
                    + "VALUES ('" + question_no + "','" + id + "', '" + Admin_id + "','" + Question + "', '" + option1 + "', '" + option2 + "', '" + option3 + "', '" + option4 + "','" + Correct_option + "')";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Question " + question_no + " added");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error occurred while adding the question");
        e.printStackTrace();
    }
}
       protected static ArrayList<String> Quizzes(String Adminname) 
       {
            ArrayList<String> quizIds = new ArrayList<>();
             try {
             Connection connection =  Connections.getConnection();
             Statement st = connection.createStatement();
             
             
            String query ="SELECT* FROM quiz WHERE Admin_user_name = '" + Adminname + "'ORDER BY quizno ASC";
            ResultSet rs = st.executeQuery(query);
            int i = 1;
            while(rs.next())
            {
                
                String quiz_id = rs.getString("quiz_id");
                String quiz_title = rs.getString("quiz_title");
                
                quizIds.add(quiz_id);
                quizIds.add(String.valueOf(i));
                quizIds.add(quiz_title);
                i++;
            }
            rs.close();
            st.close();
            connection.close(); 
       }
        catch(SQLException e)
        {
              e.printStackTrace();
        }
     return quizIds;
       }
       
       protected static ArrayList<String> QuizSetting(String Adminname,String Quizid)
       {
            ArrayList<String> quizzes = new ArrayList<>();
             try {
             Connection connection =  Connections.getConnection();
             Statement st = connection.createStatement();
             
             
            String query ="SELECT* FROM quiz WHERE quiz_id =  '" + Quizid + "'and Admin_user_name =  '" + Adminname + "'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                
                 String  quizdesc = rs.getString("quiz_description");
                String time_limit = rs.getString("time_limit");
                double marks = rs.getDouble("marks_per_question");
                int number_of_questions = rs.getInt("QuestionNo");
                quizzes.add(quizdesc);
                quizzes.add(time_limit);
                quizzes.add(String.valueOf(marks));
                quizzes.add(String.valueOf(number_of_questions));
                 rs.close();
            st.close();
            connection.close(); 
                
               
            }
        }  
        catch(SQLException e)
        {
              e.printStackTrace();
        }
         return quizzes;
       }
       
       protected void updatequiz(String Adminid,int questionno)
       {
             try
        {
               Connection connection =  Connections.getConnection();
               Statement st = connection.createStatement();
               SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
               String  timeStr = sdf.format(time);
               String query = "UPDATE quiz SET quiz_description = '" + Quiz_Description + "', time_limit = '" + timeStr + "', marks_per_question = '" + marks_per_question + "', QuestionNo = '" + questionno + "'where quiz_id ='" + quizid + "' and Admin_user_name='" + Adminid + "' ";
               st.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Settings Updated");
              st.close();
              connection.close();

        }
       catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed Try Again");
            e.printStackTrace();
         }
           
       }
       
    protected ArrayList<String> retriveQuestion(String Quizid , String Adminname)
    {
          ArrayList<String> questions = new ArrayList<>();
        try {
        Connection connection =  Connections.getConnection();
        Statement st = connection.createStatement();
        
            String Question;
            String option1;
            String option2;
            String option3; 
            String option4;
            String correctoption;
        
        String query ="SELECT* FROM add_question WHERE quiz_id =  '" + Quizid + "'and Admin_user_name =  '" + Adminname + "' order by questionno ";
            ResultSet rs = st.executeQuery(query);
            quiz_ids = Quizid;
            admin_id = Adminname;
            while(rs.next())
            {
             Question = rs.getString("question");
             option1 = rs.getString("option1");
             option2 = rs.getString("option2");
             option3 = rs.getString("option3");
             option4 = rs.getString("option4");
             correctoption = rs.getString("correct_option");
             
             questions.add(Question);
             questions.add(option1);
             questions.add(option2);
             questions.add(option3);
             questions.add(option4);
             questions.add(correctoption);
             
             
            }
             rs.close();
             st.close();
             connection.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed Try Again");
            e.printStackTrace();
         }
        return questions;
        
    }
    protected void updatequestions(String Question, String Option1, String Option2, String Option3, String Option4, String Correct_option, String Admin_id, int questionno, String quizid) {
    try {
         System.out.println("Question: " + Question);
        System.out.println("Option 1: " + Option1);
        System.out.println("Option 2: " + Option2);
        System.out.println("Option 3: " + Option3);
        System.out.println("Option 4: " + Option4);
        System.out.println("Correct Option: " + Correct_option);
        System.out.println("Admin ID: " + Admin_id);
        System.out.println("Question Number: " + questionno);
        System.out.println("Quiz ID: " + quizid);

        Connection connection =  Connections.getConnection();
        Statement st = connection.createStatement();
        String query = "UPDATE add_question SET question = '" + Question + "', option1 = '" + Option1 + "', option2 = '" + Option2 + "', option3 = '" + Option3 + "', option4 = '" + Option4 + "', correct_option = '" + Correct_option + "' WHERE questionno = '" + questionno + "' AND Admin_user_name = '" + Admin_id + "' AND quiz_id = '" + quizid + "'";
        st.executeUpdate(query); 
        JOptionPane.showMessageDialog(null, "Quiz Updated");
        st.close();
        connection.close(); 
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Failed Try Again");
        e.printStackTrace();
    }
}
    protected void deletequestions(int Questionno , String quizId , String adminUserName)
    {
        try {
        Connection connection =  Connections.getConnection();
        Statement st = connection.createStatement();
        String deleteQuery = "DELETE FROM add_question WHERE questionno = " + Questionno + " AND quiz_id = '" + quizId + "' AND Admin_user_name = '" + adminUserName + "'";
        st.executeUpdate(deleteQuery);

        // Step 2: Update the questionno of the remaining questions
        String updateQuery = "UPDATE add_question SET questionno = questionno - 1 WHERE questionno > " + Questionno + " AND quiz_id = '" + quizId + "' AND Admin_user_name = '" + adminUserName + "'";
        st.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Question deleted successfully");
         
        
    }
         catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Failed Try Again");
        e.printStackTrace();
    }
            
}
}

      
 



class user 
{
    static  String studusername;
       protected static void StudentLogin(String username,String password,studentlogin currentInstance,String Admin)
      {
           try {
             Connection connection = getConnection();
             Statement st = connection.createStatement();
             name = Admin;
             studusername = username;
             
           String query = "SELECT Student_user_name,Password,Admin_user_name FROM Student WHERE Student_user_name = '" + username + "' AND Password = '" + password + "' AND Admin_user_name ='" + Admin + "' ";

            ResultSet rs = st.executeQuery(query);
            
            // Check if the result set contains any rows
            if (rs.next()) { // If there is at least one row
                // Successful login
                  userdashboard userframe =  new userdashboard();
                  userframe.setusername(username);
                  userframe.setVisible(true);
                  currentInstance.dispose();
            } else {
                // No rows found, login failed
                 JOptionPane.showMessageDialog(null,"No Account Found"); 
            }

            // Close result set, statement, and connection
            rs.close();
            st.close();
            connection.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
      }
      protected static void optionSelected(String idquiz , String Adminname ,int questionNo,String Studentname,String Selectedoption )
      {
            try {
                Connection connection =  Connections.getConnection();
                Statement st = connection.createStatement();
                String query = "INSERT INTO attemptedquestion (questionno, quiz_id, Admin_user_name, Student_user_name , optionSelected) "
                    + "VALUES ('" + questionNo + "','" + idquiz + "', '" + Adminname + "','" + Studentname + "', '" + Selectedoption + "')";
                st.executeUpdate(query);
            
                
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error occurred while adding the question");
        e.printStackTrace();
    }
            
                
      }
      protected static String result(String username, String quiz_id, String Adminname) throws IOException {
    String resultString = "";
    try {
        Connection connection = getConnection();
        Statement st = connection.createStatement();

        String query = "SELECT " +
                "COUNT(a.optionselected) AS correct_answers_count, " +
                "q.marks_per_question, " +
                "q.QuestionNo " +
                "FROM " +
                "attemptedquestion a " +
                "JOIN add_question a1 ON a.questionno = a1.questionno " +
                "JOIN quiz q ON a.quiz_id = q.quiz_id " +
                "WHERE " +
                "a.optionselected = a1.correct_option " +
                "AND q.quiz_id = '" + quiz_id + "' " +
                "AND a.Admin_user_name = '" + Adminname + "' " +
                "AND a.Student_user_name = '" + username + "' " +
                "GROUP BY " +
                "q.quiz_id, q.marks_per_question, q.QuestionNo";

        ResultSet resultSet = st.executeQuery(query);

        // Default values for marks calculation
        int totalQuestions = 0;
        double marksPerQuestion = 0;
        double obtainedMarks = 0;

        if (resultSet.next()) {
            int correctAnswersCount = resultSet.getInt("correct_answers_count");
            marksPerQuestion = resultSet.getDouble("marks_per_question");
            totalQuestions = resultSet.getInt("QuestionNo");

            double totalMarks = totalQuestions * marksPerQuestion;
            obtainedMarks = correctAnswersCount * marksPerQuestion;

            resultString = obtainedMarks + " / " + totalMarks;
        } else {
            // If no results found, set totalQuestions and marksPerQuestion from another query
            String queryTotal = "SELECT marks_per_question, QuestionNo FROM quiz WHERE quiz_id = '" + quiz_id + "'";
            ResultSet totalResultSet = st.executeQuery(queryTotal);
            if (totalResultSet.next()) {
                marksPerQuestion = totalResultSet.getDouble("marks_per_question");
                totalQuestions = totalResultSet.getInt("QuestionNo");
                double totalMarks = totalQuestions * marksPerQuestion;
                resultString = "0 / " + totalMarks;
            }
        }

        // Insert the result into the marksheet table
        String insertQuery = "INSERT INTO marksheet (Marks, Student_user_name, Admin_user_name, quiz_id) " +
                             "VALUES (" + obtainedMarks + ", '" + username + "', '" + Adminname + "', '" + quiz_id + "')";
        st.executeUpdate(insertQuery);

        // Close resources
        resultSet.close();
        st.close();
        connection.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return resultString;
}


   protected  static ArrayList<String> getResult(String quiz_id,String Admin)
   {
         ArrayList<String> results = new ArrayList<>();
     try {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();  
        String query = "SELECT * FROM marksheet WHERE quiz_id = '" + quiz_id + "'  AND Admin_user_name ='" + Admin + "' order by Marks desc ";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next())
        {
            results.add(rs.getString("quiz_id"));
            results.add(rs.getString("Student_user_name"));
            results.add(String.valueOf(rs.getDouble("Marks")));
            
        }

        rs.close();
        statement.close();
        connection.close();
   }
      catch (SQLException ex) {
        ex.printStackTrace();
    }
     return results;
   }
   public static boolean checkMarksExist(String quizId, String studentUsername, String adminUsername) {
    try {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        
        String query = "SELECT COUNT(*) FROM marksheet WHERE quiz_id = '" + quizId + "' AND Student_user_name = '" + studentUsername + "' AND Admin_user_name = '" + adminUsername + "'";
        ResultSet resultSet = statement.executeQuery(query);
        
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // If count > 0, marks exist; otherwise, marks do not exist
        }
        
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false; // Default to false if any exception occurs
}

}




       
     




