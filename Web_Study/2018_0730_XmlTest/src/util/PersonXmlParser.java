package util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


import vo.PersonVo;

public class PersonXmlParser {

	public static List<PersonVo> getPersonList() {
		List<PersonVo> list = new ArrayList<PersonVo>();

		try {
			SAXBuilder builder = new SAXBuilder();
			URL url = new URL("http://192.168.0.5:9090/2018_0730_XmlTest/person.xml");
			Document doc = builder.build(url.openStream());
			System.out.println(doc.toString());
			Element root = doc.getRootElement();
			List<Element> p_list = root.getChildren();

			// 자식 요소(person)를 순서대로 반복
			for (Element person : p_list) {
				PersonVo vo = new PersonVo();

				String name = person.getChildText("name");
				String nickname = person.getChild("name").getAttributeValue("nickname");
				int age = Integer.parseInt(person.getChildText("age"));
				String tel = person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");
				
				vo.setName(name);
				vo.setNickname(nickname);
				vo.setAge(age);
				vo.setTel(tel);
				vo.setHometel(hometel);

				list.add(vo);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
