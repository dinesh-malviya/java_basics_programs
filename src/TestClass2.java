
public class TestClass2 implements Runnable{
	private String name;
	public TestClass2(String name) {
		this.name=name;
	}
	public static void main(String[] args) {
		new Thread(new TestClass2("Wallance")).start();
		new Thread(new TestClass2("Gromit")).start();
		Runtime.getRuntime().gc();
	}

	public void run() {
		message(1);
		message(2);
	}

	private void message(int i) {
		System.out.println(name+"-"+i+" ");
	}
}
