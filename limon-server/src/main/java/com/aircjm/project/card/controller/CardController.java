package com.aircjm.project.card.controller;

import com.aircjm.common.vo.RestResponse;
import com.aircjm.framework.web.domain.AjaxResult;
import com.aircjm.project.card.service.CellCardService;
import com.aircjm.project.card.vo.request.GetCardRequest;
import com.aircjm.project.card.vo.request.SaveCardRequest;
import com.aircjm.project.card.vo.request.SetAnkiRequest;
import com.aircjm.project.card.vo.response.CellCardDetailResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * trello对外卡片card提供接口
 *
 * @author aircjm
 */
@RestController
@RequestMapping(value = "/api/card/")
@Api(value = "CardController", description = "卡片博客API")
public class CardController {


    @Resource
    private CellCardService cellCardService;

    @PostMapping("/save")
    public RestResponse savePage(@RequestBody @Valid SaveCardRequest request) {
        cellCardService.saveCard(request);
        return RestResponse.successEmpty();
    }

    @PostMapping("/exportCard")
    public RestResponse exportCard(@RequestBody @Valid GetCardRequest request) {
        AjaxResult ajaxResult = cellCardService.exportCard(request);
        return RestResponse.successData(ajaxResult);
    }


    @PostMapping("/list")
    public RestResponse getCardList(@RequestBody @Valid GetCardRequest request) {
        Page<CellCardDetailResponse> page = cellCardService.getCardList(request);
        return RestResponse.successData(page);
    }




    @PostMapping("/setAnki")
    public RestResponse setAnki(@RequestBody @Valid SetAnkiRequest request) {
        cellCardService.setAnki(request);
        return RestResponse.successEmpty();
    }


}