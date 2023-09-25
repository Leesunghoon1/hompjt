package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//로그객체 선언
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    
	private RequestDispatcher rdp;
	// jsp에서 받은 요청을 처리하고, 처리의 결과를 다른 jsp로 보내는 역활 
	
	private String destPage;
	// 이동경로 저장
	
	private int isOK;
	//데이터베이스 받는 값
	
	private MemberService msv;
	// 서비스 -> 인터페이스 생성
	

    public MemberController() {

    	msv = new MemberServiceImpl(); 
    		
    	
    	

    }
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//언어 설정해주기
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		//주소 짤라서 스위치문에 넣기
		log.info("path" + path);
		
		switch(path) {
		case "join" :
			log.info("회원가입 페이지 이동");
			destPage = "/member/join.jsp";
			break;
			
		case "register" : //회원가입 디비에 저장하는 케이스
			try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			int pnum = Integer.parseInt(request.getParameter("pnum"));
			int age = Integer.parseInt(request.getParameter("age"));
			
			MemberVO mvo = new MemberVO(id, pwd, email, pnum, age);
			log.info("생성자 잘 만들어졌나?" + mvo);
			isOK = msv.register(mvo);
			log.info("register 체크4" + ((isOK > 0)? "ok" : "fail"));
			destPage = "/index.jsp";
			
			} catch (Exception e) {
				log.info("조인 에러");
				e.printStackTrace();
			}
			
			break;
		}
		
		
		
		//목적지 주소값 셋팅
		rdp = request.getRequestDispatcher(destPage);
		//정보실어 보내기
		rdp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
