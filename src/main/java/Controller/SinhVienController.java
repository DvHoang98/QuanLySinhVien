package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Entities.Mon;
import Entities.SinhVien;
import Models.SinhVienModel;
import Repository.ChuyenNganhRepository;
import Repository.SinhVienRepository;
import Utils.EncryptUtil;
import Utils.JpaUtil;

/**
 * Servlet implementation class SinhVien
 */
@WebServlet({"/SinhVien","/SinhVien/index","/SinhVien/create","/SinhVien/store","/SinhVien/edit","/SinhVien/update","/SinhVien/delete"})
public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SinhVienRepository svRepo;
       private ChuyenNganhRepository cnRepo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinhVienController() {
        super();
		svRepo = new SinhVienRepository();
		cnRepo = new ChuyenNganhRepository();
		
		
		
		// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setAttribute("type", "SinhVien");
		if(url.contains("index")) {
			index(request, response);
		}else if(url.contains("create")) {
			create(request, response);
		}else if(url.contains("edit")) {
			edit(request, response);
		}else if(url.contains("delete")) {
			delete(request, response);
		}else {
			index(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setAttribute("type", "SinhVien");
		if(url.contains("store")) {
			store(request,response);
			request.setAttribute("views", "/views/sinhVien/ListSinhVien.jsp");
		}else if(url.contains("update")){
			update(request,response);
			request.setAttribute("views", "/views/sinhVien/ListSinhVien.jsp");
		}
		else {
			response.sendRedirect("/Lab4_hoangdvph18776/SinhVien");
		}
	}
	//// Custome Method
	public void create(
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
		request.setAttribute("lstCN", cnRepo.getAll());
		request.setAttribute("views", "/views/sinhVien/AddSinhVien.jsp");
			request.getRequestDispatcher("/views/index.jsp")
				.forward(request, response);
			
		}
		
		public void edit(
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
			String idStr = request.getParameter("id");
			int id = -1;
			// id BẮT BUỘC phải truyền
			// id phải là số
			try {
				id = Integer.parseInt(idStr);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("/Lab4_hoangdvph18776/SinhVien");
			}

			SinhVien sv = this.svRepo.findById(id);
			if (sv == null) {
				response.sendRedirect("/Lab4_hoangdvph18776/SinhVien");
			}

			request.setAttribute("sv", sv);
			request.setAttribute("lstCN", cnRepo.getAll());
			request.setAttribute("views", "/views/sinhVien/EditSinhVien.jsp");
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
		}
		
		public void delete(
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
			String idStr = request.getParameter("id");
			int id = -1;
			// id BẮT BUỘC phải truyền
			// id phải là số
			try {
				id = Integer.parseInt(idStr);
				 SinhVien sv = this.svRepo.findById(id);
				this.svRepo.delete(sv);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("/Lab4_hoangdvph18776/SinhVien");
			}
			response.sendRedirect("/Lab4_hoangdvph18776/SinhVien");
		}
		
		public void index(
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
			List<SinhVien> ds = this.svRepo.getAll();
			request.setAttribute("ds", ds);
			request.setAttribute("views", "/views/sinhVien/ListSinhVien.jsp");
			request.getRequestDispatcher("/views/index.jsp")
			.forward(request, response);
		}
		
		public void store(
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			SinhVienModel model = new SinhVienModel();
			try {
				BeanUtils.populate(model, request.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			SinhVien sv = new SinhVien();
			sv.setAvatar(null);
			sv.setPassword(EncryptUtil.encrypt(model.getPassword()));
			sv.setHoTen( model.getHoTen() );
			sv.setEmail( model.getEmail() );
			sv.setSdt( model.getSdt() );
			sv.setDiaChi( model.getDiaChi() );
			sv.setChuyenNganh(cnRepo.findById(model.getChuyenNganhId()));
			
			sv.setGioiTinh( model.getGioiTinh() );
			
			for (SinhVien x : svRepo.getAll()) {
				if(x.getEmail().equals(model.getEmail())) {
					request.setAttribute("error", "Email đã bị trùng");
					create(request, response);
					return;
				}
			}
			
			try {
				this.svRepo.insert(sv);
			} catch (Exception e) {
				// Báo lỗi
				
				e.printStackTrace();
			}
			response.sendRedirect("/Lab4_hoangdvph18776/SinhVien");
		}
		
		private void update(
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			SinhVienModel model = new SinhVienModel();
			try {
				BeanUtils.populate(model, request.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int id = Integer.parseInt(request.getParameter("id"));
			SinhVien sv = new SinhVien();
			sv.setAvatar(null);
			sv.setId( id );
			sv.setPassword(EncryptUtil.encrypt(model.getPassword()));
			sv.setHoTen( model.getHoTen() );
			sv.setEmail( model.getEmail() );
			sv.setSdt( model.getSdt() );
			sv.setDiaChi( model.getDiaChi() );
			sv.setChuyenNganh(cnRepo.findById(model.getChuyenNganhId()));;
			sv.setGioiTinh( model.getGioiTinh() );
			
			for (SinhVien x : svRepo.getAll()) {
				if(x.getEmail().equals(model.getEmail())&&!svRepo.findById(id).getEmail().equals(model.getEmail())) {
					request.setAttribute("error", "Email đã bị trùng");
					edit(request, response);
					return;
				}
			}
			try {
				this.svRepo.update(sv);
			} catch (Exception e) {
				// Báo lỗi
				e.printStackTrace();
			}
			response.sendRedirect("/Lab4_hoangdvph18776/SinhVien");
		}

}
