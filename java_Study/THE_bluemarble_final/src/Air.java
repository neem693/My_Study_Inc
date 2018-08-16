import java.awt.Graphics;

public class Air extends Item{

	
	public static int INDEX_INTERVAL = 3;
	
	int index;
	
	int index_interval = INDEX_INTERVAL; // 비행기 속도 조절
	
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		if(index_interval == INDEX_INTERVAL)
		{
			
			index++; // 
		}
		index_interval--;
		if(index_interval < 0)
			index_interval = INDEX_INTERVAL;
		
		return (index < Start.airplane.length);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Start.airplane[index], pos.x, pos.y, null);
	}

}
