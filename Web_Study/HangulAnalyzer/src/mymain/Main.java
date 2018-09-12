package mymain;


import java.util.ArrayList;

import org.apache.lucene.analysis.ko.morph.MorphException;

import util.ArirangAnalyzerHandler;

public class Main {
	public static void main(String[] args) throws MorphException {
	
		// ���¼� �м�
		ArirangAnalyzerHandler aah = new ArirangAnalyzerHandler();
		String input1 = "���� ũ������������ ���� ������ �ʰ� ���� ������ �����̴�.";
		String result1 = aah.morphAnalyze(input1);
		System.out.println("���¼� �м� : " +  result1);

		// ���ո�� ����
		String input2 = "�ϴð���";
		String result2 = aah.compoundNounAnalyze(input2);
		System.out.println("���� ��� ���� : " + result2);

		// �������
		String input3 = "�� ��ũ�������� ���� ���̳������ʰ� ������������ ���̴�.";
		String result3 = aah.wordSpaceAnalyze(input3);
		System.out.println("�پ� ���� : " + result3);

		// ���ξ� ����
		String input4 = "���� ũ������������ ���� ������ �ʰ� ���� ������ �����̴�.";
		String result4 = aah.guideWord(input4);
		System.out.println("���ξ� ���� : " + result4);

		// ��� ����
		System.out.print("��� ���� : ");
		ArrayList<String> nuonList = aah.extractNoun(input4);
		for (String string : nuonList) {
			System.out.print(string + " ");
		}
		System.out.println();
		System.out.print("��� + ���� ���� : ");
		ArrayList<String> nuonVerbList = aah.extractNounVer(input1);
		for (String string : nuonVerbList) {
			System.out.print(string + " ");
		}
		
	}
}
