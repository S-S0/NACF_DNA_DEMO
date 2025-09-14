package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.DemoService;
import com.example.demo.service.FinancialRatiosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class DemoController {
    private final DemoService demoService;
    private final FinancialRatiosService service;
    public DemoController(DemoService demoService, FinancialRatiosService service) {
        this.demoService = demoService;
        this.service = service;
    }

    // 여기가 메인페이지---------------------------------------------------- 가져다가 붙여놓고 한번에 최적화 예정
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String home(@RequestParam(name="brc", required=false) String brc, Model model) {

        if(brc == null) {
            brc = "707015";
        } // 사무소코드가 없을 경우 기본 방어로직

        List<FactorScore> fs = demoService.factorByBrc(brc);
        model.addAttribute("factorScores", fs);

        List<StockPrice> sp = demoService.priceByBrc(brc);
        model.addAttribute("stockPrices", sp);

        List<StockOutlook> so = demoService.outlookByBrc(brc);
        model.addAttribute("stockOutlooks", so);

        List<OfficeFinancials> icp = demoService. incomeByBrc(brc);
        model.addAttribute("incomePrices", icp);

        List<OfficeFinancials> pm = demoService. profitByBrc(brc);
        model.addAttribute("profitMargins", pm);

        List<OfficeFinancials> pg = demoService. progrowthByBRC(brc);
        model.addAttribute("profitGrowths", pg);

        List<BrcInfo> db = demoService. descByBRC(brc);
        model.addAttribute("brcInfos", db);


        // 연도 목록
        List<String> years = Arrays.asList("2020","2021","2022","2023","2024");

        if (brc != null && !brc.isEmpty()) {
            Map<String, FinancialRatios> fr = service.getRatiosForYears(brc, years);
            model.addAttribute("fr", fr);
        } else {
            model.addAttribute("fr", Collections.emptyMap());
        }

        model.addAttribute("years", years);
        model.addAttribute("pageTitle", "재무 대시보드");
        model.addAttribute("corp", Map.of("name",(brc != null ? brc : "") + "농협")); // 사무소코드별 이름 정해야함

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
    // 첫페이지 테스트
    @RequestMapping(method = RequestMethod.GET, path = "/pg_1")
    public String pg_1(Model model) {
        List<FactorScore> fs = demoService.factorByBrc("707015");
        model.addAttribute("factorScores", fs);

        List<StockPrice> sp = demoService.priceByBrc("707015");
        model.addAttribute("stockPrices", sp);

        List<StockOutlook> so = demoService.outlookByBrc("707015");
        model.addAttribute("stockOutlooks", so);

        List<OfficeFinancials> icp = demoService. incomeByBrc("707015");
        model.addAttribute("incomePrices", icp);

        List<OfficeFinancials> pm = demoService. profitByBrc("707015");
        model.addAttribute("profitMargins", pm);

        List<OfficeFinancials> pg = demoService. progrowthByBRC("707015");
        model.addAttribute("profitGrowths", pg);

        List<BrcInfo> db = demoService. descByBRC("707015");
        model.addAttribute("brcInfos", db);
        return "pg_1";
    }
    // ------------------------------------------------------------------
    // 두번째페이지 테스트
    @GetMapping("/pg_2")
    public String showPg2(@RequestParam(name="brc", required=false) String brc, Model model) {
        // 연도 목록
        List<String> years = Arrays.asList("2020","2021","2022","2023","2024");

        if (brc != null && !brc.isEmpty()) {
            Map<String, FinancialRatios> fr = service.getRatiosForYears(brc, years);
            model.addAttribute("fr", fr);
        } else {
            model.addAttribute("fr", Collections.emptyMap());
        }

        model.addAttribute("years", years);
        model.addAttribute("pageTitle", "재무 대시보드");
        model.addAttribute("corp", Map.of("name",(brc != null ? brc : "") + "농협")); // 사무소코드별 이름 정해야함

        return "pg_2"; // templates/pg_2.html
    }
    // ------------------------------------------------------------------
    // 세번째페이지 테스트
    @RequestMapping(method = RequestMethod.GET, path = "/pg_3")
    public String pg_3(Model model) {

        return "pg_3";
    }
}
