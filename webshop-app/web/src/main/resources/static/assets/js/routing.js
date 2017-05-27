(function () {
    angular
        .module('webshopModule')
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'templates/main.html',
                    controller: 'productListCtrl'
                })
                .when('/login', {
                    templateUrl: 'templates/login.html',
                    controller: 'loginCtrl'
                })
                .when('/registration',{
                    templateUrl: 'templates/registration.html',
                    controller: 'registrationCtrl'
                })
                .otherwise({
                    redirectTo: '/'
                });

            $locationProvider.hashPrefix('');

        });
})();