package com.woori.yourhome.gallery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.woori.yourhome.common.FileUploadUtil;

@Controller
public class GalleryController {
	
	@Resource(name="galleryService")
	GalleryService galleryService;
	
	
	@RequestMapping("/gallery/list")
	String gallery_list(Model model, GalleryDto dto)
	{
		
		dto.setPageSize(12);
		dto.setStart( dto.getPg() * dto.getPageSize());
		
		List<GalleryDto> list = galleryService.getList(dto);
		int cnt = galleryService.getTotal(dto);
		
		model.addAttribute("galleryList", list);
		model.addAttribute("totalCnt", cnt);
		
		return "gallery/gallery_list";
	}
	
	@RequestMapping("/gallery/write")
	String gallery_write(Model model)
	{
		
		GalleryDto dto = new GalleryDto();
		model.addAttribute("galleryDto", dto);
		
		return "gallery/gallery_write";
	}	
	
	
	@RequestMapping("/gallery/save")
	String gallery_save( GalleryDto dto, HttpServletRequest req, MultipartHttpServletRequest multi )
	{
		
		//파일처리 -- 파일을 업로드할떄는 반드시 물리적인 주소가 필요하다. d:/project/upload 식으로 
		//물리적 경로가 없으면 파일을 업로드 할 수 없다. 
		
//		MultipartFile file = multi.getFile("image");  //클라이언트에서 보낸 파일에 대한 정보를 확인한다 
//		
//		//multi.getFile("file태그의 이름") 형태를 주면 MultipartFile  형태의 객체를 반환한다 
//		String path = "C:\\backend\\spring_workspace\\SpringDI_DB2\\upload";
//		//이 경로가 존재하는지 확인하기 
//		File dir = new File(path);  //java.io.file
//		if( !dir.exists() )//경로가 없으면 경로를 생성한다 
//			dir.mkdirs(); 
//		
//		//파일은 이미 서버의 임시메모리에 업로드 된 상태에서 전달된다. 
//		//파일을 지정된 디렉토리로 옮겨야만 존재한다 
//		try {
//			file.transferTo( new File(path +"/a.jpg"));
//			
//		} catch (IllegalStateException e) {
//			
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		
		
		List<MultipartFile> multiList = new ArrayList<MultipartFile>();
		multiList.add(multi.getFile("upload"));
		
		List<String> fileNameList=new ArrayList<String>();
		
		String path = req.getServletContext().getRealPath("/");
		System.out.println("물리적위치값 : " + path);
		FileUploadUtil.upload( path,  multiList, fileNameList); 
		
		dto.setImage(fileNameList.get(0)); //이미지 파일명은 따로 추가
		
		galleryService.insert(dto);
		
		return "redirect:/gallery/list";
	}
//	
	@RequestMapping("/gallery/view")
	String gallery_view(GalleryDto dto, Model model)
	{
		GalleryDto resultDto = galleryService.getView(dto);
		model.addAttribute("galleryDto", resultDto);
		
		return "gallery/gallery_view";
	}
	
	@RequestMapping("/gallery/delete")
	@ResponseBody
	HashMap<String, String> gallery_delete(GalleryDto dto, Model model)
	{
		galleryService.delete(dto);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
}




