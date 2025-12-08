document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Credenciales válidas (esto es solo un ejemplo, no es seguro)
    if (username === 'admin' && password === '1234') {
        window.location.href = 'portafolio.html'; // Redirige al portafolio
    } else {
        alert('Usuario o contraseña incorrectos');
    }
});