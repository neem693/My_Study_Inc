package mymain;

public class MyMain_Enum {
	
	public static final int LEFT = 1;
	public static final int UP = 2;
	public static final int RIGHT = 4;
	public static final int DOWN = 8;
	
	enum Direction{
		LEFT,UP,RIGHT,DOWN
	}

	public static void main(String[] args) {
		
		int direction = LEFT;
		
		if(direction == LEFT)
			System.out.println("--현재 이동방향은 왼쪽입니다---");
		
		Direction direction2 = Direction.UP;
		if(direction2 == Direction.UP)
			System.out.println("--현재 이동방향은 윗쪽입니다---");

	}

}
