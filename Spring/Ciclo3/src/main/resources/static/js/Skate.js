function InsertarInformacionSkates() {
    $("#resultadoSkate").empty();
    let myData = {
        name: $("#nameSkate").val(),
        description: $("#descriptionSkate").val(),
        brand: $("#brandSkate").val(),
        yearb:$("#yearSkate").val(),
        categoryId :$("#category_idSkate").val(),
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Skate/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            alert("Insercion exitosa");
            console.log()
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    }
    );
}

function ConsultarInformacionSkates() {
    $.ajax({
        url: "http://localhost:8080/api/Skate/all",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            pintarRespuestaSkates(respuesta);
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    });
}

function pintarRespuestaSkates(items) {
    $("#resultadoSkate").empty();
    let myTable = "<table border='1'>";
    myTable += "<caption> SKATE </caption>";
    myTable += "<tr><th>CODE</th> <th> NAME</th> <th> BRAND</th> <th> YEAR</th>  <th> DESCRIPTION</th>  <th> CODE CATEGORY</th>  <th> NAME CATEGORY</th>  <th> DESCRIPTION CATEGORY</th>  <th> MESSAGE</th>  <th> RESERVATION</th> </th>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].brand + "</td>";
        myTable += "<td>" + items[i].yearb + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += "<td>" + items[i].categoryId + "</td>";
        myTable += "<td>" + items[i].category.name + "</td>";
        myTable += "<td>" + items[i].category.description + "</td>";
        myTable += "<td>" + items[i].message + "</td>";
        myTable += "<td>" + items[i].reservation + "</td>";
        //myTable += "<td> <button onclick='borrarElementoCategory(" + items[i].id + ")'> Borrar </button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultadoSkate").append(myTable);
}