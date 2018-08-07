package com.develop.spring.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="q5991")
public class Question {

    @Id
    private int id;
    private String qname;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question() {
    }

    public Question(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(String qname) {
        this.qname = qname;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    public  void add(Answer tempAnswer) {
        if (answers==null)
        {
            answers=new ArrayList<>();
        }
        answers.add(tempAnswer);
        tempAnswer.setQuestion(this);

    }
}
