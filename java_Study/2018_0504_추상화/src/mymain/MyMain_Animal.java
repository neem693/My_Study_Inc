package mymain;

import myutil.Animal;
import myutil.Cat;
import myutil.Dog;
import myutil.Pig;

public class MyMain_Animal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal [] ani = {
			new Dog(),
			new Cat(),
			new Pig()
		};
		
		for(Animal a : ani) {
			System.out.println(a.name);
			System.out.println(a.type);
			a.cry();
			a.eat();
		}
	}
}
