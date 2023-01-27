package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Entities.ChuyenNganh;
import Entities.Lop;
import Models.ChuyenNganhModel;
import Models.LopModel;
import Repository.ChuyenNganhRepository;
import Repository.LopRepository;
import Repository.MonRepository;

/**
 * Servlet implementation class Lop
 */
@WebServlet({ "/Lop", "/Lop/index", "/Lop/create", "/Lop/store", "/Lop/edit", "/Lop/update", "/Lop/delete" })
public class LopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LopRepository lopRepo;
	ChuyenNganhRepository cnRepo;
	MonRepository monRepo;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LopController() {
		lopRepo = new LopRepository();
		cnRepo = new ChuyenNganhRepository();
		monRepo = new MonRepository();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setAttribute("type", "Lop");
		if (url.contains("index")) {
			index(request, response);
		} else if (url.contains("create")) {
			create(request, response);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else {
			index(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setAttribute("type", "Lop");
		if (url.contains("store")) {
			store(request, response);
		}else if(url.contains("update")) {
			update(request, response);
		}else {
			response.sendRedirect("/Lab4_hoangdvph18776/Lop");
		}

	}

	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lop> lst = lopRepo.getAll();
		request.setAttribute("lst", lst);
		request.setAttribute("views", "/views/lop/ListLop.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lstCN", cnRepo.getAll());
		request.setAttribute("lstMon", monRepo.getAll());
		request.setAttribute("views", "/views/lop/AddLop.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LopModel model = new LopModel();
		try {
			BeanUtils.populate(model, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Lop lop = new Lop();
		lop.setKhoa(model.getKhoa());
		lop.setMon(monRepo.findById(model.getMonId()));
		lop.setTen(model.getTen());
		lop.setChuyenNganh(cnRepo.findById(model.getChuyenNganhId()));
		
		for (Lop x : lopRepo.getAll()) {
			if(x.getTen().equals(model.getTen())) {
				request.setAttribute("error", "Tên lớp đã bị trùng");
				create(request, response);
				return;
			}
		}
		
		try {
			lopRepo.insert(lop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Lab4_hoangdvph18776/Lop");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Lab4_hoangdvph18776/Lop");
		}
		Lop lop = lopRepo.findById(id);
		if (lop == null) {
			response.sendRedirect("/Lab4_hoangdvph18776/Lop");
		}
		request.setAttribute("lop", lop);
		request.setAttribute("lstCN", cnRepo.getAll());
		request.setAttribute("lstMon", monRepo.getAll());
		request.setAttribute("views", "/views/lop/EditLop.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LopModel model = new LopModel();
		try {
			BeanUtils.populate(model, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int id = Integer.parseInt(request.getParameter("id"));
		Lop lop = new Lop();
		lop.setId(id);
		lop.setKhoa(model.getKhoa());
		lop.setMon(monRepo.findById(model.getMonId()));
		lop.setTen(model.getTen());
		lop.setChuyenNganh(cnRepo.findById(model.getChuyenNganhId()));

		for (Lop x : lopRepo.getAll()) {
			if(x.getTen().equals(model.getTen())&&!lopRepo.findById(id).getTen().equals(model.getTen())) {
				request.setAttribute("error", "Tên lớp đã bị trùng");
				edit(request, response);
				return;
			}
		}
		
		try {
			lopRepo.update(lop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Lab4_hoangdvph18776/Lop");
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id=Integer.parseInt(idStr);
			Lop lop = lopRepo.findById(id);
			lopRepo.delete(lop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Lab4_hoangdvph18776/Lop");
		}
		response.sendRedirect("/Lab4_hoangdvph18776/Lop");
	}

}
