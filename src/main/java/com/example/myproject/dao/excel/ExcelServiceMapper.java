package com.example.myproject.dao.excel;


import com.example.myproject.entity.DataDictionaryPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExcelServiceMapper {


    void deleteDataDictionary();

    void saveExcelData(List<DataDictionaryPO> list);


}
