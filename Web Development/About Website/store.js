// DONT WRAP IN QUOTES, JAVASCRIPT DOESNT LIKE IT
// REMOVE BUTTONS FROM CART
// get (return) the buttons with the class name 'btn-danger' (document object is everything inside HTML)

// check if the document is still loading
if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready() // if done loading, run ready function
}

function ready() {
    var removeCartItemButtons = document.getElementsByClassName('btn-danger')
    console.log(removeCartItemButtons) // check to see if it works
    for (var i = 0; i < removeCartItemButtons.length; i++) { // loop through the buttons
        var button = removeCartItemButtons[i] // the actual button
        // add a listener to do something
        button.addEventListener('click', removeCartItem) // adds a click event and returns an event object inside function
    }

    var quantityInputs = document.getElementsByClassName('cart-quantity-input') // get the inputs for the quantity
    for (var i = 0; i < quantityInputs.length; i++) { // loop through the quantity inputs
        var input = quantityInputs[i] // get whatever input we are on
        input.addEventListener('change', quantityChanged)
    }

    var addToCartButtons = document.getElementsByClassName('shop-item-btn') // get the add to cart buttons
    for (var i = 0; i < addToCartButtons.length; i++) { // loop through the buttons
        var button = addToCartButtons[i] // get the actual button
        button.addEventListener('click', addToCartClicked)
    }

    document.getElementsByClassName('btn-purchase')[0].addEventListener('click', purchaseClicked)
}

// REMOVES THE ITEMS
function removeCartItem(event) {
    var buttonClicked = event.target // whatever button we clicked on
    buttonClicked.parentElement.parentElement.remove() // get the cart row the button is inside and remove it
    updateCartTotal() // call the function
}

// UPDATES THE TOTAL WHEN REMOVING ITEM
function updateCartTotal() {
    // gets the elements with the class name 'cart-items' (we only want the first element)
    var cartItemContainer = document.getElementsByClassName('cart-items')[0]
    var cartRows = cartItemContainer.getElementsByClassName('cart-row') // gets the 'cart-row' elements inside the 'cart-items'
    var total = 0
    for (var i = 0; i < cartRows.length; i++) { // Loop through the rows
        var cartRow = cartRows[i] // the actual row
        var priceElement = cartRow.getElementsByClassName('cart-price')[0] // get the price of row
        var quantityElement = cartRow.getElementsByClassName('cart-quantity-input')[0]
        var price = parseFloat(priceElement.innerText.replace('$', '')) // gets whatever text inside element (turns string into float)
        var quantity = quantityElement.value // want the value number of input (input doesn't have text inside)
        total = total + (price * quantity)
    }
    total = Math.round(total * 100) / 100
    // get element with cart total price and set inner text of the element to the total
    document.getElementsByClassName('cart-total-price')[0].innerText = '$' + total
}

// CHANGES THE QUANTITY OF ITEMS
function quantityChanged(event) {
    var input = event.target // whatever input element we need
    // check to see if the value is a number or less than/equal to 0 ('isNaN' stands for is not a number)
    if(isNaN(input.value) || input.value <= 0) {
        input.value = 1;
    }
    updateCartTotal()
}

// ADD THE ITEMS TO THE CART
function addToCartClicked(event) {
    var button = event.target // whatever button we clicked on
    var shopItem = button.parentElement.parentElement // access the shop item div
    var title = shopItem.getElementsByClassName('shop-item-title')[0].innerText
    var price = shopItem.getElementsByClassName('shop-item-price')[0].innerText
    var imageSrc = shopItem.getElementsByClassName('shop-item-image')[0].src
    addItemToCart(title, price, imageSrc) // calls method
    updateCartTotal()
}

// ADDS A ROW FOR THE ITEM
function addItemToCart(title, price, imageSrc) {
    var cartRow = document.createElement('div') // set to new element, allows us to create an element
    cartRow.classList.add('cart-row') // add the class to the cart row
    var cartItems = document.getElementsByClassName('cart-items')[0]
    var cartItemNames = cartItems.getElementsByClassName('cart-item-title') // get the title of the items
    for (var i = 0; i < cartItemNames.length; i++) {
        if (cartItemNames[i].innerText == title) {
            alert('This item is already added to the cart')
            return
        }
    }
    var cartRowContents = `
    <div class="cart-item cart-column">
        <img class="cart-item-image" src="${imageSrc}" width="100" height="100">
        <span class="cart-item-title">${title} Album</span>
    </div>
    <span class="cart-price cart-column">${price}</span>
    <div class="cart-quantity cart-column">
        <input class="cart-quantity-input" type="number" value="1">
        <button class="btn btn-danger" type="button">Remove</button>
    </div>`
    cartRow.innerHTML = cartRowContents // set the empty cart row to the content of the item we want to add
    cartItems.append(cartRow) // adds the cart row to the end of cart items
    cartRow.getElementsByClassName('btn-danger')[0].addEventListener('click', removeCartItem) // makes the remove button work
    cartRow.getElementsByClassName('cart-quantity-input')[0].addEventListener('change', quantityChanged) // makes the quantity work
}

function purchaseClicked() {
    alert('Thank you for your purchase')
    var cartItems = document.getElementsByClassName('cart-items')[0]
    // while the cart items has children
    while (cartItems.hasChildNodes()) {
        cartItems.removeChild(cartItems.firstChild) // remove the very first child in cart items
    }
    updateCartTotal()
}