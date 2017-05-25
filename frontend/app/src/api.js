(function () {
    angular.module('webshopModule')
        .service('api', function ($http, $window) {
            var urlBase = 'http://localhost:8080';

            if ($window.urlBase) {
                urlBase = $window.urlBase;
            }

            this.registration = function (user) {
                return $http.post(urlBase + "/register", user);
            };

            this.getProducts = function () {
                return $http.get(urlBase + '/product');
            };

        });
})();