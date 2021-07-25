package com.sagol.dto;
public class pageVO {

	private int pagenum;
    private int pagesize;

	private clubVO clubvo;
	private searchVO searchvo;


	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public clubVO getClubvo() {
		return clubvo;
	}

	public void setClubvo(clubVO clubvo) {
		this.clubvo = clubvo;
	}

    
    public int getPageStart() {
        return (this.pagenum-1)*pagesize;
    }
	
    public searchVO getSearchvo() {
		return searchvo;
	}

	public void setSearchvo(searchVO searchvo) {
		this.searchvo = searchvo;
	}
   
}


