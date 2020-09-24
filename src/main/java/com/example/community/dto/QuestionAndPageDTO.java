package com.example.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-21 11:46
 */
@Data
public class QuestionAndPageDTO {
    private List<QuestionDTO> questionDTOList;
    private Integer pageSize;
    private Integer pageNum;
    private Integer pageTotal;
    private List<Integer> pageList;


    public QuestionAndPageDTO(int pageNum, int pageSize, int total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageTotal = total / pageSize;
        if(total % pageSize != 0){
            this.pageTotal++;
        }
        if(this.pageNum < 1){
            this.pageNum = 1;
        }
        if(this.pageNum > pageTotal){
            this.pageNum = pageTotal;
        }

        pageList = new ArrayList<>();
        pageList.add(this.pageNum);
        for(int i = 1; i <= 2; i++){
            if(this.pageNum - i > 0){
                pageList.add(0, this.pageNum - i);
            }
            if(this.pageNum+i <= pageTotal){
                pageList.add(this.pageNum + i);
            }
        }
    }
}
