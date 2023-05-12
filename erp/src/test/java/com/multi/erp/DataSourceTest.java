package com.multi.erp;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

//단위테스트를 스프링과 연동하기
//@RunWith는 단위테스트의 실행방법을 확장할때 사용하는 어노테이션으로 ()안에 정의하는 클래스를
//실행해서 단위테스트를 하겠다는 의미 => 스프링과 연동해서 단위테스트 하겠다는 의미임.

@RunWith(SpringJUnit4ClassRunner.class) //오류뜸. 해결방법은?? ==> pom.xml
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring-config.xml"})
@WebAppConfiguration
//<plugin>
//<groupId>org.apache.maven.plugins</groupId>
//<artifactId>maven-compiler-plugin</artifactId>
//<version>2.5.1</version>
//<configuration>
//	<source>1.6</source>
//	<target>1.6</target>
//	<compilerArgument>-Xlint:all</compilerArgument>
//	<showWarnings>true</showWarnings>
//	<showDeprecation>true</showDeprecation>
//</configuration>
//</plugin>

//<source>1.8</source>
//<target>1.8</target> 둘다 1.8로 올려줘야함

public class DataSourceTest {
	@Autowired
	private DataSource ds;
	private JdbcTemplate template;
	@Test
	public void test() {
//		assertNotNull(ds);
		try {
			StopWatch stopwatch = new StopWatch();
			
			stopwatch.start();
			Connection con1 = ds.getConnection(); //커넥션풀에서 커넥션을 만드는 작업
			Connection con2 = ds.getConnection();
			Connection con3 = ds.getConnection();
			Connection con4 = ds.getConnection();
			Connection con5 = ds.getConnection();
			Connection con6 = ds.getConnection();
			Connection con7 = ds.getConnection();
			Connection con8 = ds.getConnection();
			Connection con9 = ds.getConnection();
			Connection con10 = ds.getConnection();
			System.out.println(con1);
			System.out.println(con2);
			System.out.println(con3);
			System.out.println(con4);
			System.out.println(con5);
			System.out.println(con6);
			System.out.println(con7);
			System.out.println(con8);
			System.out.println(con9);
			System.out.println(con10);
			stopwatch.stop();
			System.out.println(stopwatch.prettyPrint()); // 측정된 시간 출력
//			Connection con11 = ds.getConnection();
//			System.out.println(con11);
			System.out.println("ds===> " + ds);
			System.out.println("template===> " + template);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
