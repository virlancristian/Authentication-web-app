const button = document.querySelector(".content button");

button.addEventListener('click', function() {
    const username = document.querySelector("#first input").value;
    const email = document.querySelector("#second input").value;
    const password = document.querySelector("#third input").value;
    const cPassword = document.querySelector("#fourth input").value;

    if(password == cPassword) {
        var object = {
            "username": username,
            "email": email,
            "password": password
        };
    
        fetch("", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(object)
        }).then((response) => response.json())
        .then((data) => {
            alert(data.message);
            
            if(data.id == 1) {
                window.location.href = "login.html";
            }
        });
    } else {
        alert("Passwords don't match!");
    }
});