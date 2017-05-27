(function () {

    angular.module('webshopModule')
        .controller('loginCtrl', function ($scope) {
            $scope.login = function () {
                console.log("apihivas elott");
                api.login($scope.email, $scope.password)
                    .then(function () {
                        console.log("gut");
                    });
            };


        })
})();