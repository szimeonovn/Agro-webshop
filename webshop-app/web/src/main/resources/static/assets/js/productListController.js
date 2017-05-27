(function () {
    angular.module('webshopModule')
        .controller('productListCtrl', function ($scope, api) {
            api.getProducts()
                .then(function (response) {
                    $scope.products = response.data;
                });

            $scope.propertyName = null;
            $scope.reverse = false;

            $scope.sortBy = function (propertyName) {
                $scope.activeSort = propertyName;
                $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
                $scope.propertyName = propertyName;
            };
        });


})();
