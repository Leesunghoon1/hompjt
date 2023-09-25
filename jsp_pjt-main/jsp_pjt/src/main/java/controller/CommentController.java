package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImpl;


@WebServlet("/cmt/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
    //비동기 방식  => 페이지 이동 방식X => destPageX requestdispacherX
	private CommentService csv;
    private int isOk;
    
    public CommentController() {
       csv = new CommentServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//response의 setContentType 설정은 하지 않음.
		
		String uri = request.getRequestURI(); // 
		// /brd/detail?bno=1;  => 동기방식 주소
		// 동기방식 => get, post 
		// /cmt/list/10, /cmt/post, /cmt/update => RestAPI 방식
		// get=>리스트 보여줄때, post=>등록시, put=>updtate, delete=>delete
		String pathUri = uri.substring("/cmt/".length()); //post, list/10
		String path = pathUri;
		String pathVar = ""; //없으면 공백처리
		if(pathUri.contains("/")) {   //패스값을 달고왔다면...
			path = pathUri.substring(0, pathUri.lastIndexOf("/"));  //list
			pathVar = pathUri.substring(pathUri.lastIndexOf("/")+1); //10
		}
		
		log.info(">>> uri > "+uri);
		log.info(">>> pathUri > "+ pathUri);
		log.info(">>> path > "+ path);
		log.info(">>> pathVar > "+ pathVar);
		
		switch(path) {
		case "post":
			try {
				//JSON 방식으로 화면에서 보낸 데이터를 받을 준비
				//String 형태로 값을 받아 객체로 변환 
				//json-simple-1.1.1 라이브러리를 사용하여
				//Json 형태의 스트링을 객체 형태로 변환
				StringBuffer sb = new StringBuffer();
				//append
				String line="";
				BufferedReader br = request.getReader(); //cmtData를 읽어오는 객체
				while((line = br.readLine())!=null) {
					sb.append(line);
				}
				log.info(">>>>> sb : "+ sb.toString());
				
				//객체로 변환
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				
				//CommentVO 형태로 변환
				int bno = Integer.parseInt(jsonObj.get("bno").toString());
				String writer = jsonObj.get("writer").toString();
				String content = jsonObj.get("content").toString();
				
				//csv DB로 저장
				CommentVO cvo = new CommentVO(bno, writer, content);
				log.info(">>> cvo "+cvo);
				isOk = csv.post(cvo);
				log.info((isOk>0)?"OK":"FAIL");
				
				//화면에 출력
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
			} catch (Exception e) {
				log.info(">> Comment > post > error ");
				e.printStackTrace();
			}
			break;
			
		case "list":  //list/151
			try {
				int bno = Integer.parseInt(pathVar);
				List<CommentVO> list = csv.getList(bno);
				log.info(">>>> comment > List >"+ list);
				//json 형태로 변환 => 화면에 전송
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				// '[{…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}]'
				//{bno: 192, cno: 13, regdate: '2023-09-20 19:34:19', writer: '1234', content: '222'}
				JSONArray jsonList = new JSONArray();
				for(int i=0; i<list.size(); i++) {
					jsonObjArr[i] = new JSONObject(); // key:value
					jsonObjArr[i].put("cno", list.get(i).getCno());
					jsonObjArr[i].put("bno", list.get(i).getBno());
					jsonObjArr[i].put("writer", list.get(i).getWriter());
					jsonObjArr[i].put("content", list.get(i).getContent());
					jsonObjArr[i].put("regdate", list.get(i).getRegdate());
					
					jsonList.add(jsonObjArr[i]);
				}
				String jsonData = jsonList.toJSONString(); //전송용
				
				//전송 객체에 싣고 화면으로 전송
				PrintWriter out = response.getWriter();
				out.print(jsonData);
				
			} catch (Exception e) {
				log.info(">>> Comment > list > error");
				e.printStackTrace();
			}
			break;
			
		case "modify":
			try {
				StringBuffer sb = new StringBuffer();
				String line="";
				
				BufferedReader br = request.getReader();
				while((line=br.readLine())!=null) {
					sb.append(line);
				}
				log.info(">> sb > "+sb.toString());
				
				//Json 형태의 객체로 변환
				JSONParser parser = new JSONParser();
				JSONObject jsonobj = (JSONObject) parser.parse(sb.toString());
				int cno = Integer.parseInt(jsonobj.get("cno").toString());
				String writer = jsonobj.get("writer").toString();
				String content = jsonobj.get("content").toString();
				
				CommentVO cvo = new CommentVO(cno, content);
				isOk = csv.modify(cvo);
				log.info(">>>>> modify >"+(isOk>0?"OK":"Fail"));
				
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
			} catch (Exception e) {
				log.info(">>>> Comment > modify > error");
				e.printStackTrace();
			}
			
			break;
			
		case "remove":
			try {
				//쿼리 스트링으로 데이터를 보냈을 경우.
				int cno = Integer.parseInt(request.getParameter("cno")); 
				log.info("remove > cno>>>>"+cno);
				
				isOk = csv.remove(cno);
				log.info(">>>>> remove >"+(isOk>0?"OK":"Fail"));
				
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
			} catch (Exception e) {
				log.info(">>> Comment > remove > error");
				e.printStackTrace();
			}
			
			break;
			
			
		}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
