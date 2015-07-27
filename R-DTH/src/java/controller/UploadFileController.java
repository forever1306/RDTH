/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadFileController {
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String upload(@RequestParam(value = "file") MultipartFile mfile,HttpServletResponse res,HttpServletRequest req){
        long time=Calendar.getInstance().getTimeInMillis();
        String fileName="";
        try{
            fileName=time+mfile.getOriginalFilename();
            File f=new File(req.getServletContext().getRealPath("/images")+"/"+fileName);
            if(!f.exists()){
                f.createNewFile();
            }
            FileOutputStream out=new FileOutputStream(f);
            FileCopyUtils.copy(mfile.getBytes(),out );
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "<img src='"+req.getContextPath()+"/images/"+fileName+"'/>";
        
    }
}
