import java.sql.*;
public class JDBCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String driver = "com.mysql.jdbc.Driver";         // ����������

        
        String url = "jdbc:mysql://50.63.108.186:3306/eco1231506564054";     // URLָ��Ҫ���ʵ����ݿ���scutcs          
        
        String user = "eco1231506564054";       // MySQL����ʱ���û���

        String password = "Bizee123!";      // MySQL����ʱ������

        try { 
         
         Class.forName(driver);    // ������������

        
         Connection conn = DriverManager.getConnection(url, user, password);      // �������ݿ�

         if(!conn.isClosed()) 
          System.out.println("Succeeded connecting to the Database!");     //��֤�Ƿ����ӳɹ�

         
         Statement statement = conn.createStatement();               // statement����ִ��SQL���

        
         String sql = "select * from jos_users";                  // Ҫִ�е�SQL���

        
         ResultSet rs = statement.executeQuery(sql);       // �����


         String name = null;

         while(rs.next()) {
 
         
          name = rs.getString("name");                            // ѡ��sname��������
 
         
          System.out.println(name + rs.getString("email"));        // ������
         }

         rs.close();
         conn.close();

        } catch(ClassNotFoundException e) {


         System.out.println("Sorry,can`t find the Driver!"); 
         e.printStackTrace();


        } catch(SQLException e) {


         e.printStackTrace();


        } catch(Exception e) {


         e.printStackTrace();


        } 
	}

}
