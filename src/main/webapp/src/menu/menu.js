/**
 * Created by teisaacs on 8/13/14.
 */
angular.module('mystudents.MenuService', [])

/**
 * Menu data
 */
.factory('Menu', function($http){
    var menuService = {};
    var _menus = [];

    menuService.getMenus = function() {
        return _menus;
    }

    menuService.addMenuItem = function(menuItem) {
        _menus.push(menuItem);
    }

    return menuService;

})

/**
 * Menu controller used by the index page to control menus
 */
.controller('MenuCtrl', function($scope, Menu, $location) {
    window.scope = $scope;
    console.log("MenuCtrl");

    $scope.menus = Menu.getMenus();

    $scope.getClass = function(path) {
        if ($location.path().substr(0, path.length) == path) {
            return "active";
        } else {
            return "";
        }
    }

});