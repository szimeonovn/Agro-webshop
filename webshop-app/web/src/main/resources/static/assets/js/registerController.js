(function () {
    angular.module('webshopModule')
        .controller('registrationCtrl', function (api, $scope, $location, growl) {
            $scope.register = function (user) {
                api.registration(user)
                    .then(function () {
                        growl.success("Successful Registration!");
                        $location.path("/login");
                    }, function () {
                        growl.error("Registration Failure!");
                    });
            };

        })
})();
