package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyVO {
	private int bno;
	private int rno;
	private String reply;
	private String replyer;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", timezone="Asia/Seoul")
	private Date replyDate;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", timezone="Asia/Seoul")
	private Date updateDate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [bno=" + bno + ", rno=" + rno + ", reply=" + reply + ", replyer=" + replyer + ", replyDate="
				+ replyDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
