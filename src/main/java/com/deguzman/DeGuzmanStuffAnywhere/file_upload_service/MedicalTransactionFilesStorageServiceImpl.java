package com.deguzman.DeGuzmanStuffAnywhere.file_upload_service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.deguzman.DeGuzmanStuffAnywhere.util.LoggerMessage;

@Service
public class MedicalTransactionFilesStorageServiceImpl implements MedicalTransactionFilesStorageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalTransactionFilesStorageServiceImpl.class);

	private final Path root = Paths.get("medical-file-uploads");

	@Override
	public void init() {
		try {
			Files.createDirectory(root);
			LOGGER.info(LoggerMessage.CREATE_MEDICAL_TRANSACTION_UPLOADS_INFO_MESSAGE + ": " + root);
		} catch (IOException e) {
			LOGGER.warn(LoggerMessage.CREATE_MEDICAL_TRANSACTION_UPLOADS_ERROR_MESSAGE + ": " + root);
			throw new RuntimeException("Could not initialize folder for upload");
		}
	}

	@Override
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			LOGGER.info(LoggerMessage.SAVE_MEDICAL_TRANSACTION_FILE_INFO_MESSAGE + ": " + file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.warn(LoggerMessage.SAVE_MEDICAL_TRANSACTION_FILE_ERROR_MESSAGE + ": " + file.getOriginalFilename());
		}
	}

	@Override
	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				LOGGER.info(LoggerMessage.GET_MEDICAL_TRANSACTION_FILE_INFO_MESSAGE + file.getFileName());
				return resource;
			} else {
				LOGGER.warn(LoggerMessage.GET_MEDICAL_TRANSACTION_FILE_INFO_MESSAGE + file.getFileName());
				throw new RuntimeException("Could not read the file");
			}
		} catch (MalformedURLException e) {
			LOGGER.warn(LoggerMessage.GET_MEDICAL_TRANSACTION_FILE_INFO_MESSAGE);
			throw new RuntimeException("Error" + e.getMessage());
		}
	}

	@Override
	public void deleteAllMedicalFiles() {
		FileSystemUtils.deleteRecursively(root.toFile());

	}

	@Override
	public Stream<Path> laodAllMedicalFiles() {
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files");
		}
	}

}
