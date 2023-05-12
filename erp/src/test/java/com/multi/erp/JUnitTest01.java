package com.multi.erp;

import static org.junit.Assert.*;


import org.junit.Test;

public class JUnitTest01 {

	@Test
	public void test() {
//		assertEquals("1", "1"); //첫번째 값하고 두번째 값하고 같냐 다르냐를 체크하는 것임.
		assertNotNull(new String()); //null이냐 아니냐를 체크함
	}

}
