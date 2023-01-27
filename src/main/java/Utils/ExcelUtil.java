package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Entities.SinhVien;
import Entities.SinhVienLop;
import Repository.LopRepository;
import Repository.SinhVienLopRepository;
import Repository.SinhVienRepository;

public class ExcelUtil {

	SinhVienRepository svRepo;
	LopRepository lopRepo;
	SinhVienLopRepository svlRepo;
	
	public ExcelUtil() {
		svRepo = new SinhVienRepository();
		lopRepo = new LopRepository();
		svlRepo = new SinhVienLopRepository();
	}

	private XSSFCellStyle createStyle(XSSFWorkbook workbook) {
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public void exportExcelFile(List<SinhVienLop> lst) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("List Sinh Viên Trong Lớp");

		int rownum = 0;
		Cell cell;
		Row row;
		XSSFCellStyle style = createStyle(workbook);
		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("ID");
		cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Họ tên");
		cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Địa chỉ");
		cell.setCellStyle(style);

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Email");
		cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Giới tính");
		cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("SĐT");
		cell.setCellStyle(style);

		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Chuyên Ngành");
		cell.setCellStyle(style);

		cell = row.createCell(7, CellType.STRING);
		cell.setCellValue("Điểm Trung Bình");
		cell.setCellStyle(style);

		for (SinhVienLop svl : lst) {
			rownum++;
			row = sheet.createRow(rownum);

			cell = row.createCell(0, CellType.NUMERIC);
			cell.setCellValue(svl.getSinhVien().getId());

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(svl.getSinhVien().getHoTen());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(svl.getSinhVien().getDiaChi());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(svl.getSinhVien().getEmail());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(svl.getSinhVien().getGioiTinh() == 1 ? "Nam" : "Nữ");

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(svl.getSinhVien().getSdt());

			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(svl.getSinhVien().getChuyenNganh().getTen());

			cell = row.createCell(7, CellType.NUMERIC);
			cell.setCellValue(svl.getDiemTb());
		}
		
		File file = new File("C:\\Users\\lucif\\Desktop\\New Microsoft Excel Worksheet.xlsx");
		file.getParentFile().mkdirs();

		try {
			FileOutputStream outFile = new FileOutputStream(file);
			workbook.write(outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void importExcelFile(String url,int idLop) throws Exception {

		List<SinhVienLop> svl = new ArrayList<>();
		List<SinhVienLop> lstSV = lopRepo.getSinhVienInLop(idLop);
		System.out.println(url);
		FileInputStream inputStream = new FileInputStream(
				new File(url));
		int countRow = 0;
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {
			if (countRow == 0) {
				countRow++;
				Row row = rowIterator.next();
			} else {
				Row row = rowIterator.next();
				SinhVienLop a = new SinhVienLop();
				a.setSinhVien(svRepo.findById((int)row.getCell(0).getNumericCellValue()));
				a.setLop(lopRepo.findById(idLop));
				a.setDiemTb(Double.parseDouble(row.getCell(7).toString()));
				for (SinhVienLop x : lstSV) {
					if(a.getSinhVien().getId()==x.getSinhVien().getId()) {
						x.setDiemTb(a.getDiemTb());
						svlRepo.update(x);
					}
				}
//				svl.add(a);
			}
//			for (SinhVienLop a : svl) {
//				
//			}

		}
	}

}
