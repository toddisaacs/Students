/**
 * Created by teisaacs on 8/13/14.
 */
angular.module('mystudents')
    .provider('Student', function() {
        this.$get = ['$resource', function($resource) {
            var Student = $resource('http://localhost:8888/api/students/:id', {}, {
                //Setup updates to use PUT and Workaround for PUT requests not sending ID in url 
                update: {
                    method: 'PUT',
                    params: {
                        id: "@id"
                    }
                }
            });

            return Student;
        }];
    });