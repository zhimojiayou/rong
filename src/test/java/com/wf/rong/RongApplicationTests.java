package com.wf.rong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RongApplicationTests {

	@Autowired
	private DataSource defaultDatasource;

	@Test
	public void contextLoads() {
	}

	@Test
	public void dataSourceTest() throws SQLException {
		// 获取数据库对象
		Connection connection = defaultDatasource.getConnection();
		System.out.println("获取连接：");
		// 判断连接对象是否为空
		System.out.println(connection != null);
		System.out.println("默认数据源为：" + defaultDatasource.getClass());
		connection.close();
	}

}
