app.controller('indexController',function ($scope,$controller,logservice) {
    //读取当前登录人
    $scope.showLoginName=function () {
       logservice.loginName().success(
           function (response) {
               $scope.loginName=response.loginName;
           }
       )
    }
    
})