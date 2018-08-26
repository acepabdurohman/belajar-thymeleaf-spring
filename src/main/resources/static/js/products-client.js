$(document).ready(function(){
    getProducts();

    addOrUpdateProduct();

});

function addOrUpdateProduct(){
    $("#sbmt").click(function (e) {

        var idProduct = document.getElementById("id-product").value;
        var productName = document.getElementById("product-name").value;
        var productPrice = document.getElementById("product-price").value;

        var obj = {
            "idProduct": idProduct,
            "productName": productName,
            "productPrice": productPrice
        };

        console.log(obj);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(obj),
            url: "http://localhost:1111/products",
            success: function (response) {

            },
            statusCode: {
                201: function () {
                    alert('Data berhasil disimpan');
                },
                400: function () {
                    alert('Inputan tidak boleh kosong');

                },
                404: function () {
                    alert('Not Found');

                }
            }
        });

    })
}

function getProducts(){
    $.ajax({
        type: "GET",
        url: "http://localhost:1111/products",
        success: function(response){
            var i = 1;
            response.forEach(function(data){
                var id = data.id;
                $("#product-list").append(
                    "<tr>" +
                    "<td>" +
                    i +
                    "</td>" +
                    "<td>" +
                    data.id +
                    "</td>" +
                    "<td>" +
                    data.name +
                    "</td>" +
                    "<td>" +
                    data.price +
                    "</td>" +
                    "<td>" +
                    "<a href='/products/page/type?form=editProduct&id="+id+"'>" +
                    "Edit" +
                    "</a>" +
                    " | " +
                    "<a href='#' onclick='deleteData("+id+")'>" +
                    "Delete" +
                    "</a>" +
                    "</td>" +
                    "</tr>"
            );
                i++;
            });
        },
        error: function(xhr, status, error){
            var statusCode = xhr.status;
            console.log("Status code : " + statusCode);
            if (statusCode === 404){
                $("#product-list").append(
                    "<tr>" +
                    "<td colspan='5' align='center'>Data kosong</td>" +
                    "</tr>"
                );
            }
        }
    });
}

function deleteData(id){
    var c = confirm("Apakah anda yakin akan menghapus data ?");
    if (c){
        $.ajax({
            type: "DELETE",
            dataType: "json",
            data: JSON.stringify(id),
            url: "http://localhost:1111/products",
            success: function (response) {

            },
            statusCode: {
                200: function(){
                    alert('Data Berhasil dihapus');
                    location.reload(true);
                },
                404: function () {
                    alert('Not Found');
                }
            }
        });
        return true;
    } else {
        return false;
    }
}