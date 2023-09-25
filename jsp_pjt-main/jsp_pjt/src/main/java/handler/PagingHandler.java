package handler;

import domain.PagingVO;

public class PagingHandler {
	//jsp에서 list 하단에 나올 페이지네이션 핸들링 클래스
	private int startPage; //현재 화면에서 보여줄 시작 페이지네이션 번호
	private int endPage; //현재 화면에서 보여줄 마지막 페이지네이션 번호
	private int realEndPage; //마지막 실제 전체 페이지 번호
	private boolean prev, next; //이전, 다음페이지 존재 여부
	
	private int totalCount; //전체 글 수
	private PagingVO pgvo; //페이징VO 가져오기 
	
	public PagingHandler(PagingVO pgvo, int totalCount) { 
		this.pgvo = pgvo;
		this.totalCount = totalCount;

		this.endPage = 
				(int)Math.ceil(pgvo.getPageNo() / (double)pgvo.getQty()) * pgvo.getQty();
		//한 페이지에 10개의 항목을 보여주고, 현재 페이지 번호가 23일 경우, `(23 / 10)`의 계산 결과가 2.3이므로, `Math.ceil()` 메서드를 사용하여 올림한 값인 3페이지가 된다.
		
		// 1~10까지는 마지막 페이지가 10, 11~20 마지막 페이지 20, 21~30 마지막 페이지 30
		//페이지번호(1) / 한 화면의 게시글 수(10) * 한 화면의 게시글 수(10)
		// 1 / 10 = 0.1 * 10 = 10 / 0.1 을 1로 만들어야됨
		// 2 / 10 = 0.2 * 10 = 10 / 0.2 을 1로 만들어야됨
		
		this.startPage = this.endPage - 9;
		
		// 30일 경우, `30 - 9`의 계산 결과로 `startPage` 변수에 21이 첫숫자가 된다
		// 27일 경우, `27 - 9 = 18`
		
		this.realEndPage = 
				(int)Math.ceil(totalCount / (double)pgvo.getQty());
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
			
//			예를 들어, 한 페이지에 10개의 항목을 보여주고, 총 27개의 항목이 있다면 다음과 같이 `this.realEndPage`와 `this.endPage`의 값을 계산합니다.
			
//			1. `this.realEndPage = (int)Math.ceil(27 / (double)10);`
//			   - `27 / 10`은 `2.7`이지만, `Math.ceil()` 함수를 사용하여 올림하면 `3`이 됩니다.
//			   - 따라서, `this.realEndPage`의 값은 `3`이 됩니다.
//			   
//			2. `if(this.realEndPage < this.endPage) {`
//			   - `this.realEndPage` 값이 `this.endPage` 값보다 작기 때문에, 아래의 코드가 실행됩니다.
//			   
//			3. `this.endPage = this.realEndPage;`
//			   - `this.endPage`의 값을 `this.realEndPage`의 값인 `3`으로 조정합니다.
//			   
//			따라서, 최종적으로 `this.endPage`의 값은 `3`이 됩니다.
			
			this.prev = this.startPage > 1; //존재여부
			// 이전 페이지는 1페이지 이상일 때만 생긴다
			
			this.next = this.endPage < this.realEndPage;
			// 다음 페이지 
		}
		
		

		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}
	
	
	
	
}
