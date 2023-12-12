package claro.flex.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadWrite {

    public GetExcel getExcel() {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/massaDeDados.xlsx";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Substitua pelo índice da planilha que você deseja ler

            int rowNum = 0;

            while (true) {
                sheet.getLastRowNum();
                Row row = sheet.getRow(rowNum);

                if (row != null) {
                    Cell cell1 = row.getCell(0); // Coluna 1 (Usuário)
                    Cell cell2 = row.getCell(1); // Coluna 2 (Senha)
                    Cell cell3 = row.getCell(2); // Coluna 3 (Status)

                    if (cell1 != null && cell2 != null && cell3 != null) {
                        String usuario = cell1.getStringCellValue();
                        String senha = cell2.getStringCellValue();
                        String status = cell3.getStringCellValue();

                        // Verifique se o status é "disponível"
                        if ("disponivel".equalsIgnoreCase(status)) {
                            System.out.println("Usuário: " + usuario);
                            System.out.println("Senha: " + senha);
                            return new GetExcel(usuario, senha);
                        }
                    }
                }
                rowNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
