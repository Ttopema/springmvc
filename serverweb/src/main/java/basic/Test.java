package basic;
abstract class A{
	abstract void print();
}
class Sub1 extends A{
	@Override
	void print() {
		System.out.println("Sub1의 print");
	}
}
class Sub2 extends A{
	@Override
	void print() {
		System.out.println("Sub2의 print");
	}
}
class Sub3{
	void print() {
		System.out.println("Sub3의 print");
	}
}
public class Test {
	public static void run(A obj) {
		obj.print();
	}
	public static void main(String[] args) {
		A obj = new Sub1();
		run(obj); //run안에서 print메소드를 자동으로 호출
		A obj2 = new Sub2();
		run(obj2);
		//A obj3 = new Sub3();
		//run(obj3);
	}

}
