package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FilesMapper;
import org.springframework.stereotype.Service;

@Service
public class FilesService {
    private FilesMapper filesMapper;

    public FilesService(FilesMapper filemapper) {
        this.filesMapper = filesMapper;
    }

    public String getFiles(int userid) {
        return null;
    }

}
