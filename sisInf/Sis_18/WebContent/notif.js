    var botonsito=document.getElementById("botonsito");
    /*botonsito.addEventListener('click',function()){
        prueba_notificacion();
    }*/


    function prueba_notificacion() {

        if (Notification) {

            if (Notification.permission !== "granted") {

                Notification.requestPermission()

            }
            var title = "Xitrus"
            var extra = {

                icon: "http://xitrus.es/imgs/logo_claro.png",
                body: "Notificación de prueba en Xitrus"

            }
            var noti = new Notification( title, extra)
            noti.onclick = {

               // alert("Has pulsado");

            }
            noti.onclose = {

               // alert("has cerrado");// Al cerrar

            }
            setTimeout( function() { noti.close() }, 10000)

        }

        else{
            alert("Tu navegador no soporta notificaciones")
        }

    }

