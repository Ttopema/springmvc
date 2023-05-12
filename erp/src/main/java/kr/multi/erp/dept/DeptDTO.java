package kr.multi.erp.dept;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@ToString
//@Getter
//@Setter
@Data // @Setter @Getter @ToString를 한번에
@AllArgsConstructor //전체 매개변수를 매개변수로 하는 생성자 정의.
@NoArgsConstructor //기본생성자
@RequiredArgsConstructor // @NonNull해놓은 곳을 생성자로 만듦.
public class DeptDTO {
	@NonNull
	private String deptno;
	@NonNull
	private String deptname;
	private String deptStartDay;
	private String deptEndDay;
	private String deptlevel;
	private String deptstep;
	private String deptuppercode;
	private String job_category;
	private String mgr_id;
	private String deptaddr;
	private String depttel;
	
}
