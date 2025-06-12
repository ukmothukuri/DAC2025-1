package com.example;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;  

public class StudentDAO {
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveStudent(Student student){
        String SQL = "insert into student_details (student_name, email) values (?, ?)";
        jdbcTemplate.update( SQL, student.getName(), student.getEmail());
        System.out.println("Created Record Name = " + student.getName() + " email = " + student.getEmail());
       

        SQL = "select * from student_details";
        List<Student> lis = jdbcTemplate.query(SQL, new StudentMapper());
        System.out.println("==="+lis.get(3).getName());
        return;
    }
    
}
