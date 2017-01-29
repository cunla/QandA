(function () {
  angular.module('starter').controller('Latest', ['$scope', '$ionicLoading', 'api', Latest]);
  function Latest($scope, $ionicLoading, api) {
    $scope.refresh = refresh;
    $scope.refresh();

    function refresh() {
      $ionicLoading.show(); //options default to values in $ionicLoadingConfig
      api.latest().then(function (res) {
        $scope.questions = res.data;
      }, function (res) {
        alert('Error loading latest questions!');
      }).finally(function () {
        $ionicLoading.hide();
        $scope.$broadcast('scroll.refreshComplete');
      });
    }
  }

})();
