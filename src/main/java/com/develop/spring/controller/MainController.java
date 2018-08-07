package com.develop.spring.controller;

import com.develop.spring.entity.Answer;
import com.develop.spring.entity.Question;
import com.develop.spring.model.repository.AnswerRepository;
import com.develop.spring.model.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @Autowired
    private AnswerRepository ansRepo;

    @Autowired
    private QuestionRepository qRepo;

    @RequestMapping("/")
    public ModelAndView doHOme() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("lists", qRepo.findAll());

        mv.addObject("listans", ansRepo.findAll());

        return mv;
    }

    @RequestMapping(value = "/answerpage", method = RequestMethod.GET)
    public ModelAndView goAnswer(@RequestParam("qid") int id) {
        ModelAndView mv = new ModelAndView("answer");
        mv.addObject("go", qRepo.getOne(id));

        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("qid") int qid,@RequestParam("qname") String qname) {
        ModelAndView mv = new ModelAndView("redirect:/");

        Question question = new Question();

        question.setId(qid);
        question.setQname(qname);


        qRepo.save(question);

        return mv;
    }

    @RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
    public ModelAndView saveAnswer(@RequestParam("answerid") int id, @RequestParam("answername") String Answer, @RequestParam("postedby") String PostedBy) {
        ModelAndView mv = new ModelAndView("redirect:/");

        Question quu = qRepo.getOne(id);
        Answer answer = new Answer();
        answer.setQuestion(quu);
        answer.setAnswername(Answer);
        answer.setPostedBy(PostedBy);
        ansRepo.save(answer);
        return mv;
    }


}
