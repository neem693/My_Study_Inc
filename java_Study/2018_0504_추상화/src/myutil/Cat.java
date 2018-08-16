package myutil;

public class Cat extends Animal{
	
	public Cat() {
		super.name = "»ş»ş";
		super.type = "°í¾çÀÌ";
	}
	
	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("¾ß¿Ë ¾ß¿Ë");
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Áã¸¦ ¸Ô´Â´Ù.");
	}

}
