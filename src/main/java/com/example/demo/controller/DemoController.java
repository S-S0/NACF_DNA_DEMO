package com.example.demo.controller;

import com.example.demo.domain.DemoSample;
import com.example.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class DemoController {
    private final DemoService demoService;
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // 여기가 메인페이지----------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String home() {
        return "home";
    }
    // 웹 페이지 개발용----------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, path = "/temp")
    public String temp() {
        return "temp";
    }
    // ------------------------------------------------------------------
    // 정상접속 테스트용
    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public String test(Model model) {
        DemoSample sample = demoService.findByEno("19301062");

        // 개별로 붙이는 방법
        model.addAttribute("eno", sample.getEno());
        model.addAttribute("empnm", sample.getEmpnm());
        model.addAttribute("brc", sample.getBrc());
        model.addAttribute("brnm", sample.getBrnm());

        // DTO 통채로 붙이는 방법
        model.addAttribute("sample", sample);
        return "test";
    }
    // ------------------------------------------------------------------
    // 첫페이지
    @RequestMapping(method = RequestMethod.GET, path = "/pg_1")
    public String pg_1(Model model) {

        return "pg_1";
    }
    // ------------------------------------------------------------------
    // 두번째페이지
    @RequestMapping(method = RequestMethod.GET, path = "/pg_2")
    public String pg_2(Model model) {

        return "pg_2";
    }
    // ------------------------------------------------------------------
    // 세번째페이지
    @RequestMapping(method = RequestMethod.GET, path = "/pg_3")
    public String pg_3(Model model) {

        return "pg_3";
    }
}
