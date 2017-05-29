(function () {
    angular.module('webshopModule')
        .controller('loginCtrl', function ($scope, api, growl) {
            $scope.login = function (user) {
                api.login(user);
            }
        })
})();