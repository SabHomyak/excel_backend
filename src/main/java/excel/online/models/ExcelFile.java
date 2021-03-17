package excel.online.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "excel_files")
public class ExcelFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String excelFileName;
    private String jsonData;
    private Date openedDate;
    @OneToOne
    private User user;

    public ExcelFile(String excelFileName, String jsonData, Date openedDate) {
        this.excelFileName = excelFileName;
        this.jsonData = jsonData;
        this.openedDate = openedDate;
    }
}



