package jdbc;

import org.junit.Test;

import java.sql.Driver;
import java.sql.DriverManager;


/**
 * @author nfx
 * @create 2022-07-26 9:51
 */
public class Connection {


    // 方式三：使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        // 1.获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供另外三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/supermarket_system";
        String user = "root";
        String password = "abc123";

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection conn = (Connection) DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

}
