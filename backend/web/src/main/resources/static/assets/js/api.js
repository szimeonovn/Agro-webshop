(function () {
    angular.module('webshopModule')
        .service('api', function ($http, $window) {
            var urlBase = 'http://localhost:8080/agrowebshop';

            if ($window.urlBase) {
                urlBase = $window.urlBase;
            }

            this.registration = function (user) {
                return $http.post(urlBase + "/register", user);
            };

            this.login = function (email, password) {
                return $http.get(urlBase + "/login", {
                    "email" : email,
                    "password" : password
                }).then(function (response) {
                    return response.data;
                })
            };

            this.getProducts = function () {
                return $http.get(urlBase + '/product');
            };

        });
})();