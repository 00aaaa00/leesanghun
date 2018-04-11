package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.ProductVO;

public class ProductExcel {

	public boolean xlsxWiter(List<ProductVO> list, String saveDir) {
		// 况农合 积己
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 况农矫飘 积己
		XSSFSheet sheet = workbook.createSheet();
		// 青 积己
		XSSFRow row = sheet.createRow(0);
		// 伎 积己
		XSSFCell cell;
		// 庆歹 沥焊 备己

		cell = row.createCell(0);
		cell.setCellValue("惑前 锅龋");

		cell = row.createCell(1);
		cell.setCellValue("惑前疙");

		cell = row.createCell(2);
		cell.setCellValue("惑前 啊拜");
		
		cell = row.createCell(3);
		cell.setCellValue("荤柳 林家");

		// 府胶飘狼 size 父怒 row甫 积己
		ProductVO vo;
		for (int rowIdx = 0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);

			// 青 积己
			row = sheet.createRow(rowIdx + 1);

			cell = row.createCell(0);
			cell.setCellValue(vo.getProductno());

			cell = row.createCell(1);
			cell.setCellValue(vo.getProductname());

			cell = row.createCell(2);
			cell.setCellValue(vo.getProductprice());

			cell = row.createCell(3);
			cell.setCellValue(vo.getProductpicpath());
		}
		// 涝仿等 郴侩 颇老肺 静扁
		String strReportPDFName = "product_" + System.currentTimeMillis() + ".xlsx";
		File file = new File(saveDir + "\\" + strReportPDFName);
		FileOutputStream fos = null;
		boolean saveSuccess;
		saveSuccess = false;
		try {
			fos = new FileOutputStream(file);
			if (fos != null) {
				workbook.write(fos);
				saveSuccess=true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return saveSuccess;
	}
}
