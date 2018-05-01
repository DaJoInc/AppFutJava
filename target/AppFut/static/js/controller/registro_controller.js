/**
 * 
 */
'use strict';

angular.module('myApp').controller('RegistroController', ['$scope', 'RegistroService', function($scope, RegistroService) {
    var variableGlobalJs = this;
    
    
    variableGlobalJs.userDto={idPersona:null,nombre:null,apellido:null,tipoDocumento:null,documento:null,fechaNacimiento:null,idUsuario:null,nombreUsuario:null,contrasena:null,estado:null,idRol:null,codRespuesta:null,msgRespuesta:null};

    variableGlobalJs.submit = submit;
    variableGlobalJs.reset = reset;
    //registrarUsuario();
    //fetchAllUsers();
   
    function registrarUsuario(userDto) {
        RegistroService.registrarUsuarios(userDto)
            .then(
                function (respuestaServicio) {
                    variableGlobalJs.userDto = respuestaServicio;
                },
                function(errResponse){
                console.log('log while fetching Profile');
                }
            );
        
    }
    
    function fetchAllUsers(){
    	RegistroService.fetchAllUsers()
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
    		
    		registrarUsuario(variableGlobalJs.userDto);
    	}
    }
    
  
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
