(function () {
    angular.module('webshopModule')
        .controller('productListCtrl', function ($scope, api) {
            api.getProducts()
                .then(function (response) {
                    $scope.products = response.data;
                });
        })
})();
