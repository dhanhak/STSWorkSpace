package kh.spring.controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.FilesDTO;
import kh.spring.repositories.FilesDAO;

@Controller
@RequestMapping("/file/")
public class FileController {

	@Autowired
	private HttpSession session;

	@Autowired
	private FilesDAO filesDAO;

	@RequestMapping("upload")
	public String upload(String message, MultipartFile[] files) throws Exception {

		String realPath = session.getServletContext().getRealPath("upload");
		File realPathFile = new File(realPath);
		if (!realPathFile.exists())
			realPathFile.mkdir();

		System.out.println("전송된 메세지 : " + message);
		System.out.println(files);
		System.out.println(files.length);

		if (files != null) {
			for (MultipartFile file : files) {

				if(file.isEmpty()) {break;}
				String oriName = file.getOriginalFilename();
				String sysName = UUID.randomUUID() + "_" + oriName;
				file.transferTo(new File(realPath + "/" + sysName));
				filesDAO.insert(new FilesDTO(0,oriName,sysName,0));
			}
		}
		return "redirect:/";
	}

	@RequestMapping("download")
	public void download(String oriName, String sysName, HttpServletResponse resp) throws Exception {

		String realPath = session.getServletContext().getRealPath("upload");
		File target = new File(realPath+"/"+sysName);
		// 다운 받을 파일을 선택하여 File 객체로 생성

		oriName = new String(oriName.getBytes("utf8"),"ISO-8859-1");
		resp.reset();
		resp.setHeader("content-disposition", "attachment;filename="+oriName);
		// 응답 헤더에 보내려는 데이터가 첨부파일임을 밝히고, 적절히 인코딩 된 파일이름을 지정

		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
				DataOutputStream dos = new DataOutputStream(resp.getOutputStream());) {
			byte[] fileContents = dis.readAllBytes();
			dos.write(fileContents);
			dos.flush();
		}
		// 타겟 파일의 내용을 모두 추출해 response stream 으로 직접 출력
	}


	@RequestMapping(value = "list")
	@ResponseBody
	public List<FilesDTO> list() {
		List<FilesDTO> list = filesDAO.selectAll();
		return list;
	}
}
