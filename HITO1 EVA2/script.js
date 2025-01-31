document.getElementById('registroForm').addEventListener('submit', function(event) {
    const edad = parseInt(document.querySelector('input[name="edad"]').value);
    const paqueteAdicional = document.querySelector('select[name="paquete_adicional"]').value;
    const planBase = document.querySelector('select[name="plan_base"]').value;
    const duracion = document.querySelector('select[name="duracion"]').value;

    if (edad < 18 && paqueteAdicional !== 'Infantil') {
        alert("Los usuarios menores de 18 años solo pueden contratar el Pack Infantil.");
        event.preventDefault();
    } else if (planBase === 'Básico' && paqueteAdicional) {
        alert(" Los usuarios del Plan Básico solo pueden seleccionar un paquete adicional.");
        event.preventDefault();
    } else if (paqueteAdicional === 'Deporte' && duracion !== 'Anual') {
        alert("El Pack Deporte solo puede ser contratado si la duración de la suscripción es de 1 año.");
        event.preventDefault();
    }
});