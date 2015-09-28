<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7"> <![endif]-->
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>托普在线</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/enroll.css"/>" rel="stylesheet"/>
<style type="text/css">
footer{
        padding:0px!important;
    }
    .my-footer{
        margin-top: -5px;
    }
</style>
</head>

<body ng-app="app" ng-controller="ctl">


<div class="wrapper">

    <jsp:include page="header.jsp"/>

    <div class="container">

        <!--banner开始-->
        <div class="row">
            <img src="<c:url value="/resources/img/index_banner1.png"/>" style="width: 100%;"/>
        </div>
        <!--banner结束-->

        <!-- 分类选择 -->
        <div id="category-selector">

            <div class="row" style="margin-top: 2%">
                <div class="col-xs-3  category-btn" ng-click="onSelectCategory(1,$event)">
                    <img src="<c:url value="/resources/img/icon/icon_1_select.png"/>">
                    <br/><span>学历提升</span>
                </div>
                <div class="col-xs-3  category-btn" ng-click="onSelectCategory(2,$event)">
                    <img src="<c:url value="/resources/img/icon/icon_2_select.png"/>">
                    <br/><span>会计培训</span>
                </div>
                <div class="col-xs-3  category-btn" ng-click="onSelectCategory(3,$event)">
                    <img src="<c:url value="/resources/img/icon/icon_3_select.png"/>">
                    <br><span>技能培训</span>
                </div>
                <div class="col-xs-3  category-btn" ng-click="onSelectCategory(4,$event)">
                    <img src="<c:url value="/resources/img/icon/icon_4_select.png"/>">
                    <br> <span>失业培训</span>
                </div>
            </div>

            <!--第二行图标开始-->
            <div class="row" style="margin-top: 2%; margin-bottom: 2%">
                <div class="col-xs-3  category-btn" ng-click="onSelectCategory(5,$event)">
                    <img src="<c:url value="/resources/img/icon/icon_5_select.png"/>">
                    <br> <span>银行证书</span>
                </div>
                <div class="col-xs-3  category-btn" ng-click="onSelectCategory(6,$event)">
                    <img src="<c:url value="/resources/img/icon/icon_6_select.png"/>">
                    <br> <span>期货证书</span>
                </div>
                <div class="col-xs-3  category-btn" ng-click="onSelectCategory(7,$event)">
                    <img src="<c:url value="/resources/img/icon/icon_7_select.png"/>">
                    <br> <span>证券证书</span>
                </div>
                <div class="col-xs-3  category-btn" ng-click="onSelectCategory(8,$event)">
                    <img src="<c:url value="/resources/img/icon/icon_8_select.png"/>">
                    <br> <span>少儿培训</span>
                </div>
            </div>
        </div>


        <!-- 项目介绍 选分类后隐藏 -->
        <div class="row" style="background: #e8eff6; " ng-show="categoryId==0">
            <ul class="list-group" style="margin:5% 5% 5% 5%;">
                <a href="#" class="list-group-item">
                    <span class="list-group-item-heading">关于我们</span>

                    <p class="list-group-item-text">测试测试测试测试测试测试测试测试测试测试</p>
                </a>
                <li class="list-group-item">
                    <span class="list-group-item-heading">微博设置</span>

                    <p class="list-group-item-text">测试测试测试测试测试测试测试测试测试测试</p>
                </li>
                <li class="list-group-item">
                    <span class="list-group-item-heading">会员注册</span>

                    <p class="list-group-item-text">测试测试测试测试测试测试测试测试测试测试</p>
                </li>
                <li class="list-group-item">
                    <span class="list-group-item-heading">检查新版本</span>

                    <p class="list-group-item-text">测试测试测试测试测试测试测试测试测试测试</p>
                </li>
            </ul>
        </div>

        <!-- BEGIN 多级选择器 -->
        <div class="row" ng-show="categoryId==1" style="background-color: rgb(232, 239, 246);
    padding: 10px 15px 10px 15px">
            <div class="row" style="margin-top: 5px ;">
                <div class="col-xs-4" style="padding-right: 0; ">
                    <p class="pull-right text-center"
                       style="border-radius:5px 0 0 5px; border: 1px solid grey; border-right: 0; width: 100%;
         height: 10%;
            background: #6aafe9; color: white;">层次
                    </p>
                </div>
                <div class="col-xs-8 text-center" style="padding-left: 0">
                    <p style="border-radius: 0 5px  5px 0; border: 1px solid grey; border-left: 0; width:
          100%; background-color: white; height: 10%;" ng-click="openDialog('level')"
                       ng-bind="dialogSelector.param.level.name">
                    </p>
                </div>
            </div>

            <div class="row" style="margin-top: 5px;">
                <div class="col-xs-4" style="padding-right: 0; ">
                    <p class="pull-right text-center"
                       style="border-radius:5px 0 0 5px; border: 1px solid grey; border-right: 0; width: 100%;
         height: 10%;
            background: #6aafe9; color: white;">专业
                    </p>
                </div>
                <div class="col-xs-8 text-center" style="padding-left: 0">
                    <p style="border-radius: 0 5px  5px 0; border: 1px solid grey; border-left: 0; width: 100%;
      height: 10%;background-color: white;" ng-click="openDialog('major')"
                       ng-bind="dialogSelector.param.major.name">
                    </p>
                </div>
            </div>

            <div class="row" style="margin-top: 5px;">
                <div class="col-xs-4" style="padding-right: 0; ">
                    <p class="pull-right text-center"
                       style="border-radius:5px 0 0 5px; border: 1px solid grey; border-right: 0; width: 100%;
         height: 10%;
            background: #6aafe9; color: white;">学校
                    </p>
                </div>
                <div class="col-xs-8 text-center" style="padding-left: 0">
                    <p style="border-radius: 0 5px  5px 0; border: 1px solid grey; border-left: 0; width: 100%;
      height: 10%;background-color: white;" ng-click="openDialog('school')"
                       ng-bind="dialogSelector.param.school.name">
                    </p>
                </div>
            </div>
        </div>
        <!-- END 多级选择器 -->

        <!-- BEGIN 会计选择器 -->
        <div class="row" id="acc-selector" ng-show="categoryId==2" style="background-color: rgb(232, 239, 246);
    padding: 15px 15px 15px 15px">
            <p class="text-center"
               style="border-radius:5px 0 0 5px;  border-right: 0; width: 40%; background: #6aafe9; color: white;"
                    >
                会计从业资格证
            </p>

            <p class="selectable text-center" style=" border-left: 0; border-right: 0; "
               ng-click="onClickAccSelector(12,$event)">
                通关班</p>

            <p class="selectable text-center" style=" border-left: 0; border-right: 0; "
               ng-click="onClickAccSelector(12,$event)">
                基础班</p>

            <p class="selectable text-center" style="border-radius: 0 5px  5px 0; border-left: 0;"
               ng-click="onClickAccSelector(12,$event)">
                强化班</p>
            <br>

            <p class="text-center"
               style="border-radius:5px 0 0 5px;  border-right: 0; width: 40%;
            background: #6aafe9; color: white;">会计职称
            </p>

            <p class="selectable text-center" style=" border-left: 0; border-right: 0;"
               ng-click="onClickAccSelector(12,$event)">
                初&nbsp;&nbsp;&nbsp;&nbsp;级</p>

            <p class="selectable text-center" style="border-left: 0; border-right: 0; "
               ng-click="onClickAccSelector(12,$event)">
                中&nbsp;&nbsp;&nbsp;&nbsp;级</p>

            <p class="selectable text-center" style="border-radius: 0 5px  5px 0;  border-left: 0; "
               ng-click="onClickAccSelector(12,$event)">&nbsp;
            </p>

            <br>

            <p class="text-center"
               style="border-radius:5px 0 0 5px;  border-right: 0; width: 40%;
                     background: #6aafe9; color: white;">注册会计师
            </p>

            <p class="selectable text-center" style=" border-left: 0; border-right: 0;"
               ng-click="onClickAccSelector(12,$event)">
                通关班</p>

            <p class="selectable text-center" style=" border-left: 0; border-right: 0; "
               ng-click="onClickAccSelector(12,$event)">
                基础班</p>

            <p class="selectable text-center" style="border-radius: 0 5px  5px 0;  border-left: 0; "
               ng-click="onClickAccSelector(12,$event)">
                强化班
            </p>
        </div>
        <!-- END 会计选择器 -->

        <!-- BEGIN 单级选择器 -->
        <div class="row" style="background-color: rgb(232, 239, 246);
    padding: 15px 15px 15px 15px" ng-show="categoryId>2">
            <div class="panel panel-primary">

                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane active" id="test">
                            <div class="container" id="simple-selector">
                                <div class="row" style="margin-left: 5px; width:100%"
                                     ng-repeat="row in simpleSelector.matrix">
                                    <button style="width:30%;" class="col-xs-4 btn btn-default" ng-repeat="item in row"
                                            ng-click="onClickSimpleSelector(item, $event)">
                                        {{item .name}}
                                    </button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END 单级选择器 -->

        <!-- 项目说明 选择项目后显示 -->
        <div id="project-desc" class="row" ng-show="projectSelected">
            <div style="padding: 5px 15px 5px 30px; background-color: #2fb0b6; color:white"
                 class="col-xs-12">相关费用及报名信息
            </div>
            <div style="padding-top: 10px; margin: 0 15px 0px 15px;" class="col-xs-12"
                 ng-repeat="text in projectDesc" ng-bind="text" ng-trim="false"></div>
            <div style="padding-top: 10px; margin: 0 15px 0px 15px;" class="col-xs-12">&nbsp;</div>
        </div>

    </div>
    <!-- pusher for sticky footer -->
    <div class="push"><!--//--></div>
</div>
<!-- wrapper -->


<footer>
    <div class="my-footer">
        <button type="button" class="btn btn-success" style="width: 40%"
                onclick="document.location.href = 'tel:400-676-5291';">
            电话咨询
        </button>
        <button id="enroll-btn" type="button" class="btn btn-warning" style="width: 40%"
                ng-disabled="!projectSelected"
                ng-click="enroll()">在线报名
        </button>
    </div>
</footer>


<!-- /.modal -->
<div class="modal fade modal-fullscreen force-fullscreen" id="modal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">请选择</h4>
            </div>
            <div class="modal-body pre-scrollable">
                <div class="container-fluid" id="item-container">
                    <div class="row" ng-repeat="row in dialogSelector.matrix">
                        <button class="col-xs-6 btn btn-default btn-lg btn-block" ng-repeat="item in row"
                                ng-click="onConfirmDialog(item)">{{item.name}}
                        </button>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <%--<button type="button" class="btn btn-primary">Save changes</button>--%>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

</body>
<c:import url="/pages/_contextPath.jsp"/>
<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/angular.js"/>"></script>
<script src="<c:url value="/resources/js/enroll.js"/>"></script>

<script>
    header({title: "在线报名", back: false});
</script>
</html>
