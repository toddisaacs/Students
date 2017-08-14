/**
 * Students module CRUD operation on students
 * Created by teisaacs on 8/13/14.
 */
var studentsModule = angular.module('mystudents.Students', [
    'ngRoute',
    'mystudents.MenuService'
]);

/**
 * Configure this modules routes and templates 
 */
studentsModule.config(['$routeProvider', function($routeProvider, $location) {
    $routeProvider.when('/students', {templateUrl: 'src/students/students.tpl.html'});
    $routeProvider.when('/students/:studentId', {templateUrl: 'src/students/addEditStudent.tpl.html'});
}]);

/**
 * Hook into the menu service and add this modules menu items
 * 
 * @param {Menu} menu - appplication menu service
 */
studentsModule.run(function(Menu) {
    Menu.addMenuItem({title: 'Students', link: '/students'});
});


/**
 * 
 * @param {$scope} scope view model scope
 * @param {Student} Student resource
 */
studentsModule.controller('StudentsCtrl', function($scope, Student, $location) {
    this.message = "Students Module";

    $scope.student = new Student();
    
    //fetch all students on page load or refresh
    Student.query().$promise.then(function(students) {
        $scope.students = students;
    }, function(error) {
        alert("Error communicating with server ");
    });

    $scope.newStudent = function() {        
         $location.path('/students/ADD');
    }
    
     $scope.editStudent = function(student) {        
         $location.path('/students/' + student.id);
    }

    $scope.remove = function(student) {
        Student.delete(student)
            .$promise.then(
                //success
                function(value) {
                    _.remove($scope.students, student)
                },
                //error
                function(error) {
                    alert(error);
                }
            );
    }
});


studentsModule.controller('AddEditStudentCtrl', function($scope, Student, $routeParams, $location, $http) {
     var studentId =  $routeParams.studentId;
     
     //if this is not a NEW student fetch to get most current verison
     if (studentId === "ADD") {
          $scope.student = new Student();
     } else {
        Student.get({id: studentId})
                .$promise.then(function(student){
                    $scope.student = student; 
                }, function(error){
                    alert("Error getting student " + studentId);
                }); 
     }
     
     $scope.save = function() {
         if ($scope.student.id) {
            Student.update($scope.student).$promise.then(function(student){
                $location.path('/students');
            }, function(error){
                alert("Error " + error.data.message);
            });
        } else {
            $scope.student.$save().then(function(response) {
                $location.path('/students');
            }, function(error) {
                alert("Error " + error.data.message);
            });
        }
     }
     
});

