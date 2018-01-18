define(['datatables'], function () {
    if (window.Users) { //Prevents defining the module twice
        return false;
    }
    console.log('Run: Users.js');
    var Users = {
        //Initializer Methods
        run: function () {
            this.runViewController();
            this.bindEvents();
        },
        //Other Events
        bindEvents: function () {
            $body = $('body');
        },
        ///Call All Method, carga funciones generales que afecta a todo el controlador del servidor.
        runViewController: function () {
            Users.callPublic();
        },

        //funcion general que afecta a todo el controlador del servidor.
        //Metodo general del Cotroller, se ejecuta al inicializar el js
        callPublic: function () {
            alert('Js del controlador');
        },
        list: function () {
            alert('Js del metodo del controlador')
            Users.createdatatables();
        },
        //Metodos del controlador del servidor(functiones) que se ejecuta cuando se displaya una pagina.
        //Soy una funcion del Controlador fileController y ejecuto la accion Index.
        createdatatables: function () {
            $('#datatable').DataTable();
        }
    };
    Users.run();
    return Users;
});