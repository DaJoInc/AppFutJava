/**
 * 
 */
'use strict';

angular.module('myApp').controller('MostrarController', ['$scope', 'MostrarService', function($scope, MostrarService) {
   
	
	
	
	var variableGlobalJs = this;
    
								
    variableGlobalJs.userDto={idConvocatoria:null,idEquipo:null,nombreEquipo:null};

    variableGlobalJs.submit = submit;
    variableGlobalJs.reset = reset;
    //registrarUsuario();
    fetchAllUsers();

    function fetchAllUsers(){
    	MostrarService.fetchAllUsers()
            .then(
            function(d) {
            	variableGlobalJs.userDto = d;
              
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
    
    
    function submit(){
    	if(variableGlobalJs.userDto!=null){
    		
    		mostrar(variableGlobalJs.userDto);
    	}
    }
    
  
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }

}]);