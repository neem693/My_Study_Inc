package myutil;

public class Dog extends Animal{
	
	
	
	public Dog() {
		super.name = "¹Ù½Ç¸®";
		super.type = "°³";
	}
	
	@Override
	public void cry() {
		System.out.println("¿Ð¿Ð");
		
	}
	@Override
	public void eat() {
		System.out.println("°³»ç·á¸¦ ¸Ô´Â´Ù.");
	}

}
