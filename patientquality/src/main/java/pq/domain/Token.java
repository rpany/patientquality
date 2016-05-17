package pq.domain;

import java.util.Date;

public class Token {
	
	private String tokenId;
	private Date insertDate;
	private Date updateDate;
	private int userId;
	
	
	
	public Token(String tokenId, Date insertDate, Date updateDate, int userId) {
		super();
		this.tokenId = tokenId;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
		this.userId = userId;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	

}
