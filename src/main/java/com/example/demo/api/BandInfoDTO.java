package com.example.demo.api;

import lombok.Data;

import java.util.List;


@Data
public class BandInfoDTO {
    private int result_code;
    private ResultData result_data;


    @Data
    public static class ResultData {
        private List<Band> bands;

        public List<Band> getBands() {
            return bands;
        }
    }

    @Data
    public static class Band {
        private String name;
        private String cover; //이미지사진 대표
        private int member_count; //인원
        private String band_key;

    }
}