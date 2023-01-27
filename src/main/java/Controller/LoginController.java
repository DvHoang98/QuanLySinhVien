package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.SinhVien;
import Repository.SinhVienRepository;
import Utils.EncryptUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SinhVienRepository svRepo;

	public LoginController() {
		svRepo = new SinhVienRepository();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		Map<String, String> messages = new HashMap<String, String>();

		SinhVien sv = svRepo.findByEmail(email);
		if (sv != null && EncryptUtil.check(password, sv.getPassword())) {
			request.getSession().setAttribute("user", sv);
			goHomePage(request, response);
			return;
		} else {
			request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
		}
		System.out.println("đã vào pót ");
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void goHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("type", "SinhVien");
		List<SinhVien> ds = this.svRepo.getAll();
		request.setAttribute("ds", ds);
		request.setAttribute("views", "/views/sinhVien/ListSinhVien.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

}
