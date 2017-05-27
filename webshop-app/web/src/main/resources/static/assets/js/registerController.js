(function () {
    angular.module('webshopModule')
        .controller('registrationCtrl', function (api, $scope) {
            $scope.register = function (user) {
                api.registration(user)
                    .then(function () {
                        $('#signUpModal').modal('hide');
                    });
            };

        })
})();
