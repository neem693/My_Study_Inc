package inter;

public interface Channel {
	
	int MIN_CHANNEL =1;
	int MAX_CHANNEL = 100;
	
	void channelUp();
	void channelDown();
	void setChannel(int channel);
	void setChannel();

}
