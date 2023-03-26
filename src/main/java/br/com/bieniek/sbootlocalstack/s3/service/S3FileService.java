package br.com.bieniek.sbootlocalstack.s3.service;

import br.com.bieniek.sbootlocalstack.s3.exception.FileListenerException;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.List;

public interface S3FileService {

    void setupResolver(ApplicationContext applicationContext, AmazonS3 amazonS3);

    boolean isFileExists(String file);

    List<Resource> searchFile(String name, boolean exact);

    void saveFile(InputStream from, String to) throws FileListenerException;

    String contentFile(String file);

}
