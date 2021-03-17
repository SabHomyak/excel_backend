package excel.online.controllers;

import excel.online.models.ExcelFile;
import excel.online.models.User;
import excel.online.services.ExcelFileService;
import excel.online.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/excel")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExcelController {
    private ExcelFileService service;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setService(ExcelFileService service) {
        this.service = service;
    }

    @GetMapping("/files")
    public List<ExcelFile> getAll(Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        return byUsername.getFiles();
    }

    @GetMapping("files/{id}")
    public ExcelFile getFile(@PathVariable Integer id, Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        return byUsername.getFileById(id);
    }


    @PutMapping("files/create/{filename}")
    public ResponseEntity<HttpStatus> createFile(@PathVariable String filename, Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        byUsername.addFile(new ExcelFile(filename, null, new Date()));
        userService.save(byUsername);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("files/update/{id}")
    public ResponseEntity<HttpStatus> updateFile(@PathVariable Integer id, @RequestBody ExcelFile file, Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        byUsername.updateFile(id,file);
        userService.save(byUsername);
//        Integer result = service.updateExcelFileById(id, file.getExcelFileName(), file.getJsonData(), file.getOpenedDate());
//        System.out.println(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("files/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable Integer id, Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        byUsername.deleteFileById(id);
        userService.save(byUsername);
        return ResponseEntity.ok().build();
    }

}
