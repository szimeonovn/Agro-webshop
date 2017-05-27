(function () {
    angular.module('webshopModule')
        .controller('loginCtrl', function ($scope, api) {
            $scope.login = function (user) {
                api.login(user.email, user.password);
            }
        })
})();