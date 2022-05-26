package test.wwww;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	
	@Autowired
	private AmazonS3Service amazonS3Service;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    
    @PostMapping("/fileUpload")
    public String fileUpload(@RequestPart List<MultipartFile> files, Model model) {
    	List<String> fileList = amazonS3Service.fileUpload(files);
        for (int i=0;i<fileList.size();i++) {
            System.out.println(fileList.get(i));
        }
    	model.addAttribute("files", fileList);
    	return 	"file";
    }

    @PostMapping("/api/fileDelete")
    @ResponseBody
    public ResponseEntity<BasicResponse> fileDelete(@RequestBody FileDTO file) {
    	String fileName = amazonS3Service.deleteImage(file.getFile());
    	
    	BasicResponse res = new BasicResponse();
    	res.setCode(HttpStatus.OK.value());
    	res.setHttpStatus(HttpStatus.OK);
    	res.setMessage(fileName+"이 삭제되었습니다.");
    	res.setResult(Collections.emptyList());
    	res.setCount(1);
    	
    	
    	return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    

}
