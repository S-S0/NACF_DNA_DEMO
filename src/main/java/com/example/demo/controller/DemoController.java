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
        } // 사무소코드가 없을 경우 기본 방어로직 - 안동농협?

        // 첫번째 탭 모델 ------------------------------------------------------------------
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

        // 두번째 탭 모델 ------------------------------------------------------------------
        // 연도 목록
        List<String> years = Arrays.asList("2020","2021","2022","2023","2024");

        if (!brc.isEmpty()) {
            Map<String, FinancialRatios> fr = service.getRatiosForYears(brc, years);
            model.addAttribute("fr", fr);
        } else {
            model.addAttribute("fr", Collections.emptyMap());
        }

        model.addAttribute("years", years);
        model.addAttribute("pageTitle", "재무 대시보드");
        model.addAttribute("corp", Map.of("name", brc + "농협")); // 사무소코드별 이름 정해야함

        // 세번째 탭 모델 ------------------------------------------------------------------
        /* !!핵심지표 5개 바인딩할때 사용하시면 됩니다.!!
        model.addAttribute("valuation", Map.of(
                "per",         perValue,         // Double
                "pbr",         pbrValue,         // Double
                "evToSales",   evSalesValue,     // Double
                "evToEbitda",  evEbitdaValue,    // Double
                "evToEbit",    evEbitValue       // Double
        ));
        */

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

}
