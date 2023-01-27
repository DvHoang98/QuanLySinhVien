package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.mysql.jdbc.Constants;

import Entities.Lop;
import Entities.SinhVienLop;
import Models.LopModel;
import Models.SinhVienLopModel;
import Repository.ChuyenNganhRepository;
import Repository.LopRepository;
import Repository.MonRepository;
import Repository.SinhVienLopRepository;
import Repository.SinhVienRepository;
import Utils.ExcelUtil;

/**
 * Servlet implementation class SinhVienLopController
 */
@WebServlet({ "/SinhVienLop/detail", "/SinhVienLop/store", "/SinhVienLop/delete", "/SinhVienLop/update",
		"/SinhVienLop/import", "/SinhVienLop/export" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class SinhVienLopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LopRepository lopRepo;
	ChuyenNganhRepository cnRepo;
	MonRepository monRepo;
	SinhVienLopRepository svlRepo;
	SinhVienRepository svRepo;
	ExcelUtil excelFile;
	public static final String UPLOAD_DIRECTORY = "upload";
	public static final String DEFAULT_FILENAME = "default.file";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SinhVienLopController() {
		lopRepo = new LopRepository();
		cnRepo = new ChuyenNganhRepository();
		monRepo = new MonRepository();
		svlRepo = new SinhVienLopRepository();
		svRepo = new SinhVienRepository();
		excelFile = new ExcelUtil();
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
		if (url.contains("detail")) {
			detail(request, response);
		} else if (url.contains("store")) {
			store(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("import")) {
			importExcel(request, response);
		} else if (url.contains("export")) {
			exportExcel(request, response);
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
//			store(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("import")) {
			importExcel(request, response);
		} else if (url.contains("export")) {
			exportExcel(request, response);
		} else {
			response.sendRedirect("/Lab4_hoangdvph18776/Lop");
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idStrLop = request.getParameter("idLop");
		String idStrSv = request.getParameter("idSv");
		int idLop = -1;
		int idSv = -1;
		try {
			idLop = Integer.parseInt(idStrLop);
			idSv = Integer.parseInt(idStrSv);
			SinhVienLop svl = svlRepo.findByAttribute(idSv, idLop);
			svlRepo.delete(svl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			response.sendRedirect("/Lab4_hoangdvph18776/SinhVienLop/detail?id="+request.getParameter("idLop"));
		}
		response.sendRedirect("/Lab4_hoangdvph18776/SinhVienLop/detail?id=" + request.getParameter("idLop"));
	}

	public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SinhVienLop svl = new SinhVienLop();
		svl.setLop(lopRepo.findById(Integer.parseInt(request.getParameter("idLop"))));
		svl.setSinhVien(svRepo.findById(Integer.parseInt(request.getParameter("idSv"))));
		try {
			svlRepo.insert(svl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		detail(request, response);
		response.sendRedirect("/Lab4_hoangdvph18776/SinhVienLop/detail?id=" + request.getParameter("idLop"));
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		double diemTb = Double.parseDouble(request.getParameter("diemTb"));
		int id = Integer.parseInt(request.getParameter("idsvl"));
		SinhVienLop svl = svlRepo.findById(id);
		svl.setDiemTb(diemTb);
		try {
			svlRepo.update(svl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Lab4_hoangdvph18776/SinhVienLop/detail?id=" + svl.getLop().getId());
	}

	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//		excelFile.exportExcelFile(lopRepo.getSinhVienInLop(id));
		request.setAttribute("lop", lop);
		request.setAttribute("svInLop", lopRepo.getSinhVienInLop(id));
		request.setAttribute("svOutLop", lopRepo.getSinhVienOutLop(id));
		request.setAttribute("views", "/views/lop/InfoLop.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	public void importExcel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Đã vào importExcel1");
		String idStr = request.getParameter("idLop");
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
		System.out.println("Đã vào importExcel2");
		String uploadPath = getServletContext().getRealPath("") + File.separator + "upload";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();
		String fileName = "";
		try {

			for (Part part : request.getParts()) {
				fileName = getFileName(part);
				part.write(uploadPath + File.separator + fileName);
			}

		} catch (FileNotFoundException fne) {
			System.out.println("loosi part");
			request.setAttribute("message", "There was an error: " + fne.getMessage());
		}

//		String uploadPath = getServletContext().getRealPath("") + File.separator + "upload";
//		File uploadDir = new File(uploadPath);
//		if (!uploadDir.exists()) uploadDir.mkdir();
//
//		String fileName ="";
//		for (Part part : request.getParts()) {
//		    fileName = getFileName(part);
//		    part.write(uploadPath + File.separator + fileName);
//		}
//		System.out.println(request.getParts().toString());
//		return;
		try {
			excelFile.importExcelFile(uploadPath + File.separator + fileName, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Dek vao import");
			e.printStackTrace();
		}
		request.setAttribute("lop", lop);
		request.setAttribute("svInLop", lopRepo.getSinhVienInLop(id));
		request.setAttribute("svOutLop", lopRepo.getSinhVienOutLop(id));
		request.setAttribute("views", "/views/lop/InfoLop.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	public void exportExcel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idLop");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Lab4_hoangdvph18776/Lop");
		}
		Lop lop = lopRepo.findById(id);
		excelFile.exportExcelFile(lopRepo.getSinhVienInLop(id));
		request.setAttribute("lop", lop);
		request.setAttribute("svInLop", lopRepo.getSinhVienInLop(id));
		request.setAttribute("svOutLop", lopRepo.getSinhVienOutLop(id));
		request.setAttribute("views", "/views/lop/InfoLop.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return "default.file";
	}
}
