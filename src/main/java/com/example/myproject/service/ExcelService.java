package com.example.myproject.service;

import com.example.myproject.utils.exception.ExcelException;
import org.springframework.web.multipart.MultipartFile;

/**
 * 处理excel数据
 *
 * @author chenyongxiu
 * @date 2019/07/05 11:46
 */
public interface ExcelService {

    /**
     * 保存excel信息
     *
     * @param excel
     */
    void saveExcelData(MultipartFile excel) throws ExcelException;
}
