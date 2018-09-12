package mymain;


import java.util.ArrayList;

import org.apache.lucene.analysis.ko.morph.MorphException;

import util.ArirangAnalyzerHandler;

public class Main {
	public static void main(String[] args) throws MorphException {
	
		// 형태소 분석
		ArirangAnalyzerHandler aah = new ArirangAnalyzerHandler();
		String input1 = "올해 크리스마스에는 눈이 내리지 않고 비교적 포근할 전망이다.";
		String result1 = aah.morphAnalyze(input1);
		System.out.println("형태소 분석 : " +  result1);

		// 복합명사 분해
		String input2 = "하늘공원";
		String result2 = aah.compoundNounAnalyze(input2);
		System.out.println("복합 명사 분해 : " + result2);

		// 띄워쓰기
		String input3 = "올 해크리스마스 에는 눈이내리지않고 비교적포근할전 망이다.";
		String result3 = aah.wordSpaceAnalyze(input3);
		System.out.println("뛰어 쓰기 : " + result3);

		// 색인어 추출
		String input4 = "올해 크리스마스에는 눈이 내리지 않고 비교적 포근할 전망이다.";
		String result4 = aah.guideWord(input4);
		System.out.println("색인어 추출 : " + result4);

		// 명사 추출
		System.out.print("명사 추출 : ");
		ArrayList<String> nuonList = aah.extractNoun(input4);
		for (String string : nuonList) {
			System.out.print(string + " ");
		}
		System.out.println();
		System.out.print("명사 + 동사 추출 : ");
		ArrayList<String> nuonVerbList = aah.extractNounVer(input1);
		for (String string : nuonVerbList) {
			System.out.print(string + " ");
		}
		
	}
}
