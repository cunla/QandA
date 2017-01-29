(function () {
  angular.module('starter').controller('Question', ['$scope', '$ionicLoading', '$stateParams', 'api', Question]);
  function Question($scope, $ionicLoading, $stateParams, api) {
    $scope.refresh = refresh;
    $scope.postNewAnswer = postNewAnswer;
    var questionId = $stateParams.questionId;
    $scope.newAnswer = {};
    $scope.refresh();

    function refresh() {
      $ionicLoading.show(); //options default to values in $ionicLoadingConfig
      api.question(questionId).then(function (res) {
        $scope.question = res.data;
      }, function (res) {
        alert('Error loading latest questions!');
      }).finally(function () {
        $ionicLoading.hide();
        $scope.$broadcast('scroll.refreshComplete');
      });
    }

    function postNewAnswer() {
      $ionicLoading.show();
      api.postAnswer(questionId, $scope.newAnswer.author, $scope.newAnswer.body)
        .then(function (res) {
          $scope.newAnswer = {};
          refresh();
        })
        .finally(function () {
          $ionicLoading.hide();
        });
    }
  }

})();
