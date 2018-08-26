$(document).ready(function(){
    getProducts();
});

function getProducts(){
    $.ajax({
        type: "GET",
        url: "http://localhost:1111/products",
        success: function(response){
            var i = 1;
            response.forEach(function(data){
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
                    "</tr>"
            );
                i++;
            });
        },
        error: function(xhr, status, error){
            var statusCode = xhr.status;
            console.log("Status code : " + statusCode);
        }
    })
}