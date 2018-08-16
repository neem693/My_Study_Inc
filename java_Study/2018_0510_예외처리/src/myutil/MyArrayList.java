package myutil;

public class MyArrayList {
	Object[] data;

	public MyArrayList() {
		data = null;
	}

	public int size() {
		return (data == null) ? 0 : data.length;
	}

	public void add(Object newObj) {

		// 임시배열
		Object[] im = new Object[size() + 1];

		for (int i = 0; i < size(); i++)
			im[i] = data[i];
		im[size()] = newObj;

		data = im;

	}

	public Object get(int index) throws Exception {
		if (index < 0 || index >= size()) {
			String msg = String.format("첨자범위: 0~%d까지 들어온 값 : %d", size() - 1, index);
			throw new Exception(msg);
		}

		return data[index];
	}

	public void remove(int index) throws Exception {
		boolean com_index = false;

		if (index < 0 || index >= size()) {
			String msg = String.format("첨자범위: 0~%d까지 들어온 값 : %d", size() - 1, index);
			throw new Exception(msg);
		}
		if (size() == 1) {
			data = null;
			return;
		}
		Object[] im = new Object[size() - 1];

		for (int i = 0; i < size(); i++) {
			if (index == i) {
				com_index = true;
				continue;
			} else if (com_index) {
				im[i - 1] = data[i];
			} else
				im[i] = data[i];
		}

		data = im;

	}
	
	public void allget() {
		for(int i =0;i<this.size(); i++) {
			System.out.println(this.data[i]);
		}
	}

}
