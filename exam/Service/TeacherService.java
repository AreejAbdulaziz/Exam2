package com.example.exam.Service;

import com.example.exam.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher>teachers=new ArrayList<>();
    public ArrayList<Teacher>getTeachers(){
        return teachers;
    }
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public boolean updateTeacher(String id,Teacher teacher){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }
        } return false;
    }
    public boolean deleteTeacher(String id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }
        } return false;
    }
    public Teacher searchTeacher(String id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId().equals(id)){
                return teachers.get(i);
            }
        } return null;
    }
}
