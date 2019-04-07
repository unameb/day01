package com.iss.buses.po;

import java.util.Collection;

public class Message {
       private boolean flag;
       private String msg;
       private Collection<Object> list;
	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the list
	 */
	public Collection<Object> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(Collection<Object> list) {
		this.list = list;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
       
}
