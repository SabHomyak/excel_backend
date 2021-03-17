package excel.online.repositories;

import excel.online.models.ExcelFile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface ExcelFileRepository extends CrudRepository<ExcelFile, Integer> {
    ExcelFile findExcelFileById(Integer id);

    @Transactional
    @Modifying
    @Query("update excel_files e set e.excelFileName= :filename, e.jsonData =:json, e.openedDate =:date where e.id =:id")
    Integer updateExcelFileById(
            @Param("id") Integer id,
            @Param("filename") String excelFileName,
            @Param("json") String dataJson,
            @Param("date") Date dateOpened);
}
