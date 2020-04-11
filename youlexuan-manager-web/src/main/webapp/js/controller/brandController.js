app.controller('brandController',function ($scope,$controller,brandservice) {//依赖注入服务
   $controller('baseController',{$scope:$scope});//继承

    $scope.findAll=function () {
        brandservice.findAll().success(//吧http.get()业务分离到了brandservice中，
            function (response) {
                $scope.list=response;
            }
        );
    }

    $scope.findPage=function(page,rows) {
        brandservice.findPage(page,rows).success(
            function (response) {
                $scope.list=response.rows;
                //吧后台的总条数给$scode.paginationConf;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        )
    }
    //保存
    $scope.save=function(){
        if($scope.entity.id!=null){//如果有ID
            brandservice.update($scope.entity).success(
                function(response){
                    if(response.success){
                        //重新查询
                        $scope.reloadList();//重新加载
                        alert(response.message);
                    }else{
                        alert(response.message);
                    }
                }
            );
        }else{
            brandservice.add($scope.entity).success(
                function(response){
                    if(response.success){
                        //重新查询
                        $scope.reloadList();//重新加载
                        alert(response.message);
                    }else{
                        alert(response.message);
                    }
                }
            )
        }

    }
    //根据id查找操作
    $scope.findOne=function (id) {
        brandservice.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    }

    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        brandservice.dele($scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.reloadList();//刷新列表
                }
            }
        );
    }
    $scope.searchEntity={};//定义搜索对象,不定义会出现初始化查询的时候401错误
    //tiaojianchaxun
    $scope.search=function (page,rows) {
        brandservice.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        )
    }

})