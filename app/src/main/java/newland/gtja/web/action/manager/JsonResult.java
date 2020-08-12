package newland.gtja.web.action.manager;

import java.util.ArrayList;
import java.util.List;

public class JsonResult<T>{

	private int code;
	
	private String message;
	
	private List<T> data;
	
	public JsonResult() {
	}
	
	public JsonResult(int code, String message) {
		this(code,message, new ArrayList<T>());
	}
	
	public JsonResult(int code, String message, List<T> data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public JsonResult<T> code(int code){
		this.code = code;
		return this;
	}
	
	public JsonResult<T> message(String message){
		this.message = message;
		return this;
	}
	
	public JsonResult<T> data(List<T> data){
		this.data = data;
		return this;
	}
	
	public JsonResult<T> success(){
		this.code = 0;
		this.message = "success";
		return this;
	}
	
	public JsonResult<T> success(List<T> data){
		this.data = data;
		return success();
	}
	
	public JsonResult<T> success(List<T> data, String message){
		this.data = data;
		return success();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
}
