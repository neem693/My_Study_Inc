import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AirManager {

	Air air = new Air();// 비행기 객체
	//public List<Air> air_list = new ArrayList<Air>();
	
	public void air_pos(int x, int y)
	{
		
	}
	
	public boolean move()
	{
		return air.move();//그림파일이 다 돌았냐?
		
	}
	public void draw(Graphics g)
	{
		//for(Air air : air_list) 
		
			air.draw(g);
		
	}
}
