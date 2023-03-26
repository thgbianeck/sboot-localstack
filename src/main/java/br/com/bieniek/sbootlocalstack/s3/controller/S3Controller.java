package br.com.bieniek.sbootlocalstack.s3.controller;

import br.com.bieniek.sbootlocalstack.s3.dto.S3FileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
public interface S3Controller {

    @PostMapping("/s3/files")
    ResponseEntity<S3FileDTO> createFile();

    @GetMapping("/s3/files")
    ResponseEntity<List<S3FileDTO>> listFiles(@RequestParam("fileName") String fileName);

    @GetMapping("/s3/files/{file}")
    ResponseEntity<S3FileDTO> contentFile(@PathVariable("file") String file);

}