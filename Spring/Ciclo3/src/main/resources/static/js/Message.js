/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function InsertarInformacionMessage() {
    $("#resultadoMessage").empty();
    let myData = {
        messageText : $("#messageText").val(),
        idClient: $("#idClient").val(),
        idSkates: $("#idSkate").val()
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Message/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            alert("Insercion exitosa");
            console.log();
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    }
    );
}

function ConsultarInformacionMessage() {
    $.ajax({
        url: "http://localhost:8080/api/Message/all",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            pintarRespuestaMessage(respuesta.items);
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    }
    );
}

function pintarRespuestaMessage(items) {
    $("#resultadoMessage").empty();
    let myTable = "<table border='1'>";
    myTable += "<caption> SKATE </caption>";
    myTable += "<tr><th>CODE</th> <th> NAME</th></th>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].messageText + "</td>";
        myTable += "<td>" + items[i].client + "</td>";
        myTable += "<td>" + items[i].skates + "</td>";
        //myTable += "<td> <button onclick='borrarElementoCategory(" + items[i].id + ")'> Borrar </button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultadoMessage").append(myTable);
}