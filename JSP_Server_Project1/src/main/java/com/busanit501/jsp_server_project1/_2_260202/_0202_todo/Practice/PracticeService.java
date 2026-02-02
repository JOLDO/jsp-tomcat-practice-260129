package com.busanit501.jsp_server_project1._2_260202._0202_todo.Practice;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum PracticeService {
    PRACTICE;

    public List<PracticeDTO> getList() {
        List<PracticeDTO> dtoList = IntStream.range(0, 5).mapToObj(i -> {
            PracticeDTO dto = new PracticeDTO();
            dto.setTitle("연습용 " + i);
            dto.setCount(i);
            dto.setDueDate(LocalDate.now().plusDays(i));
            if(i % 2 == 0) {
                dto.setIsFinish(true);
            } else {
                dto.setIsFinish(false);
            }
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    public PracticeDTO get(int count) {
        PracticeDTO dto = null;
        for(PracticeDTO practiceDTO : getList()) {
            if(practiceDTO.getCount() == count) {
                dto = practiceDTO;
                break;
            }
        }
        return dto;
    }
}
