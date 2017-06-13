package org.phoenixgriffon.JobIsep;
import java.util.Date;
import java.time.*;

public class Message implements java.io.Serializable{
	
	private Integer id;
	private Integer idExpe;
	private Integer idRecv;
	private String objMsg;
	private String msg;
	private Date datemsg;
	private Date timemsg;

	public Message() {
	}

	public Message(Integer id ,Integer idExpe , Integer idRecv, String objMsg, String msg, Date datemsg, Date timemsg) {
		this.id = id;
		this.idExpe = idExpe;
		this.idRecv = idRecv;
		this.objMsg = objMsg;
		this.msg = msg;
		this.datemsg =datemsg;
		this.timemsg = timemsg;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.idExpe = id;
	}
	
	public Integer getIdExpe() {
		return this.idExpe;
	}

	public void setIdExpe(Integer idExpe) {
		this.idExpe = idExpe;
	}
	
	public Integer getIdRecv() {
		return this.idRecv;
	}

	public void setIdRecv(Integer idRecv) {
		this.idRecv= idRecv;
	}

	public String getMessage() {
		return this.msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}
	
	public String getObj() {
		return this.objMsg;
	}

	public void setObj(String objMsg) {
		this.objMsg = objMsg;
	}

	public Date getDate() {
		return this.datemsg;
	}

	public void setDate(Date datemsg) {
		this.datemsg = datemsg;
	}
	
	public Date getTime() {
		return this.timemsg;
	}

	public void setTime(Date timemsg) {
		this.timemsg = timemsg;
	}

}
