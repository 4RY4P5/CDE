var foodMenu = [
    { id: 1, name: 'Sandwich', price: 99, active: 'Yes', dateOfLaunch: '15/03/2017', category: 'Main Course', freeDelivery: 'Yes' },
    { id: 2, name: 'Burger', price: 129, active: 'Yes', dateOfLaunch: '23/12/2017', category: 'Main Course', freeDelivery: 'No' },
    { id: 3, name: 'Pizza', price: 149, active: 'Yes', dateOfLaunch: '21/08/2017', category: 'Main Course', freeDelivery: 'No' },
    { id: 4, name: 'French Fries', price: 57, active: 'No', dateOfLaunch: '02/07/2017', category: 'Starter', freeDelivery: 'Yes' },
    { id: 5, name: 'Chocolate Brownies', price: 32, active: 'Yes', dateOfLaunch: '02/11/2022', category: 'Dessert', freeDelivery: 'Yes'}
];
/*var cart=[{ id: 1, name: 'Sandwich', price: 99, active: 'Yes', dateOfLaunch: '15/03/2017', category: 'Main Course', freeDelivery: 'Yes' },
{ id: 2, name: 'Burger', price: 129, active: 'Yes', dateOfLaunch: '23/12/2017', category: 'Main Course', freeDelivery: 'No' },
{ id: 3, name: 'Pizza', price: 149, active: 'Yes', dateOfLaunch: '21/08/2017', category: 'Main Course', freeDelivery: 'No' }];
*/
var cart=[];
var carti;

function editMenuAdmin()
{
    //window.alert("enter");
    var index;
    let gname=document.getElementById("title").value;
    console.log(foodMenu[0].price);
    console.log(gname);
    switch(gname)
    {
        case "Sandwich":index=0;break;
        case "Burger" : index=1;break;
        case "Pizza" : index=2;break;
        case "French Fries": index=3;break;
        case "Chocolate Brownies":index=4;break;
        default:break;
        
    }
    
    console.log(index);
    //FUNCTION CRASH FROM NEXT LINE OWNWARDS. 
    foodMenu[index].price=parseInt(document.getElementById("price").value);
    if(document.getElementById("Yes").checked)
        foodMenu[index].active="Yes";
    else
        foodMenu[index].active="No";
    foodMenu[index].dateOfLaunch=document.getElementById("DateOfLaunch").value;
var con=document.getElementById("category");
foodMenu[index].category=con.options[con.selectedIndex].value;
 foodMenu[index].freeDelivery=document.getElementById("check").value;
 alert("Changes Updated");
window.location.href="editMenu_item-status.html";
console.log(foodMenu[index]);
 
return false;
}

function createMenu(foodMenu)
{   console.log("create");
    for(var i=0;i<5;i++)
    {
        document.getElementById("tBodyAdmin").innerHTML+=`<tr><td>${foodMenu[i].name}</td>
        <td>${foodMenu[i].price}</td><td>${foodMenu[i].active}</td><td>${foodMenu[i].dateOfLaunch}</td>
        <td>${foodMenu[i].category}</td>
        <td>${foodMenu[i].freeDelivery}</td><td><a href="editMenu_item.html">Edit<a></td></tr>`;
        console.log(foodMenu[i]);    
    }
   
}
function createMenuAdmin()
{
    createMenu(foodMenu);
}

function addCart(carti)
{
    var item;
    console.log(foodMenu[0]);
    if(carti==0)
        item=foodMenu[0];
    else if(carti==1)
        item=foodMenu[1];
    else
        item=foodMenu[2];

    cart.push(item);

    // ITEM NOT PUSHING INTO CART.

    //let len=cart.length;
    //cart[len]=item;
    console.log("pushed");
    console.log(cart);
    window.location.href="menuItem-list-customer-notification.html";
   // window.location.assign("menuItem-list-customer-notification.html");
    return false;
}
 function cartDisplay(ids)
 {
     console.log(ids);
    var sum=0;
    for(var i=0;i<cart.length;i++)
     {
         document.getElementById(ids).innerHTML+=`<tr><td>${cart[i].name}</td>
         <td>${cart[i].freeDelivery}</td><td>${cart[i].price}</td><td><a onclick="${deleteItem(i)}" href="#">Delete<a></td></tr>`;
        sum+=cart[i].price;
        }
        document.getElementById(ids).innerHTML+=`<tr><td></td><td><b>Total</b></td><td>${sum}</td><tr>`;
 }

 function deleteItem(carti)
 {
     //called from-->>onclick="onclick="${deleteItem(i)}" in cartDisplay()
    if(cart.length== 0)
    window.location.href="cart_empty.html";
    else
    {
        console.log(carti);
        var cartii=parseInt(carti);
        for(var i=0;i<cart.length;)
        {
            if(cart[i].id==carti)
            {
                console.log(cart[i]);
                cart.splice(carti,1);
                break;
            }
        }
        window.location.href="cart-notification.html";
    }
 }