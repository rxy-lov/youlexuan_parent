app.controller('baseController',function ($scope) {
    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        // $scope.findPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
//分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };
    $scope.selectIds=[];//选中的ID集合
    //删除操作
    $scope.updateSelection=function($event,id) {//$event谁调用 它就是谁  有点像java里的this,如果是被选中,则增加到数组
        if ($event.target.checked){
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx,1);//删除
        }

    }
})