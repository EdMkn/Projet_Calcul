package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Niveau;
import dao.*;

/**
 * Servlet implementation class Calcul
 */
@WebServlet("/Calcul")
public class Calcul extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String diff;
	private Integer nbquest;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calcul() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/calcul_quizz.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.diff = request.getParameter("dif");
		this.nbquest =  Integer.parseInt(request.getParameter("nbquest"));
		DaoFactory daofactory = DaoFactory.getInstance();
		Propositions propositions = new Propositions(daofactory);
		Questions questions = new Questions(daofactory, Niveau.valueOf(diff),this.nbquest);
		
		request.setAttribute("questions", questions.getListquestion(propositions.getListproposition()));
		request.setAttribute("dif", diff);
		request.setAttribute("nbquest", nbquest);
		this.getServletContext().getRequestDispatcher("/WEB-INF/calcul_quizz.jsp").forward(request, response);
	}

}
