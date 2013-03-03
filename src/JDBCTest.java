import java.sql.*;
public class JDBCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String driver = "com.mysql.jdbc.Driver";         // 驱动程序名

        
        String url = "jdbc:mysql://50.63.108.186:3306/eco1231506564054";     // URL指向要访问的数据库名scutcs          
        
        String user = "eco1231506564054";       // MySQL配置时的用户名

        String password = "Bizee123!";      // MySQL配置时的密码

        try { 
         
         Class.forName(driver);    // 加载驱动程序

        
         Connection conn = DriverManager.getConnection(url, user, password);      // 连续数据库

         if(!conn.isClosed()) 
          System.out.println("Succeeded connecting to the Database!");     //验证是否连接成功

         
         Statement statement = conn.createStatement();               // statement用来执行SQL语句

        
         String sql = "select * from jos_users";                  // 要执行的SQL语句

        
         ResultSet rs = statement.executeQuery(sql);       // 结果集


         String name = null;

         while(rs.next()) {
 
         
          name = rs.getString("name");                            // 选择sname这列数据
 
         
          System.out.println(name + rs.getString("email"));        // 输出结果
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
