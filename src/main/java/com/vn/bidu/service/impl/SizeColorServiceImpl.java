package com.vn.bidu.service.impl;

import com.vn.bidu.converter.SizeColorConverter;
import com.vn.bidu.dto.response.SizeColorResponse;
import com.vn.bidu.entity.SizeColor;
import com.vn.bidu.repository.SizeColorRepository;
import com.vn.bidu.service.SizeColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class SizeColorServiceImpl implements SizeColorService {

    private final SizeColorRepository sizeColorRepository;

    @Autowired
    private SizeColorConverter sizeColorConverter;

    @Override
    public List<SizeColorResponse> getAllSizeColor() {

        List<SizeColor> sizeColors = sizeColorRepository.findAll();
        List<SizeColorResponse> sizeColorResponseList = new ArrayList<>();

        for(SizeColor sizeColor : sizeColors){
            SizeColorResponse sizeColorResponse = sizeColorConverter.toSizeColorResponse(sizeColor);
            sizeColorResponseList.add(sizeColorResponse);
        }
        return sizeColorResponseList;
    }

    @Override
    public SizeColorResponse getSizeColorById(int id) {
        SizeColor sizeColor = sizeColorRepository.findById(id).orElseThrow(() -> new RuntimeException("Size Color not found"));
        return sizeColorConverter.toSizeColorResponse(sizeColor);
    }
}
