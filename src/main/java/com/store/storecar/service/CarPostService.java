package com.store.storecar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.storecar.dto.CarPostDTO;
import com.store.storecar.dto.ResumeCarDTO;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);

    List<ResumeCarDTO> getCarSales();

    void changeCarSale(CarPostDTO carPostDTO, Long postId);

    void removeCarSale(Long postID);

}
