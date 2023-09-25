package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.CommentDAO;
import dao.CommentDAOImpl;
import domain.CommentVO;


public class CommentServiceImpl implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO cdao;
	
	public CommentServiceImpl() {
		cdao = new CommentDAOImpl();
	}

	//메서드 구현
	@Override
	public int post(CommentVO cvo) {
		
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		
		return cdao.getList(bno);
	}

	@Override
	public int modify(CommentVO cvo) {
		
		return cdao.update(cvo);
	}

	@Override
	public int remove(int cno) {
		
		return cdao.delete(cno);
	}

	public int deleteAll(int bno) {
		// BoardServiceImpl에서 보내온 메서드
		return cdao.deleteAll(bno);
	}

	public int commentCount(int bno) {
		// BoardServiceImpl에서 보내온 댓글 개수 메서드
		return cdao.commentCount(bno);
	}
	
}
