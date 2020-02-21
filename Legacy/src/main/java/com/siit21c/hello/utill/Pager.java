package com.siit21c.hello.utill;


public class Pager {
	int page = 1;
	int bunch = 10;
	float total;

	public float getTotal() {//다른 클래스들과의 값과 연결된게 하나도없기때문에 의존성이 없다 -->재사용성이 뛰어나다 어디든 가져다 쓸수있다.
		// 로직 3개있음 12345 678910 나누는거 , 자기페이지 중심으로 자기 페이지가 첫번째 있는거, 계속 중앙에 위치하는거  총 3가지 로직
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBunch() {
		return bunch;
	}
	public void setBunch(int bunch) {
		this.bunch = bunch;
	}

	
	public String getPagination() {
		String html = "<div class=\"pagination pagination-sm justify-content-center\">";
		int maxPage = (int)Math.ceil(total / bunch);//float를 올림해서 정수로 만들어줌 max.ceil -> 리턴값은 더블형
		int startPage = (page < 3) ? 1 : (page -2 );//삼항연산자로 코드줄이기   3일때 1, 4일때 2, 5일때 3을 가르키는 앞쪽 max페이지
		int endPage = (page < 3) ? 5 : (page + 2);//3일때 5, 4일때 6, 5일때 7을 가르키는 뒤쪽 max페이지
		
		html += "<span class=\"page-item\"><a class=\"page-link\" href=\"?page= 1\" >처음</a></span>";//처음으로 가는코드
		html += "<span class=\"page-item\"><a class=\"page-link\" href=\"?page=" +(page > 1 ? page-1 : 1) + "\">이전</a></span>";//이전페이지로이동
		
		for(int i=startPage; i <= endPage && i <= maxPage; i++) {//마지막페이지보다 작거나같고, 
			html += "<span class=\"page-item ";
			if(i==page)//active로  3번페이지를 보여줄 때 3번에 active효과 나도록 하기 위한 if문
				html +="active";
			html += "\"><a class=\"page-link\" href=\"?page=" +i+ "\">"+i+"</a></span>";//나머지 코드들
		}
		
		html += "<span class=\"page-item\"><a class=\"page-link\" href=\"?page=" + (page < maxPage ? page+1 : maxPage) + "\">다음</a></span>";//다음페이지로이동
		html += "<span class=\"page-item\"><a class=\"page-link\" href=\"?page=" + maxPage + "\">마지막</a></span>";//마지막페이지로이동
		html += "</div>";
				
		return html;
	}
}
