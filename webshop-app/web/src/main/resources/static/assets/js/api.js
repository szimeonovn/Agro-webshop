(function () {
    angular.module('webshopModule')
        .service('api', function ($rootScope, $http, $window, growl) {
            var urlBase = 'http://localhost:8080/agrowebshop';

            if ($window.urlBase) {
                urlBase = $window.urlBase;
            }

            this.registration = function (user) {
                return $http.post(urlBase + "/register", user);
            };

            this.login = function (user) {
                return $http.get(urlBase + "/processLogin", {
                    "email": user.email,
                    "password": user.password
                });
            };

            this.buyIfLoggedIn = function (title) {
                $http.get(urlBase + "/user").then(
                    function (response) {
                        growl.success(response.data.value + " has purchased " + title + " successfully!");
                    },
                    function () {
                        growl.error("You have to be logged in to buy something!");
                    }
                )
            };

            this.getProducts = function () {
                return $http.get(urlBase + '/product');
            };

        });
})();