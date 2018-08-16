package vo;

public class SungVo {
	
	int idx;
	String name;
	int kor,eng,mat,tot;
	String avg; //이런 소수점은 그냥 String으로 하는게 더 좋다.
	int rank;
	
	
	
	public SungVo(int idx, String name, int kor, int eng, int mat) {
		super();
		this.idx = idx;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;

	}
	
	
	public SungVo(int idx, String name, int kor, int eng, int mat, int tot, String avg, int rank) {
		super();
		this.idx = idx;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avg = avg;
		this.rank = rank;
	}
	public SungVo() {
		// TODO Auto-generated constructor stub
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	
}
