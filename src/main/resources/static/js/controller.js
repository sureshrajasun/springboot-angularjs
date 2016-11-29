app.controller('usersController', function($scope) {
    $scope.headingTitle = "User List";
});

app.controller('rolesController', function($scope) {
    $scope.headingTitle = "Roles List";
});


app.controller('employeeListCtrl', function($scope, $http) {
    $scope.headingTitle = "Employee List";
    $scope.getEmpList = function() {
        $http.get('http://localhost:8080/emp/employeeList')
            .success(function (data, status, headers, config) {
                $scope.empList = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<br />status: " + status ;
            });
    }


    $scope.removeEmp = function(empId) {
        $http.get('http://localhost:8080/emp/deleteEmployee?empId='+empId)
            .success(function (data, status, headers, config) {
                $scope.empList = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<br />status: " + status ;
            });
    }


    $scope.addEmployee = function() {
        $http.get('http://localhost:8080/emp/addEmployee')
            .success(function (data, status, headers, config) {
                $scope.empList = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<br />status: " + status ;
            });
    }

});
