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

import Entities.Lop;
import Entities.Mon;
import Models.MonModel;
import Repository.MonRepository;

/**
 * Servlet implementation class Mon
 */
@WebServlet({"/Mon","/Mon/index","/Mon/create","/Mon/store","/Mon/edit","/Mon/update","/Mon/delete"})
public class MonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	MonRepository monRepo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonController() {
        monRepo = new MonRepository();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setAttribute("type", "Mon");
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
		request.setAttribute("type", "Mon");
		if (url.contains("store")) {
			store(request, response);
		}else if(url.contains("update")) {
			update(request, response);
		}else {
			response.sendRedirect("/Lab4_hoangdvph18776/Mon");
		}

	}

	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Mon> lst = monRepo.getAll();
		request.setAttribute("lstMon", lst);
		request.setAttribute("views", "/views/mon/ListMon.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("views", "/views/mon/AddMon.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MonModel model = new MonModel();
		try {
			BeanUtils.populate(model, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mon mon = new Mon();
		mon.setHocKy(model.getHocKy());
		mon.setSoTinChi(model.getSoTinChi());
		mon.setTen(model.getTen());
		
		for (Mon x : monRepo.getAll()) {
			if(x.getTen().equals(model.getTen())) {
				request.setAttribute("error", "Tên môn đã bị trùng");
				create(request, response);
				return;
			}
		}
		
		try {
			monRepo.insert(mon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Lab4_hoangdvph18776/Mon");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Lab4_hoangdvph18776/Mon");
		}
		Mon mon = monRepo.findById(id);
		if (mon == null) {
			response.sendRedirect("/Lab4_hoangdvph18776/Mon");
		}
		request.setAttribute("mon", mon);
		request.setAttribute("views", "/views/mon/EditMon.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MonModel model = new MonModel();
		try {
			BeanUtils.populate(model, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int id = Integer.parseInt(request.getParameter("id"));
		Mon mon = new Mon();
		mon.setId(id);
		mon.setHocKy(model.getHocKy());
		mon.setSoTinChi(model.getSoTinChi());
		mon.setTen(model.getTen());

		for (Mon x : monRepo.getAll()) {
			if(x.getTen().equals(model.getTen())&&!monRepo.findById(id).getTen().equals(model.getTen())) {
				request.setAttribute("error", "Tên môn đã bị trùng");
				edit(request, response);
				return;
			}
		}
		
		try {
			monRepo.update(mon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Lab4_hoangdvph18776/Mon");
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id=Integer.parseInt(idStr);
			Mon Mon = monRepo.findById(id);
			monRepo.delete(Mon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Lab4_hoangdvph18776/Mon");
		}
		response.sendRedirect("/Lab4_hoangdvph18776/Mon");
	}

}
