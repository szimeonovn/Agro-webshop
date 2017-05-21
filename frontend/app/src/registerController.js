(function () {
    angular.module('webshopModule')
        .controller('registerCtrl', function (api, $scope) {
            $scope.register = function (user) {
                api.registration(user);
            }
        })
})();
