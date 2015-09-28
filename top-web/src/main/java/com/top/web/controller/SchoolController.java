package com.top.web.controller;

import com.top.core.controller.AbstractController;
import com.top.core.domain.SchoolEntity;
import com.top.core.utils.ResultValues;
import com.top.core.viewmodel.ResultModel;
import org.jetbrains.annotations.NotNull;
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
@RequestMapping("api/school")
@Controller
public class SchoolController extends AbstractController {


    @RequestMapping("list")
    @ResponseBody
    public ResultModel getList(@NotNull @RequestParam Integer levelId,
                               @NotNull @RequestParam Integer majorId) {

        ResultModel resultModel = new ResultModel();
        List<SchoolEntity> list = schoolService.find(levelId, majorId);
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
