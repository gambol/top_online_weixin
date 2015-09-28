var app = angular.module('app', []);
app.controller('ctl', function ($scope, $http, $window) {


	var levelList = [{id: 1, name: "高起专"}, {id: 2, name: "专升本"}, {id: 3, name: "高起本"}];

	$scope.projectSelected = false;
	$scope.categoryId = 0;
	$scope.projectDesc = [];
	$scope.dialogSelector = {
		param: {
			level: {id: 0, name: "请选择"},
			major: {id: 0, name: "请选择"},
			school: {id: 0, name: "请选择"}
		}
	};

	$scope.simpleSelector = {};

	/**
	 * 选择分类
	 * @param categoryId 分类id
	 * @param $event
	 */
	$scope.onSelectCategory = function (categoryId, $event) {

		$scope.projectSelected = false;
		$scope.categoryId = categoryId;

		$("#category-selector").find("div.category-btn").each(function () {
			$(this).removeClass("active");
		});

		$($event.currentTarget).addClass("active");

		if (categoryId > 2) {
			$scope.loadSimpleSelector(categoryId);
		}
	};


	/**
	 * 多级选择器 打开dialog 加载内容
	 * @param param
	 */
	$scope.openDialog = function (param) {
		$scope.dialogSelector.currentParam = param;
		switch (param) {

			case 'level':
				$scope.dialogSelector.matrix = $scope.toMatrix(levelList, 2);
				$('#modal').modal('show');
				break;

			case 'major':

				if ($scope.dialogSelector.param.level.id == 0) {
					return alert('请选择层次');
				}


				$http({
					method: 'GET',
					url: pageUrl('/api/major/list?levelId=' + $scope.dialogSelector.param.level.id)
				}).success(function (result) {
					$scope.dialogSelector.matrix = $scope.toMatrix(result.data, 2);
					$('#modal').modal('show');

				}).error(function (result, status) {
					alert('请求遇到错误: code=' + status);
				});
				break;

			case 'school':
				if ($scope.dialogSelector.param.major.id == 0) {
					return alert('请选择专业');

				}

				$http({
					method: 'GET',
					url: pageUrl('/api/school/list'
						+ '?levelId=' + $scope.dialogSelector.param.level.id
						+ "&majorId=" + $scope.dialogSelector.param.major.id)
				}).success(function (result) {
					$scope.dialogSelector.matrix = $scope.toMatrix(result.data, 2);
					$('#modal').modal('show');

				}).error(function (result, status, code) {
					alert('请求遇到错误: code=' + code);
				});
				break;
		}
	};


	/**
	 * 多级选择器 选中事件
	 * @param item
	 */
	$scope.onConfirmDialog = function (item) {

		switch ($scope.dialogSelector.currentParam) {
			case 'level':
				$scope.dialogSelector.param.level = item;
				$scope.dialogSelector.param.major = {id: 0, name: "请选择"};
				$scope.dialogSelector.param.school = {id: 0, name: "请选择"};
				break;
			case 'major':
				$scope.dialogSelector.param.major = item;
				$scope.dialogSelector.param.school = {id: 0, name: "请选择"};
				break;
			case 'school':
				$scope.dialogSelector.param.school = item;
				$scope.loadProjectInfo();
				break;
		}
		$scope.dialogSelector.currentParam = '';
		$('#modal').modal('hide');
	};

	/**
	 * 会计课程选择器
	 * @param projectId 最终提交的课程id
	 * @param $event
	 */
	$scope.onClickAccSelector = function (projectId, $event) {
		$scope.projectId = projectId;

		$("#acc-selector").find("p.active").each(function () {
			$(this).removeClass("active");
		});

		$($event.currentTarget).addClass("active");

		$scope.loadProjectInfo();
	};


	/**
	 * 加载单级课程选择器的内容
	 * @param categoryId
	 */
	$scope.loadSimpleSelector = function (categoryId) {
		// 根据分类id加载课程
		$http({
			method: 'GET',
			url: pageUrl('/api/project/list?categoryId=' + categoryId)
		}).success(function (result) {
			$scope.simpleSelector.matrix = $scope.toMatrix(result, 3);

		}).error(function (result, status, code) {
			alert('请求遇到错误: code=' + code);

		});

	};

	/**
	 * 单级选择器选中事件
	 * @param item
	 * @param $event
	 */
	$scope.onClickSimpleSelector = function (item, $event) {
		$scope.projectId = item.id;
		$("#simple-selector").find("button.active").each(function () {
			$(this).removeClass("active");
		});

		$($event.currentTarget).addClass("active");

		$scope.loadProjectInfo();
	};

	/**
	 * 加载项目信息
	 */
	$scope.loadProjectInfo = function () {

		var levelId = $scope.dialogSelector.param.level.id;
		var majorId = $scope.dialogSelector.param.major.id
		var schoolId = $scope.dialogSelector.param.school.id;

		if (levelId > 0 && majorId > 0 && schoolId > 0) {
			console.log("loading by 3 params");
			$scope.projectSelected = true;
			$http({
				method: 'GET',
				url: pageUrl('/api/project/find'
					+ '?levelId=' + $scope.dialogSelector.param.level.id
					+ "&majorId=" + $scope.dialogSelector.param.major.id
					+ "&schoolId=" + $scope.dialogSelector.param.school.id)
			}).success(function (result) {

				if (result.code == 1) {
					$scope.projectSelected = true;
					$scope.projectId = result.data.id;
					$scope.displayProjectInfo(result.data);
				} else {
					alert("相关项目暂无信息");
				}

			}).error(function (result, status, code) {
				alert('请求遇到错误: code=' + code);
			});

		} else if ($scope.projectId > 0) {
			console.log("loading by projectId");

			$http({
				method: 'GET',
				url: pageUrl('/api/project/get?projectId=' + $scope.projectId)
			}).success(function (result) {
				if (result.code == 1) {
					$scope.projectSelected = true;
					$scope.displayProjectInfo(result.data);
				} else {
					alert("相关项目暂无信息");
				}

			}).error(function (result) {
				alert('请求遇到错误: code=' + result.code);
			});
		}

	};

	$scope.displayProjectInfo = function (project) {
		console.log("project", project);
		var unit;
		switch (project.studyUnit) {
			case 1:
				unit = '年';
				break;
			case 2:
				unit = '月';
				break;
			case 3:
				unit = '天';
				break;
			case 4:
				unit = '小时';
				break;
		}
		$scope.projectDesc.push('学制:' + project.studyDuration + unit);
		$scope.projectDesc.push('  报名费:' + project.entryFee + '元');
		$scope.projectDesc.push('+ 考试费:' + project.examFee + '元');
		$scope.projectDesc.push('+ 学费:' + project.tuitionFee + '元/' + unit);
		$scope.projectDesc.push('+ 书本费:' + project.bookFee + '元');
		$scope.projectDesc.push('= 总计: ' + project.totalFee + '元');

	};


	/**
	 * 点击在线报名 提交信息到下一页面
	 */
	$scope.enroll = function () {
		$window.location.href = pageUrl("/home/confirmOrder?projectId=" + $scope.projectId);
	};


	$scope.toMatrix = function (list, cols) {
		var i = 0;
		var result = [];

		while (i < list.length) {
			var row = [];
			var j = 0;
			while (j < cols) {
				if (list[i] != undefined)
					row.push(list[i]);
				i++;
				j++;
			}
			result.push(row);
		}
		console.log(result);
		return result;
	}
});
