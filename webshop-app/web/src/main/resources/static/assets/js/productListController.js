(function () {
    angular.module('webshopModule')
        .controller('productListCtrl', function ($scope, api, growl) {
            api.getProducts()
                .then(function (response) {
                    $scope.products = response.data;
                });

            $scope.propertyName = null;
            $scope.reverse = false;
            $scope.activeSort = 'title';

            $scope.sortBy = function (propertyName) {
                $scope.activeSort = propertyName;
                $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
                $scope.propertyName = propertyName;
            };

            $scope.order = function (title) {
                api.buyIfLoggedIn(title);
            }
        });


})();
