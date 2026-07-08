document.addEventListener("DOMContentLoaded", function () {

    const modalDesactivarUsuario =
        document.getElementById("modalDesactivarUsuario");

    if (modalDesactivarUsuario) {

        modalDesactivarUsuario.addEventListener(
            "show.bs.modal",
            function (event) {

                const boton = event.relatedTarget;

                const idUsuario =
                    boton.getAttribute("data-bs-id");

                const descripcion =
                    boton.getAttribute("data-bs-descripcion");

                document.getElementById("modalId").value =
                    idUsuario;

                document.getElementById(
                    "modalDescripcion"
                ).textContent = descripcion;
            }
        );
    }
});