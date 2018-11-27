package test.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import question.QuestionDAO;
import question.QuestionDTO;

public class QuestionTest {

	public static void main(String[] args) {
		QuestionDAO dao = new QuestionDAO();
		
		//create(dao);
		//list(dao);
		//read(dao);
		update(dao);
		//delete(dao);
		//total(dao);
		//checkPasswd(dao);

	}

	private static void update(QuestionDAO dao) {
		QuestionDTO dto = new QuestionDTO();
		
		dto.setTitle("제목변경");
		dto.setContent("내용변경");
		dto.setPhone("010-1234-1234");
		dto.setQuestionNum(1);
		
		try {
			if (dao.update(dto)) {
				p("성공");
			} 
			else {
				p("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void read(QuestionDAO dao) {
		
		try {
			QuestionDTO dto = dao.read(1);
			
			p(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void list(QuestionDAO dao) {
		Map map = new HashMap();
		
		map.put("col", "questionType");
		map.put("word", "문의");
		map.put("sno", 1);
		map.put("eno", 5);
		
		try {
			List<QuestionDTO> list = dao.list(map);
			
			for(int i=0; i<list.size(); i++) {
				QuestionDTO dto = list.get(i);
				
				p(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void p(QuestionDTO dto) {
		p("번호 : " + dto.getQuestionNum());
		p("문의유형 : " + dto.getQuestionType());
		p("작성자 : " + dto.getWname());
		p("제목 : " + dto.getTitle());
		p("내용 : " + dto.getContent());
		p("전화번호 : " + dto.getPhone());
		p("비밀번호 : " + dto.getPasswd());
		p("작성일자 : " + dto.getWdate());		
		
	}

	private static void create(QuestionDAO dao) {
		QuestionDTO dto = new QuestionDTO();
		
		dto.setQuestionType("예약문의");
		dto.setWname("작성자1");
		dto.setTitle("제목1");
		dto.setContent("내용1");
		dto.setPasswd("123");
		dto.setPhone("010-0000-0000");
		dto.setWdate("2018-11-12");
		
		try {
			if (dao.create(dto)) {
				p("성공");
			} 
			else {
				p("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void p(String string) {
		System.out.println(string);
		
	}

}
