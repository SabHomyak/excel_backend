package excel.online.services;

import excel.online.models.ExcelFile;
import excel.online.repositories.ExcelFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExcelFileService {
    private ExcelFileRepository excelFileRepository;

    @Autowired
    public void setExcelFileRepository(ExcelFileRepository excelFileRepository) {
        this.excelFileRepository = excelFileRepository;
    }

    public void saveFile(ExcelFile file) {
        excelFileRepository.save(file);
    }

    public List<ExcelFile> getAll() {
        List<ExcelFile> excelFiles = new ArrayList<>();
        excelFileRepository.findAll().forEach(excelFiles::add);
        return excelFiles;
    }

    public ExcelFile getFileById(Integer id) {
        return excelFileRepository.findById(id).orElse(null);
    }

    public void deleteFileById(Integer id) {
        excelFileRepository.deleteById(id);
    }

    public Integer updateExcelFileById(Integer id, String filename, String dataJson, Date dataOpened) {
        return excelFileRepository.updateExcelFileById(id, filename, dataJson, dataOpened);
    }
}
