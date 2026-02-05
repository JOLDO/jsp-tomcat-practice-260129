package com.busanit501.jsp_server_project1._2_260202._0202_todo.Exam;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum MenuService_Exam_2 {
    INSTANCE;

    public List<MenuDto_Exam_2> getList() {
        List<MenuDto_Exam_2> menuList = IntStream.range(0, 10).mapToObj(i -> {
            MenuDto_Exam_2 dto = new MenuDto_Exam_2();
            dto.setTno((long) i);
            dto.setTitle("메뉴 타이틀" + i);
            dto.setDueDate(LocalDate.now());
            dto.setFinished(false);
            return dto;
        }).collect(Collectors.toList());

        return menuList;
    }

    public MenuDto_Exam_2 get(Long tno) {
        MenuDto_Exam_2 dto = new MenuDto_Exam_2();
        dto.setTno(tno);
        dto.setTitle("실습 타이틀");
        dto.setDueDate(LocalDate.now().plusDays(1));
        dto.setFinished(true);
        return dto;
    }
}
