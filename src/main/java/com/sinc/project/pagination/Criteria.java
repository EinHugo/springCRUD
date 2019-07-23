package com.sinc.project.pagination;

public class Criteria {

    private int pageNum;

    @Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}



	public int getPageNum() {
		return pageNum;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	private int amount;

    private final static int SIZE = 15;

   

    public Criteria() {

        this(1, SIZE);

    }

    

    public Criteria(int pageNum) {

        this.amount = SIZE;

        this.pageNum = pageNum;

    }

            

    public Criteria(int pageNum, int amount) {

        this.pageNum = pageNum;

        this.amount = amount;

    }

}

