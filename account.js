const email = localStorage.getItem('email');

fetch("" + email, {
    method:'GET',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    }
}).then((response) => response.json())
.then((data) => {
    document.querySelector("#username").innerText = "Username: " + data.username;
    document.querySelector("#email").innerText = "E-mail: " + data.email;
})

const button = document.querySelector(".content button");

button.addEventListener('click', function() {
    localStorage.removeItem('email');
    window.location.href="login.html";
});