package com.top.web.controller;

import com.top.core.controller.AbstractController;
import com.top.core.domain.SpecialtyEntity;
import com.top.core.utils.ResultValues;
import com.top.core.viewmodel.ResultModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/12
 * Time: 11:28
 * <p>
 * TODO
 */
@RequestMapping("api/major")
@Controller
public class SpecialtyController extends AbstractController {


    @RequestMapping("list")
    @ResponseBody
    public ResultModel getList(@RequestParam Integer levelId) {

        ResultModel resultModel = new ResultModel();
        List<SpecialtyEntity> list = specialtyService.findByLevelId(levelId);
        if (list != null) {
            resultModel.setData(list);
            resultModel.setMsg(ResultValues.SUCCESS);
        } else {
            resultModel.setCode(ResultModel.CODE_FAILURE);
            resultModel.setMsg(ResultValues.FAILURE);
        }
        return resultModel;
    }
}
