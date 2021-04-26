package javaframework.demo.service.impl;

import javaframework.demo.converter.ImageConverter;
import javaframework.demo.dto.ImageDTO;
import javaframework.demo.entities.ImageEntity;
import javaframework.demo.repository.ImageRepos;
import javaframework.demo.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService implements IImageService {

    @Autowired
    private ImageRepos imageRepos;

    @Autowired
    private ImageConverter imageConverter;

}
