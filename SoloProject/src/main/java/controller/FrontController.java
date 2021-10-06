package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.bo")
public class FrontController extends HttpServlet {
	ActionForward actionForward=null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path=request.getServletPath();
		
		if(path.equals("/BoardWrite.bo")) {
			actionForward=new ActionForward();
			actionForward.setPath("./board/boardWrite.jsp");
			
			
		}else if(path.equals("/main.bo")) {
			actionForward=new ActionForward();
			actionForward.setPath("./main.jsp");
		}else {
			actionForward=new ActionForward();
			actionForward.setPath("../SoloProject/main.bo");
			actionForward.setRedirect(true);
		}
		
		if(actionForward!=null) {
			if(actionForward.isRedirect()) {
				response.sendRedirect(actionForward.getPath());
			}else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(actionForward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}










































