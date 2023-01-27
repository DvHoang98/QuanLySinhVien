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
import Models.ChuyenNganhModel;
import Repository.ChuyenNganhRepository;


/**
 * Servlet implementation class ChuyenNganh
 */
@WebServlet({ "/ChuyenNganh", "/ChuyenNganh/index", "/ChuyenNganh/create", "/ChuyenNganh/store" , "/ChuyenNganh/edit", "/ChuyenNganh/update", "/ChuyenNganh/delete"})
public class ChuyenNganhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChuyenNganhRepository cnRepo ;
	
	
	public ChuyenNganhController() {
		cnRepo = new ChuyenNganhRepository();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setAttribute("type", "ChuyenNganh");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("type", "ChuyenNganh");
		String url = request.getRequestURI();
		if (url.contains("store")) {
			store(request, response);
		}else if(url.contains("update")){
			update(request, response);
		}else {
		response.sendRedirect("/Lab4_hoangdvph18776/ChuyenNganh");
		}
	}

	public void create(HttpServletRequest request , HttpServletResponse response )throws ServletException , IOException{
		request.setAttribute("views", "/views/chuyenNganh/AddChuyenNganh.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}
	
	public void edit(HttpServletRequest request , HttpServletResponse response )throws ServletException , IOException{
		String idStr = request.getParameter("id");
		int id = -1;
		
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Lab4_hoangdvph18776/ChuyenNganh");
		}
		ChuyenNganh cn = cnRepo.findById(id);
		if(cn ==null) {
			response.sendRedirect("/Lab4_hoangdvph18776/ChuyenNganh");
		}
		request.setAttribute("cn", cn);
		request.setAttribute("views", "/views/chuyenNganh/EditChuyenNganh.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}
	
	public void delete(HttpServletRequest request , HttpServletResponse response )throws ServletException , IOException{
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
			ChuyenNganh cn = cnRepo.findById(id);
			cnRepo.delete(cn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Lab4_hoangdvph18776/ChuyenNganh");
		}
		response.sendRedirect("/Lab4_hoangdvph18776/ChuyenNganh");
	}
	
	public void index(HttpServletRequest request , HttpServletResponse response )throws ServletException , IOException{
		List<ChuyenNganh> lst = cnRepo.getAll();
		request.setAttribute("lst", lst);	
		request.setAttribute("views", "/views/chuyenNganh/ListChuyenNganh.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}
	
	public void store(HttpServletRequest request , HttpServletResponse response )throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		ChuyenNganhModel model = new ChuyenNganhModel();
		try {
			BeanUtils.populate(model, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ChuyenNganh cn = new ChuyenNganh();
		cn.setTen(model.getTen());
		for (ChuyenNganh x : cnRepo.getAll()) {
			if(x.getTen().equals(model.getTen())) {
				request.setAttribute("error", "Tên chuyên ngành đã bị trùng");
				request.setAttribute("views", "/views/chuyenNganh/AddChuyenNganh.jsp");
				request.getRequestDispatcher("/views/index.jsp").forward(request, response);
				return;
			}
		}
		
		try {
			cnRepo.insert(cn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Lab4_hoangdvph18776/ChuyenNganh");}
	
	public void update(HttpServletRequest request , HttpServletResponse response )throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		ChuyenNganhModel model = new ChuyenNganhModel();
		try {
			BeanUtils.populate(model, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		ChuyenNganh cn = new ChuyenNganh();
		cn.setId(id);
		cn.setTen(model.getTen());
		for (ChuyenNganh x : cnRepo.getAll()) {
			if(x.getTen().equals(model.getTen())&&!cnRepo.findById(id).getTen().equals(model.getTen())) {
				request.setAttribute("error", "Tên chuyên ngành đã bị trùng");
				edit(request, response);
				return;
			}
		}
		try {
			cnRepo.update(cn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Lab4_hoangdvph18776/ChuyenNganh");}
}
