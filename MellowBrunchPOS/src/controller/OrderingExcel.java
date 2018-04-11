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

import model.OrderingVO;

public class OrderingExcel {

	public boolean xlsxWiter(List<OrderingVO> list, String saveDir) {
		// ��ũ�� ����
		XSSFWorkbook workbook = new XSSFWorkbook();
		// ��ũ��Ʈ ����
		XSSFSheet sheet = workbook.createSheet();
		// �� ����
		XSSFRow row = sheet.createRow(0);
		// �� ����
		XSSFCell cell;
		// ��� ���� ����
		cell = row.createCell(0);
		cell.setCellValue("�ֹ� ��ȣ");

		cell = row.createCell(1);
		cell.setCellValue("��ǰ ��ȣ");

		cell = row.createCell(2);
		cell.setCellValue("��ǰ��");

		cell = row.createCell(3);
		cell.setCellValue("��ǰ ����");

		cell = row.createCell(4);
		cell.setCellValue("��ǰ ����");
		
		// ����Ʈ�� size ��ŭ row�� ����
		OrderingVO vo;
		for (int rowIdx = 0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);

			// �� ����
			row = sheet.createRow(rowIdx + 1);

			cell = row.createCell(0);
			cell.setCellValue(vo.getOrderno());

			cell = row.createCell(1);
			cell.setCellValue(vo.getProductno());

			cell = row.createCell(2);
			cell.setCellValue(vo.getProductprice());
			
			cell = row.createCell(3);
			cell.setCellValue(vo.getProductname());

			cell = row.createCell(4);
			cell.setCellValue(vo.getProductamount());
		}
		// �Էµ� ���� ���Ϸ� ����
		String strReportPDFName = "order_" + System.currentTimeMillis() + ".xlsx";
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