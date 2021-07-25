package com.sagol.dto;
public class pageVO {

	private int pagenum;
    private int pagesize;

	private clubVO clubvo;
	private searchVO searchvo;


	public int getPagenum() {
		if (pagenum < 1) {
			return 1;
		}
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getPagesize() {
		if (pagesize > 100) {
			return 100;
		}
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
    	if (this.pagenum < 1) {
			this.pagenum = 1;
		}
        return (this.pagenum-1)*pagesize;
    }
	
    public searchVO getSearchvo() {
		return searchvo;
	}

	public void setSearchvo(searchVO searchvo) {
		this.searchvo = searchvo;
	}
   
}


