define([], function () {
    if (window.App) { // Prevents defining the module twice
        return false;
    }
    console.log('Run: App.js');
    var App = {
        // Initializer Methods
        run: function () {
            this.runViewController();
            this.bindEvents();
        },
        // Other Events
        bindEvents: function () {
            $body = $('body');
        },
        // /Call All Method, carga funciones generales que afecta a todo el
        // controlador del servidor.
        runViewController: function () {
            App.callPublic();
        },

        // funcion general que afecta a todo el controlador del servidor.
        // Metodo general del Cotroller, se ejecuta al inicializar el js
        callPublic: function () {
            alert('App JS  -> JS Globales de la Aplicacion');
        }

    };
    App.run();
    return App;
});