package br.com.bieniek.sbootlocalstack.s3.controller.impl;

import br.com.bieniek.sbootlocalstack.s3.controller.S3Controller;
import br.com.bieniek.sbootlocalstack.s3.dto.S3FileDTO;
import br.com.bieniek.sbootlocalstack.s3.service.S3FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Controller
public class S3ControllerImpl implements S3Controller {

    private static final String FILE_NOT_EXISTS = "Arquivo não existe";

    private final S3FileService fileService;

    public ResponseEntity<S3FileDTO> createFile() {
        Path tempFile;
        try {
            tempFile = Files.createTempFile("prefixo-", ".txt");
            Files.writeString(tempFile, "Conteúdo do Arquivo: " + UUID.randomUUID() + "",
                    StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND);

            fileService.saveFile(Files.newInputStream(tempFile), tempFile.toFile().getName());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(S3FileDTO.getInstance(ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(S3FileDTO.getInstance(tempFile.toFile().getName(), null));
    }

    public ResponseEntity<List<S3FileDTO>> listFiles(String fileName) {
        List<S3FileDTO> s3Files = new ArrayList<>();
        try {
            List<Resource> resources = fileService.searchFile(fileName, false);

            if (resources.isEmpty()) {
                s3Files.add(S3FileDTO.getInstance(FILE_NOT_EXISTS, null));
                return new ResponseEntity<>(s3Files, HttpStatus.NOT_FOUND);
            }

            for (Resource resource : resources)
                s3Files.add(S3FileDTO.getInstance(resource.getFilename(), null));
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(s3Files, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(s3Files);
    }

    public ResponseEntity<S3FileDTO> contentFile(String file) {
        if (fileService.isFileExists(file)) {
            List<Resource> resources = fileService.searchFile(file, true);
            Resource resource = resources.get(0);
            return ResponseEntity.ok(S3FileDTO.getInstance(resource.getFilename(), fileService.contentFile(resource.getFilename())));
        } else {
            return new ResponseEntity<>(S3FileDTO.getInstance(FILE_NOT_EXISTS, null), HttpStatus.NOT_FOUND);
        }
    }

}