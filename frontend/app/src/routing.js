(function () {
    angular
        .module('webshopModule')
        .config(function ($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'templates/main.html',
                    controller: 'productListCtrl'
                })
                .otherwise({
                    redirectTo: '/'
                });

        });
})();