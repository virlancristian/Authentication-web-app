const button = document.querySelector(".content button");

button.addEventListener('click', function() {
    const email = document.querySelector("#first input").value;
    const password = document.querySelector("#second input").value;
    const url = "";
    const formData = new URLSearchParams();

    formData.append("email", email);
    formData.append("password", password);

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: formData
    }).then((response) => response.json())
    .then((data) => {
        alert(data.message)

        if(data.id == 4) {
            localStorage.setItem('email', email);
            window.location.href = "account.html";
        }
    })
});