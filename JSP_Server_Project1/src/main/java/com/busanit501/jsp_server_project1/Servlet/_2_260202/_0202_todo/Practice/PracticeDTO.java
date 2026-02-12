package com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo.Practice;

import java.time.LocalDate;

public class PracticeDTO {
    private String title;
    private int count;
    private LocalDate dueDate;
    private boolean isFinish;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public boolean getIsFinish() { return isFinish; }
    public void setIsFinish(boolean isFinish) { this.isFinish = isFinish; }

    @Override
    public String toString() {
        return "PracticeDTO{" +
                "title='" + title + '\'' +
                ", count=" + count +
                ", dueDate=" + dueDate +
                ", isFinish=" + isFinish +
                '}';
    }
}
