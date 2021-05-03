function display_viewquick(objectId){
    $.ajax({
        url: '/product/quick_view_info/'+objectId,
        success: result => {
            $("#quick_view").html(result);
        },
        error: function(result){
            console.log(result);
            alert("error");
        }
    });
    $('#quick_view').css("display","block");
}

function addtocart_quick(objectId){
    $.ajax({
        url: '/cart/add?id='+objectId,
        success: result => {
            let quantity = 0;
            $(result.listOrderDetail).each(function (i,orderDetail){
                quantity += orderDetail.quantity;
            })
            $('.cart-popup-count').html(quantity);
            showNotificationAdded();
        },
        error: function(result){
            console.log(result);
            alert("error");
        }
    });
}

function closeQuickView(){
    $("#quick_view").css("display","none");
}

//click change like product
function changeLikeProduct(id, love){
    const data = { "id" : id, "love" : love};
    $.ajax({
        url: '/like',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: result => {
            console.log(result);
        },
        error: result =>{
        }
    });
}