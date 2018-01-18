define([], function () {
    if (window.Imagen) { //Prevents defining the module twice
        return false;
    }
    console.log('Run: imagen.js');
    var Imagen = {
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
            Imagen.callPublic();
        },

        //funcion general que afecta a todo el controlador del servidor.
        //Metodo general del Cotroller, se ejecuta al inicializar el js
        callPublic: function () {
            //alert('Todo Controller');
            console.log("pruerbas");
        },
        //Metodos del controlador del servidor(functiones) que se ejecuta cuando se displaya una pagina.
        //Soy una funcion del Controlador fileController y ejecuto la accion Index.

    };
    Imagen.run();
    return Imagen;
});