package excel.online.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ExcelFile> files = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;

    public void addFile(ExcelFile excelFile) {
        files.add(excelFile);
    }

    public ExcelFile getFileById(Integer id) {
        return files.stream()
                .filter(excelFile -> excelFile.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteFileById(Integer id) {
        files.removeIf(excelFile -> excelFile.getId().equals(id));
    }

    public void updateFile(Integer id,ExcelFile excelFile) {
        files = files.stream().map(file -> {
            if (file.getId().equals(id)) {
                return excelFile;
            }
            return file;
        }).collect(Collectors.toList());
    }
}
