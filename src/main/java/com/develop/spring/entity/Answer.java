package com.develop.spring.entity;


import javax.persistence.*;

@Entity
@Table(name="ans5991")
public class Answer {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String answername;
    @Column
    private String postedBy;

    @ManyToOne
    @JoinColumn(name = "qid")
    private Question question;


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer() {
    }



    public Answer(String answername, String postedBy) {
        this.answername = answername;
        this.postedBy = postedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswername() {
        return answername;
    }

    public void setAnswername(String answername) {
        this.answername = answername;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }


}
