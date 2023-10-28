const sleep = (delay) => new Promise((resolve) => setTimeout(resolve, delay));

function resetForm() {
    document.getElementById("formAluno").reset();
}

function abrirModal(idModal) {
    document.getElementById(idModal).style.display = "block";
}

function fecharModal() {
    const modais = document.querySelectorAll(".modal");

    Array.from(modais).forEach(modal => {
        modal.style.display = "none";
    });
}

function mostrarImagem() {
    const imgPreview = document.getElementById("img-preview");
    const chooseFile = document.getElementById("foto");

    const file = chooseFile.files[0];

    if (file) {
        const fileReader = new FileReader();

        fileReader.onload = function () {
            const image = new Image();
            image.src = fileReader.result;
            image.alt = "Imagem selecionada";
            imgPreview.innerHTML = "";
            imgPreview.appendChild(image);
        };

        fileReader.readAsDataURL(file);
    }
}

function limparImagem() {
    document.getElementById("img-preview").innerHTML = "";
}

const root = document.documentElement;

if (localStorage.getItem("theme") === null) {
    localStorage.setItem("theme", "light");
}

setTimeout(toggleTheme, 1);

function invertTheme() {
    (localStorage.getItem("theme") == "light") ? localStorage.setItem("theme", "dark") : localStorage.setItem("theme", "light");
    setTimeout(toggleTheme, 1);
}

function toggleTheme() {
    if (localStorage.getItem("theme") == "light") {

        document.getElementById("btnTheme").src = "https://img.icons8.com/ios-glyphs/480/FFFFFF/sun--v1.png";

        root.style.setProperty('--main', 'var(--light-main)');
        root.style.setProperty('--main-hover', 'var(--light-main-hover)');
        root.style.setProperty('--bg', 'var(--light-bg)');
        root.style.setProperty('--h1', 'var(--light-h1)');
        root.style.setProperty('--h2', 'var(--light-h2)');
        root.style.setProperty('--shadow', 'var(--light-shadow)');
        root.style.setProperty('--tooltip', 'var(--light-tooltip)');
        root.style.setProperty('--input-hover', 'var(--light-input-hover)');
    } else if (localStorage.getItem("theme") == "dark") {

        document.getElementById("btnTheme").src = "https://img.icons8.com/ios-glyphs/480/moon-symbol.png";

        root.style.setProperty('--main', 'var(--dark-main)');
        root.style.setProperty('--main-hover', 'var(--dark-main-hover)');
        root.style.setProperty('--bg', 'var(--dark-bg)');
        root.style.setProperty('--h1', 'var(--dark-h1)');
        root.style.setProperty('--h2', 'var(--dark-h2)');
        root.style.setProperty('--shadow', 'var(--dark-shadow)');
        root.style.setProperty('--tooltip', 'var(--dark-tooltip)');
        root.style.setProperty('--input-hover', 'var(--dark-input-hover)');
    }
}

if (localStorage.getItem("theme") == "light") {

    document.addEventListener('DOMContentLoaded', function () {
        document.getElementById("btnTheme").src = "https://img.icons8.com/ios-glyphs/480/FFFFFF/sun--v1.png";
    });

    root.style.setProperty('--main', 'var(--light-main)');
    root.style.setProperty('--main-hover', 'var(--light-main-hover)');
    root.style.setProperty('--bg', 'var(--light-bg)');
    root.style.setProperty('--h1', 'var(--light-h1)');
    root.style.setProperty('--h2', 'var(--light-h2)');
    root.style.setProperty('--shadow', 'var(--light-shadow)');
    root.style.setProperty('--tooltip', 'var(--light-tooltip)');
    root.style.setProperty('--input-hover', 'var(--light-input-hover)');
} else if (localStorage.getItem("theme") == "dark") {

    document.addEventListener('DOMContentLoaded', function () {
        document.getElementById("btnTheme").src = "https://img.icons8.com/ios-glyphs/480/moon-symbol.png";
    });

    root.style.setProperty('--main', 'var(--dark-main)');
    root.style.setProperty('--main-hover', 'var(--dark-main-hover)');
    root.style.setProperty('--bg', 'var(--dark-bg)');
    root.style.setProperty('--h1', 'var(--dark-h1)');
    root.style.setProperty('--h2', 'var(--dark-h2)');
    root.style.setProperty('--shadow', 'var(--dark-shadow)');
    root.style.setProperty('--tooltip', 'var(--dark-tooltip)');
    root.style.setProperty('--input-hover', 'var(--dark-input-hover)');
}

async function preencherCampo() {

    document.getElementById("btnPesquisar").disabled = true;

    const campos = ["ra", "nome", "nomesocial", "nascimento", "email", "instituicao", "conclusao", "pontuacao", "posicao", "curso"];

    campos.forEach(async x => {
        const campo = document.getElementById(x);
        const cpf = document.getElementById("cpf").value;

        // Utilizar CPF e ID do campo para pegar os dados da pessoa e preencher a variável texto

        const texto = document.getElementById("cpf").value;

        campo.value = "";

        for (let i = 0; i < texto.length; i++) {
            const char = texto.charAt(i);
            campo.value += char;

            const delay = (texto.length * 1.50) - i;
            await sleep(delay);
        }
    });
    await sleep(1500);
    document.getElementById("btnPesquisar").disabled = false;
}