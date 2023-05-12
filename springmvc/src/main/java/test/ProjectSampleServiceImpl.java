package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//서비스에서  DAO 메소드호출
@Service
public class ProjectSampleServiceImpl implements ProjectSampleService {
	@Autowired
	ProjectSampleDAO dao;
	@Override
	public void servicetest() {
		System.out.println("난 서비스단");
		dao.test();
		
	}

}
