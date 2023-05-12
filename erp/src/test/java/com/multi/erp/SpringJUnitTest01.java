package com.multi.erp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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

public class SpringJUnitTest01 {
	@Autowired
	DataSource ds;
	@Test
	public void test() {
		assertNotNull(ds);
	}

}
