package basic;

public class Calc {
	public int calc(int num1, String method, int num2) {
		System.out.println("비지니스 메소드 호출 성공");
		int result = 0;
		switch (method) {
			case "+":
				result = num1+num2;
				break;
			case "-":
				result = num1-num2;
				break;
			case "*":
				result = num1*num2;
				break;
			case "/":
				result = num1/num2;
				break;
		}
		return result;
	}
}
