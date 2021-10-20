function checkUsername() {
    const username = document.getElementById("username")
    const xml = new XMLHttpRequest()

    if (username.value.length < 3)  {
        document.getElementById("username-size-error").style.display = "block"
        document.getElementById("lgn").disabled = true
    } else {
        document.getElementById("username-size-error").style.display = "none"
        document.getElementById("lgn").disabled = false
    }

    xml.open("GET", "http://localhost:8080/logInCheck?username=" + username.value, false)
    xml.send()

    const result = xml.responseText;

    if (result === "true") {
        document.getElementById("username-error").style.display = "none"
        document.getElementById("lgn").disabled = false
    }

    if (xml.status !== 200) {
        document.getElementById("username-error").style.display = "block"
        document.getElementById("lgn").disabled = true
    } else {
        if (result === "false") {
            document.getElementById("username-error").style.display = "block"
            document.getElementById("lgn").disabled = true
        }
    }
}

function checkPasswords() {
    const password = document.getElementById("password")
    const secondPassword = document.getElementById("password-two")

    if (password.value !== secondPassword.value) {
        document.getElementById("password-error").style.display = "block"
        document.getElementById("lgn").disabled = true
    } else {
        document.getElementById("password-error").style.display = "none"
        document.getElementById("lgn").disabled = false
    }
    checkUsername()
}