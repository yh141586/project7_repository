package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

/*
 * XXXAction 클래스의 작업을 수행할 메서드 형식을 강제(통일)하기 위해 
 * 부모에 해당하는 Action 인터페이스를 정의하고
 * XXXAtion 클래스에서 상속받아 구현할 메서드를 추상메서드 형태로 제공
 * -> 메서드명 : excute
 * -> 파라미터 : HttpServletRequest ,HttpServletResponse
 * -> 리턴타입 : ActionForward
 */
public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception;
}
