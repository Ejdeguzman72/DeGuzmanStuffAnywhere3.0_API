package com.deguzman.DeGuzmanStuffAnywhere.file_upload_controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_models.PhotosFileInfo;
import com.deguzman.DeGuzmanStuffAnywhere.file_upload_service.VideoFilesStorageService;
import com.deguzman.DeGuzmanStuffAnywhere.util.ResponseMessage;
@RestController
@RequestMapping("/app/video-uploads")
@CrossOrigin
public class VideoFilesController {

	@Autowired
	private VideoFilesStorageService videoFilesStorageService;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@PathVariable("file") MultipartFile file) {
		String message = "";
		try {
			System.out.println("This is file" + file);
			videoFilesStorageService.save(file);
			
			message = "Uploaded the file successfully" + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<PhotosFileInfo>> getListFiles() {
		List<PhotosFileInfo> photoFileInfos = (List<PhotosFileInfo>) videoFilesStorageService.loadAllVideos().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(VideoFilesController.class, "getVideoFile",path.getFileName().toString()).build().toString();
			
			return new PhotosFileInfo(filename,url);
		}).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(photoFileInfos);
	}
	
	@GetMapping("/files/{filename}")
	@ResponseBody
	public ResponseEntity<Resource> getVideoFile(@PathVariable String filename) {
		Resource file = (Resource) videoFilesStorageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
}
