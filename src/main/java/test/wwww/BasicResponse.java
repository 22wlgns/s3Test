package test.wwww;

import java.util.List;

import org.springframework.http.HttpStatus;

public class BasicResponse {
	private Integer code; 
	private HttpStatus httpStatus; 
	private String message; 
	private Integer count; 
	private List<Object> result;
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Object> getResult() {
		return result;
	}
	public void setResult(List<Object> result) {
		this.result = result;
	}
	
	
	@Override
	public String toString() {
		return "BasicResponse [code=" + code + ", httpStatus=" + httpStatus + ", message=" + message + ", count="
				+ count + ", result=" + result + "]";
	}

	public BasicResponse() {
		
	}

}
