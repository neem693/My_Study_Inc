package inter;

import java.util.Scanner;

public class Tv implements RemoteCon {

	boolean bOnOff; // 꺼짐/켜짐상태
	int volume; // 볼륨상태
	int channel; // 채널상태
	Scanner s = new Scanner(System.in);

	public Tv() {
		volume = 10;
		channel = 9;
	}

	@Override
	public void volumeUp() {
		volume++;
		if (volume > Volume.MAX_VOLUME)
			volume = Volume.MAX_VOLUME;

		showTv();
	}

	@Override
	public void volumDown() {

		volume--;
		if (volume < Volume.MIN_VOLUME)
			volume = Volume.MIN_VOLUME;

		showTv();

	}

	@Override
	public void volumeZero() {

		volume = Volume.MIN_VOLUME;

		showTv();

	}

	@Override
	public void channelUp() {
		channel++;

		if (channel > Channel.MAX_CHANNEL)
			channel = Channel.MIN_CHANNEL;

		showTv();

	}

	@Override
	public void channelDown() {
		channel--;

		if (channel < Channel.MIN_CHANNEL)
			channel = Channel.MAX_CHANNEL;

		showTv();

	}

	@Override
	public void setChannel(int channel) {
		if (channel >= MIN_CHANNEL && channel <= MAX_CHANNEL)
			this.channel = channel;
		else
			System.out.println("채널 입력 오류");

		showTv();

	}

	public void setChannel() {
		int c = s.nextInt();
		if (c >= MIN_CHANNEL && c <= MAX_CHANNEL)
			this.channel = c;
		else
			System.out.println("채널 입력 오류");

		showTv();
	}

	@Override
	public void onOff() {

		bOnOff = !bOnOff;
		// 이게바로 토글방식

		showTv();

	}

	@Override
	public void showTv() {

		if (bOnOff == false) {
			System.out.println("---현재 TV 꺼짐---");
			return;
		}

		System.out.println("------[ TV 켜짐 ]--------");
		System.out.printf("-- 채널 : %d\n", channel);
		System.out.printf("-- 볼륨 : %d\n", volume);
		System.out.println("-------------------------");

	}

}
